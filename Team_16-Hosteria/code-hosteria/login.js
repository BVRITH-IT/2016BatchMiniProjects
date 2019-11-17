var express = require('express');
var session	= require('express-session');
var path=require('path');
var app=express();
var mysql = require('mysql');
var fs = require('fs');
var bodyParser=require('body-parser');
var adminJS = require('./nodeAdmin.js');
var handyManJS=require('./nodeHandyMan.js');
var studentJS=require('./nodeStudent.js');
app.use(bodyParser());
var MySQL_Connection_Details;
var con;
fs.readFile('MySQL_Connection_Details','utf8',function(err, data) {
    MySQL_Connection_Details=JSON.parse('{'+data+'}');
	con = mysql.createConnection(
		MySQL_Connection_Details
	);
	con.connect(function(err) {
	  if (err){ 
	  	console.log("Error!") 
	  	throw err;
	  }
	  console.log("Connected!");
	});
});


app.use(express.static(__dirname + '/dist'));
app.use(express.static(__dirname + ''));
app.use(express.static(__dirname + '/fa'));
app.get('/',function(req,resp){
	
	resp.sendFile(path.resolve('index.html'));
	return;
	//console.log(req);
	//console.log(resp);
});

app.get('/w3cc.html',function(req,resp){
	resp.sendFile('studen.html',{root: path.join(__dirname, '')});
})

app.get('/admin.html',function(req,resp){
	resp.sendFile('admin.html',{root: path.join(__dirname, '')});
})
// app.get('/main.html',function(req,resp){
// 	resp.sendFile('main.html',{root: path.join(__dirname, '')});
// })

app.get('/getData',function(req,resp){
	var sess=req.query;
	//console.log(sess);
	if(sess.email && sess.type=='S')
		{
		
		var sql = "SELECT * FROM student_info WHERE email='"+sess.email+"'";
		con.query(sql, function (err, result) {
		    if (err){ 
		    	console.log(err);
		    	resp.end("false");
		    	return;
		    		}
		    //console.log(result.length);
		    if(result.length==0){
		    	resp.end("false");
		    	return;
		    }
		    resp.end(JSON.stringify(result));
		    return;
	  	});
		
		}
	else if(sess.email && sess.type=='H')
		{
		var sql = "SELECT * FROM handyman_info WHERE email='"+sess.email+"'";
		con.query(sql, function (err, result) {
		    if (err){ 
		    	console.log(err);
		    	resp.end("false");
		    	return;
		    		}
		    //console.log(result.length);
		    if(result.length==0){
		    	resp.end("false");
		    	return;
		    }
		    resp.end(JSON.stringify(result));
		    return;
	  	});
		//resp.sendFile(path.resolve('views/index.html'));
		}
	else if(sess.email && sess.type=='A')
		{
		var sql = "SELECT * FROM admin_info WHERE email='"+sess.email+"'";
		con.query(sql, function (err, result) {
		    if (err){ 
		    	console.log(err);
		    	resp.end("false");
		    	return;
		    		}
		    //console.log(result.length);
		    if(result.length==0){
		    	resp.end("false");
		    	return;
		    }
		    resp.end(JSON.stringify(result));
		    return;
	  	});
		}
	else
		{
			resp.end("false");
		}
	
	//console.log(req);
	//console.log(resp);
})

app.post('/signup',function(req,resp){
	var values=req.body;
	var sql = "INSERT INTO student_info (name,email, password, roll_no, phone_no, room_no, gender) VALUES ('"+values.name+"','"+values.email+"','"+values.password+"','"+values.rollno+"','"+values.phoneno+"','"+values.roomno+"','"+values.gender+"')";
  	//resp.end(next);
  	con.query(sql, function (err, result) {
	    if (err){ 
	    	console.log(err);
	    	resp.end("false");
	    	return;
	    }
	    console.log("1 record inserted");
	    resp.end("true");
	    return;
  	});
  	//resp.end("Error Check feilds");
})

app.get('/signin',function(req,resp){
	var values=req.query;
	var sess=values;
	//console.log(sess.type);
	if(sess.type=="S"){
		var sql = "SELECT * FROM student_info WHERE email='"+values.email+"' and password='"+values.password+"'";
	  	con.query(sql, function (err, result) {
		    if (err){ 
		    	console.log(err);
		    	resp.end("false");
		    	return;
		    }
		    //console.log(result.length);
		    if(result.length==0){
		    	resp.end("false");
		    	return;
		    }
		    resp.end(JSON.stringify(result));
		    return;
	  	});
  	}
  	else if(sess.type=="H"){
		var sql = "SELECT * FROM handyman_info WHERE email='"+values.email+"' and password='"+values.password+"'";
	  	con.query(sql, function (err, result) {
		    if (err){ 
		    	console.log(err);
		    	resp.end("false");
		    	return;
		    }
		    //console.log(result.length);
		    if(result.length==0){
		    	resp.end("false");
		    	return;
		    }
		    resp.end(JSON.stringify(result));
		    return;
	  	});
  	}
  	else if(sess.type=="A"){
		var sql = "SELECT * FROM admin_info WHERE email='"+values.email+"' and password='"+values.password+"'";
	  	con.query(sql, function (err, result) {
		    if (err){ 
		    	console.log(err);
		    	resp.end("false");
		    	return;
		    }
		    //console.log(result.length);
		    if(result.length==0){
		    	resp.end("false");
		    	return;
		    }
		    resp.end(JSON.stringify(result));
		    return;
	  	});
  	}
  	else{
  		resp.end("false");
		return;
  	}
})

app.get('/logout',function(req,resp){
	resp.end("true");
});

app.post('/userLodge',function(req,res){
	var value=req.body;
	console.log(value);
	var cost=0;
	var otp=parseInt((new Date()/1000)*Math.random())%10000+42;
    //console.log(x);
	if(value.type=="personnel")
		cost=20;
	var sql="Insert into complaint_info(student_id,subject,description,type,catagory,time_slot,date,cost,otp,descriptionFull)" +
			"values('"+value.student_id+"','"+value.subject+"','"+value.description+"','"+value.type+"','"+value.category+"','"+value.time_slot+"',NOW(),"+cost+","+otp+",'"+value.descriptionFull+"')";
	//"values('1','abc','desc','hostel','carpenter','9-10')";
	con.query(sql,function(err,result){
		 if (err){ 
	    	console.log(err);
	    	res.end("false");
	    	return;
	    }
		 console.log("1 complaint registered");
		 res.end("true");
		 return;
	})
})

app.get('/complaintHandymanType',function(req,res){
	var value=req.query;
	var type=value.type;
	var sql="select handman,equipment from master_data where owner='"+type+"'";
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
	})
})

app.get('/userComplaintHistory',function(req,res){
	var value=req.query;
	var s_id=value.student_id;
	var status=value.type;
	//console.log(value);
	if(status==-1){
		status='(0,1,2,3)';
	}
	else{
		status="("+status+")";
	}
	var sql="select * from complaint_info c,handyman_info h where student_id='"+s_id+"' and status in "+status+" and h.handyman_id=c.handyman_id order by status";
	con.query(sql,function(err,result){
		if(err)
		{
			console.log(err);
			res.end("false");
			return;
		}
		else if(status=="(0)" || status=="(0,1,2,3)")
		{
			sql="select * from complaint_info c where student_id='"+s_id+"' and handyman_id is null order by status;"
		 	var finalResult=result;
		 	con.query(sql,function(err,result){
		 		if(err!=null){
		 			console.log(err);
		 			return;
		 		}
		 		// console.log(finalResult);
		 		// console.log("--------------------------");
		 		// console.log(result);
		 		res.send(JSON.stringify(result.concat(finalResult)));
		 		return;
		 });
	     return;
		}
		res.end(JSON.stringify(result));
	})
})

app.get('/userFeedback',function(req,res){
	var value=req.query;
	//console.log(value);
	var review=value.review;
	var rating=value.rating;
	var id=value.id;
	var sql="update complaint_info set rating="+rating+",feedback='"+review+"',status=3 where complaint_id="+id;
	con.query(sql,function(err,result){
		if(err)
		{
			console.log(err);
			res.end("false");
			return;
		}
		else
		{
		 res.end("true");
	     return;
		}
	})
});

app.get('/userComplaintAnalytics',function(req,res){
	var value=req.query;
	//console.log(value);
	var sql="select count(*) as total from complaint_info where student_id="+value.student_id+" union select count(*) as solved from complaint_info where student_id="+value.student_id+" and status>=2";

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
});

app.get('/generateWork',function(req,res){
	var values=req.query;
	var ids="("
	for(i in values)
		ids+=i.split("_")[1]+",";
	ids+="-1)";
	adminJS.assign(ids,res,con);
});

app.get('/changeStudentPass',function(res,req){
	studentJS.changeStudentPassword(res,req,con);
});

app.get('/changeStudentPhone',function(res,req){
	studentJS.changeStudentPhone(res,req,con);
});

app.get('/changeAdminPass',function(res,req){
	adminJS.changeAdminPassword(res,req,con);
});

app.get('/changeAdminPhone',function(res,req){
	adminJS.changeAdminPhone(res,req,con);
});

app.get('/adminComplaintAnalysis',function(res,req){
	adminJS.adminComplaintAnalysis(res,req,con);
});

app.get('/adminGetAllHistory',function(req,res){
	adminJS.getAllHistory(req,res,con);
})

app.get('/adminGetAllHandyManInfo',function(req,res){
	adminJS.getHandyManInfo(req,res,con);
});

app.get('/getHandyManRating',function(req,res){
	adminJS.getHandyManRating(req,res,con);
});

app.get('/getAllEquipment',function(req,res){
	adminJS.getAllEquipment(req,res,con);
});

app.get('/adminGetIndexPageData',function(req,res){
	adminJS.adminGetIndexPageData(req,res);
})

app.get('/handyManGetWork',function(req,res){
	//console.log(req.query);
	handyManJS.getWork(req,res,con);
});

app.get('/handyManComplaintSolved',function(req,res){
	//console.log(req.query);
	handyManJS.complaintSolved(req,res,con);
});

app.get('/handyManComplaintHistory',function(req,res){
	handyManJS.complaintHistory(req,res,con);
});

app.get('/changeHandymanPass',function(res,req){
	handyManJS.changeHandymanPassword(res,req,con);
});

app.get('/changeHandymanPhone',function(res,req){
	handyManJS.changeHandymanPhone(res,req,con);
});



app.listen(8000,function(){
	console.log('listening');
});
