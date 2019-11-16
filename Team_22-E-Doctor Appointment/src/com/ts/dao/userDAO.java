package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;

import com.ts.dto.registerDTO;


public class userDAO {
public registerDTO getuser(String uname,String pwd, String utype){
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rst = null;
	registerDTO user=null;
final String SELECT_QUERY = "select * from registered_details where uname = ? and pwd = ?";
try{
	con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setString(1, uname);
	pst.setString(2, pwd);
	rst = pst.executeQuery();
	if(rst.next()){
		 user=new registerDTO();
		 user.setuname(rst.getString(1));
		 user.setpwd(rst.getString(2));
		 user.setutype(rst.getString(3));
	//System.out.println(user);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return user;
}

public static boolean add(boolean b) {
	
	return false;
}
}