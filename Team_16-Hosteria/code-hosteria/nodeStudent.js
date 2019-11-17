
function changeStudentPassword(req,res,con){
	var student_id=req.query.student_id;
	var old_pass=req.query.old_Pass;
	var new_pass=req.query.new_Pass;
	var sql="update student_info set password=? where student_id=? and password=?";
	con.query(sql,[new_pass,student_id,old_pass],function(err,result){
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

function changeStudentPhone(req,res,con){
	var student_id=req.query.student_id;
	var phone=req.query.new_phone;
	var sql="update student_info set phone_no=? where student_id=?";
	con.query(sql,[phone,student_id],function(err,result){
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
	changeStudentPassword:function(req,res,con){
		changeStudentPassword(req,res,con);
	},
	changeStudentPhone:function(req,res,con){
		changeStudentPhone(req,res,con);
	}
}
