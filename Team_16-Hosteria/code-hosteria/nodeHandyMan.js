function getWork(req,res,con){
	var value=req.query;
	var id=value.handyman_id;
	var sql="select complaint_id,c.student_id,subject,gender,date,type,catagory,cost,description,time_slot,descriptionFull,email,phone_no,room_no,name from complaint_info as c,student_info as s where handyman_id="+id+" and status<2 and c.student_id=s.student_id order by complaint_id;"
	con.query(sql,function(err,result){
		if(err!=null){
			res.end(String(err));
			return;
		}
		res.end(JSON.stringify(result));
		return;
	});
}

function complaintSolved(req,res,con){
	var value=req.query;
	var complaint_id=value.complaint_id;
	var otp=value.otp;
	var handyman_id=value.handyman_id;
	var sql="update complaint_info set status=2 where complaint_id="+complaint_id+" and otp="+otp;
	con.query(sql,function(err,result){
		if(err!=null){
			res.end("false");
			return;
		}
		if(result.affectedRows==0){
			res.end("Wrong OTP");
			return;
		}
		if(result.changedRows==0){
			res.end("Reload");
			return;
		}
		sql="update handyman_info set solved=solved+1,today=today+1 where handyman_id="+handyman_id;
		con.query(sql,function(err,result){
			if(err!=null){
				res.end("false");
				return;
			}
			else{
				res.end("true");
			}
		});
		
	});
}


function complaintHistory(req,res,con){
	var handyman_id=req.query.handyman_id;
	var type=req.query.type;
	var status="(1,2,3)";
	if(type=="Solved"){
		status="(2,3)";
	}
	if(type=="Unsolved"){
		status="(1)";
	}
	//console.log(type);
	var sql="select * from complaint_info c,student_info s where handyman_id=? and status in "+status+" and c.student_id=s.student_id order by complaint_id";
		con.query(sql,[[handyman_id]],function(err,result){
		if(err){
			res.end(JSON.stringify(err));
		}
		res.end(JSON.stringify(result));
	})
}


function changeHandymanPassword(req,res,con){
	var handyman_id=req.query.handyman_id;
	var old_pass=req.query.old_Pass;
	var new_pass=req.query.new_Pass;
	var sql="update handyman_info set password=? where handyman_id=? and password=?";
	con.query(sql,[new_pass,handyman_id,old_pass],function(err,result){
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

function changeHandymanPhone(req,res,con){
	var handyman_id=req.query.handyman_id;
	var phone=req.query.new_phone;
	var sql="update handyman_info set phone_no=? where handyman_id=?";
	con.query(sql,[phone,handyman_id],function(err,result){
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

module.exports={
	getWork:function(req,res,con){
		getWork(req,res,con);
	},
	complaintSolved:function(req,res,con){
		complaintSolved(req,res,con);
	},
	complaintHistory:function(req,res,con){
		complaintHistory(req,res,con);
	},
	changeHandymanPassword:function(req,res,con){
		changeHandymanPassword(req,res,con);
	},
	changeHandymanPhone:function(req,res,con){
		changeHandymanPhone(req,res,con);
	}
}
