var fs=require('fs');

function getAllEquipment(req,res,con){
	var sql="select distinct(equipment) from master_data";
	con.query(sql,function(err,result){
		if(err){
			console.log(err);
			res.end("false");
		}
		res.end(JSON.stringify(result));
	})
}

function getAllHistory(req,res,con){
	var values=req.query;
	var sInfoRadio=values.sInfoRadio;
	var sInfoValue="";
	var handyman_id="";
	try{
		sInfoValue=values.sInfoValue.trim();
	}
	catch(err){
		sInfoValue=""
	}
	try{
		handyman_id=values.handyman_id.trim();
	}
	catch(err){
		handyman_id=""
	}
	//console.log(sInfoValue+" "+sInfoRadio);
	//?subject=any&catagory=any&time_slot=any&type=any&status=any&rating=any
	var subject=values.subject.trim();
	var catagory=values.catagory.trim();
	var time_slot=values.time_slot.trim();
	var type=values.type.trim();
	var status=values.status.trim();
	var rating=values.rating.trim();
	var sql="select * from complaint_info c,handyman_info h,student_info s where c.handyman_id=h.handyman_id and c.student_id=s.student_id ";
	if(handyman_id!=""){
		sql+="and c.handyman_id="+handyman_id+" ";
	}
	if(sInfoValue!=""){
		if(sInfoRadio=="name"){
			sql+="and s.name='"+sInfoValue+"' ";
		}
		if(sInfoRadio=="roll"){
			sql+="and roll_no='"+sInfoValue+"' ";
		}
		if(sInfoRadio=="room"){
			var r=sInfoValue.split(" ")[1];
			var g=sInfoValue.split(" ")[0];
			//console.log(r+" "+g);
			sql+="and room_no="+r+" and gender='"+g+"' ";
		}
	}
	if(subject!="Any"){
		sql+="and subject='"+subject+"' ";
	}
	if(catagory!="Any"){
		sql+="and c.catagory='"+catagory+"' ";
	}
	if(time_slot!="Any"){
		sql+="and time_slot='"+time_slot+"' ";
	}
	if(type!="Any"){
		sql+="and type='"+type+"' ";
	}
	if(status!="Any"){
		if(status=="Lodged")
			status="(0)";
		if(status=="Unsolved")
			status="(0,1)";
		if(status=="Progress")
			status="(1)";
		if(status=="Solved")
			status="(2,3)";
		if(status=="Closed")
			status="(3)";
		sql+="and status in "+status+" ";
	}
	if(rating!="Any"){
		if(rating=="Poor")
			rating="(1,2)";
		if(rating=="Average")
			rating="(3)";
		if(rating=="Good")
			rating="(4,5)";
		sql+="and rating in "+rating+" ";
	}

	con.query({sql:sql,nestTables: true},function(err,result){
		if(err){
			console.log(err);
			res.end("false");
		}
		res.end(JSON.stringify(result));
	})
};

function assignWorkHelper(Data,slot,result,status,res,con){
	var id=null;
	var min=10;
	var sequence=-1;
	for(i in Data){
		if(min>Data[i][slot]){
			min=Data[i][slot];
			id=Data[i]['handyman_id'];
			sequence=i;
		}
	}
	if(min>=5)
		return -1;
	else{
		if(status==0)
			var sql="update complaint_info set handyman_id="+id+", status=1 ,assignDate=NOW() where complaint_id="+result.complaint_id;
		else
			var sql="update complaint_info set handyman_id="+id+", status=1 where complaint_id="+result.complaint_id;
		con.query(sql,function(err,result){
			if(err){
				console.log(err);
				res.end("false");
				return;
			}
			else{
				if(result.affectedRow==1){
					return sequence;
				
				}
				return sequence;
			}
		});
	}
	return sequence;
}

function assignWork(electricianData,carpenterData,maidData,con,res){
	var sql="select complaint_id,time_slot,catagory,status from complaint_info where status<2";
	con.query(sql,function(err,result){
		if(err){
			console.log(err);
			res.end("false");
			return;
		}
		else{
			//console.log(result);
			var slot="slot1";
			var e=0;
			var c=0;
			var m=0;
			for(i in result){
				if(result[i].time_slot=="10:00-12:00")
					slot="slot1";
				if(result[i].time_slot=="13:00-15:00")
					slot="slot2";
				if(result[i].time_slot=="16:00-18:00")
					slot="slot3";
				if(result[i].catagory=="Electrician" ){
					e=assignWorkHelper(electricianData,slot,result[i],result[i].status,res,con);
					//console.log("e="+e)
					if(e>=0){
						electricianData[e][slot]++;
						electricianData[e]['issued']++;
					}
				}
				else if(result[i].catagory=="Carpenter" ){
					c=assignWorkHelper(carpenterData,slot,result[i],result[i].status,res,con);
					if(c>=0){
						carpenterData[c][slot]++;
						carpenterData[c]['issued']++;
					}
				}
				else if(result[i].catagory=="Maid"){
					m=assignWorkHelper(maidData,slot,result[i],result[i].status,res,con);
					if(m>=0){
						maidData[m][slot]++;
						maidData[m]['issued']++;
					}
				}
			}
			for(i in electricianData){
				sql="update handyman_info set slot1="+electricianData[i]['slot1']+",slot2="+electricianData[i]['slot2']+",slot3="+electricianData[i]['slot3']+",issued="+electricianData[i]['issued']+" where handyman_id="+electricianData[i]['handyman_id'];
			
				con.query(sql,function(err,result){
					if(err!=null){
						console.log(err);
						res.end("false");
						return;
					}
				});
			}
			for(i in carpenterData){
				//console.log(electricianData[i]['handyman_id']);
				//console.log(electricianData[i]['issued']);
				sql="update handyman_info set slot1="+carpenterData[i]['slot1']+",slot2="+carpenterData[i]['slot2']+",slot3="+carpenterData[i]['slot3']+",issued="+carpenterData[i]['issued']+" where handyman_id="+carpenterData[i]['handyman_id'];
				//sql="update handyman_info set slot1="+electricianData[i]['slot1']+",slot2="+electricianData[i]['slot2']+",slot3="+electricianData[i]['slot3']+",issued=issued+"+electricianData[i]['issued']+"where handyman_id="+electricianData[i]['handyman_id'];
				con.query(sql,function(err,result){
					if(err!=null){
						console.log(err);
						res.end("false");
						return;
					}
				});
			}
			for(i in maidData){
				sql='upadate handyman_info set slot1='+maidData[i]['slot']+"slot2="+maidData[i]['slot2']+",slot3="+maidData[i]['slot3']+",issued="+maidData[i]['issued']+" where handyman_id="+maidData[i]['handyman_id'];
				con.query(sql, function(err,result){
					if(err!=null){
						console.log(err);
						res.end("false");
						return;
					}
				});
			}
		}
		
	});
}


function changeAdminPassword(req,res,con){
	var admin_id=req.query.admin_id;
	var old_pass=req.query.old_Pass;
	var new_pass=req.query.new_Pass;
	var sql="update admin_info set password=? where admin_id=? and password=?";
	con.query(sql,[new_pass,admin_id,old_pass],function(err,result){
		if(err!=null){
			console.log(err);
			res.end("false");
		}
		else if(result.affectedRows==1)
			res.end("true");
		else
			res.end("old");
	})
};

function changeAdminPhone(req,res,con){
	var admin_id=req.query.admin_id;
	var phone=req.query.new_phone;
	var sql="update admin_info set phone_no=? where admin_id=?";
	con.query(sql,[phone,admin_id],function(err,result){
		if(err!=null){
			console.log(err);
			res.end("false");
		}
		else if(result.affectedRows==1)
			res.end("true");
		//console.log(result);
		//console.log(req.query);
	})
};

function adminComplaintAnalysis(req,res,con){
	var sql="select count(*) as total from complaint_info union select count(*) as solved from complaint_info where status>=2";

	con.query(sql,function(err,result){
		if(err)
		{
			console.log(err);
			res.end("false");
			return;
		}
		else
		{
		 res.end(JSON.stringify(result));
	     return;
		}
	});
}

function adminGetIndexPageData(req,res){
	fs.readFile('Help_Details','utf8',function(err, data) {
    	Help_Details='{'+data+'}';
		res.end(Help_Details);
	});
}

module.exports={
	assign: function(req,res,con){
		//return "yes";
		var ids=req;
		var maidData=[];
		var carpenterData=[];
		var electricianData=[];
		var sendData={};
		var sql="update handyman_info set slot1=0,slot2=0,slot3=0,today=0;"
		con.query(sql,function(err,result){
			if(err!=null){
				console.log(err);
				res.end("false");
			}
			sql="select * from handyman_info where Catagory='Electrician' and handyman_id in "+ids;
			con.query(sql,function(err,result){
				if(err!=null){
					console.log(err);
					res.end("false");
					return;
				}
				else{
					for(i in result){
						electricianData.push(result[i]);
					}
					sendData.electrician=electricianData;
					sql="select * from handyman_info where Catagory='Carpenter' and handyman_id in "+ids;
					con.query(sql,function(err,result){
						if(err){
							console.log(err);
							res.end("false");
							return;
						}
						else{
							for(i in result){
								carpenterData.push(result[i]);
							}
							sendData.carpenter=carpenterData;
							sql="select * from handyman_info where Catagory='Maid' and handyman_id in "+ids;
							con.query(sql,function(err,result){
								if(err){
									console.log(err);
									res.end("false");
									return;
								}
								else{
									for(i in result)
										maidData.push(result[i]);
										sendData.maid=maidData;
										assignWork(electricianData,carpenterData,maidData,con,res);
								}
							});
						}
					res.end("true");
					return;
					});
				}
			});
		});
	},

	getHandyManInfo: function(req,res,con){
		var sql="select * from handyman_info";
		con.query(sql,function(err,result){
			if(err!=null){
				console.log(err);
				res.end("false");
			}
			res.end(JSON.stringify(result));
			return;
		});
	},
	getHandyManRating:function(req,res,con){
		var handyman_id=req.query.handyman_id;
		//console.log(req.query);
		var sql="select round(avg(rating),2) as rating from complaint_info where handyman_id="+handyman_id+" and rating is not null and rating<>0"
		con.query(sql,function(err,result){
			if(err!=null){
				//console.log(err);
				res.end("false");
				return false;
			}
			res.end(JSON.stringify(result));
		});
	},
	getAllHistory:function(req,res,con){
		getAllHistory(req,res,con);
	},

	getAllEquipment:function(req,res,con){
		getAllEquipment(req,res,con);
	},

	changeAdminPassword:function(req,res,con){
		changeAdminPassword(req,res,con);
	},

	changeAdminPhone:function(req,res,con){
		changeAdminPhone(req,res,con);
	},

	adminComplaintAnalysis:function(req,res,con){
		adminComplaintAnalysis(req,res,con);
	},

	adminGetIndexPageData:function(req,res){
		adminGetIndexPageData(req,res);
	}
}
