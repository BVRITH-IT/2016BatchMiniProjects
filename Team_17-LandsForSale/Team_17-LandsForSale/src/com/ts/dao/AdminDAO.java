package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ts.dbutility.DBConnection;

import bvrit.Admin;


public class AdminDAO {
	public Admin getAdmin(int id){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		 Admin admin=null;
	final String SELECT_QUERY = "select * from admin where id = ? , password = ? ";
	try{
		con = DBConnection.getConnection();
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, id);
		rst = pst.executeQuery();
		if(rst.next()){
			 admin=new Admin();
			 admin.setId(rst.getInt(1));
			 admin.setPassword(rst.getString(2));
		     
	 		System.out.println(admin);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return admin;
	}

public int add(Admin admin){
	final String INSERT_QUERY="insert into admin(id,password) values(?,?)";
	PreparedStatement pst = null;
	
	int status=0;
	
	try {
Connection con=DBConnection.getConnection();

		pst=con.prepareStatement(INSERT_QUERY);
		pst.setInt(1, admin.getId());
		pst.setString(2, admin.getPassword());
		
		
		
		status=pst.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return status;
}


public Admin getAdmin(int id,String password){

PreparedStatement pst = null;
ResultSet rst = null;
Admin admin=null;
final String SELECT_QUERY = "select * from  admin where id = ? , password = ?";
try(Connection con = DBConnection.getConnection();){

pst = con.prepareStatement(SELECT_QUERY);
pst.setInt(1, id);
pst.setString(2, password);


rst = pst.executeQuery();
if(rst.next()){
	 admin=new Admin();
	 admin.setId(rst.getInt(1));
	 admin.setPassword(rst.getString(2));
	 
	 	System.out.println(admin);
}
} catch (SQLException e) {
e.printStackTrace();
}
return admin;
}


public List<Admin> getAllAdmin(){
List<Admin> list=new ArrayList<>();

PreparedStatement pst = null;
ResultSet rst = null;
final String SELECT_QUERY = "select * from admin ";
try{
Connection con = DBConnection.getConnection();
pst = con.prepareStatement(SELECT_QUERY);
rst = pst.executeQuery();
while(rst.next()){
	Admin admin=new Admin();
	admin.setId(rst.getInt(1));
	admin.setPassword(rst.getString(2));
	
	
	list.add(admin);
}
} catch (SQLException e) {
e.printStackTrace();
}
return list;
}

public void delete(int id) {
	Connection con=null;
	PreparedStatement pst=null;
	final String SELECT_QUERY="delete from Admin where id=?";
	try {
		con=DBConnection.getConnection();
		pst=con.prepareStatement(SELECT_QUERY);
		pst.setInt(1,  id);
		pst.executeUpdate();
	} catch(Exception e) {
		System.out.println(e);
	}
	
	}

public int editAdmin(Admin admin) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
try {
	con = DBConnection.getConnection();
	pst = con.prepareStatement("update admin set password= ? where id=?");
	
	pst.setInt(3, admin.getId());
	pst.setString(1,admin.getPassword());
	
	x = pst.executeUpdate();
	System.out.println("Inside Update....."+admin);
} catch (SQLException e) {				
	e.printStackTrace();
}	
finally{
	try {
		con.close();
	} catch (SQLException e) {				
		e.printStackTrace();
	}
}
return x;
}

}











