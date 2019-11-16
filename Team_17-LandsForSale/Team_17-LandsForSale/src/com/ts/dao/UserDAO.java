package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.dbutility.DBConnection;

import bvrit.User;
public class UserDAO {
	public User getUser(int id){
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		User user=null;
	final String SELECT_QUERY = "select * from user where id = ? , name = ? , email = ? , password = ? , phone = ?, houseno = ? ,colony = ? , city = ? and pincode = ?";
			try{
		con = DBConnection.getConnection();
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, id);
			
 rst = pst.executeQuery();
		if(rst.next()){
			 user=new User();
			 user.setId(rst.getInt(1));
			 user.setName(rst.getString(2));
			 user.setEmail(rst.getString(3));
			 user.setPassword(rst.getString(4));
			 user.setPhone(rst.getLong(5));
			 user.setHouseNo(rst.getInt(6));
			 user.setColony(rst.getString(7));
			 user.setCity(rst.getString(8));
			 user.setPincode(rst.getInt(9));
		System.out.println(user);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
	}
	public int add(User user){
		final String INSERT_QUERY="insert into user(id,name,email,password,phone,houseNo,colony,city,pincode) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setLong(5, user.getPhone());
			pst.setInt(6, user.getHouseNo());
			pst.setString(7, user.getColony());
			pst.setString(8, user.getCity());
			pst.setInt(9, user.getPincode());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
public User getUser(int id,String name,String email,String password,int phone,int houseno,String colony,String city,int pincode){
	
	PreparedStatement pst = null;
	ResultSet rst = null;
	User user=null;
final String SELECT_QUERY = "select * from user where id = ? , name = ?,email = ?, password = ?,phone = ?,houseno = ?,colony = ?,city = ?,pincode = ?)";
try(Connection con = DBConnection.getConnection();){
	
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setInt(1, id);
	pst.setString(2, name);
	pst.setString(3, email);
	pst.setString(4, password);
	pst.setLong(5, phone);
	pst.setInt(6, houseno);
	pst.setString(7, colony);
	pst.setString(8, city);
	pst.setInt(9, pincode);
	rst = pst.executeQuery();
	if(rst.next()){
		 user=new User();
		 user.setId(rst.getInt(1));
		 user.setName(rst.getString(2));
		 user.setEmail(rst.getString(3));
		 user.setPassword(rst.getString(4));
		 user.setPhone(rst.getLong(5));
		 user.setHouseNo(rst.getInt(6));
		 user.setColony(rst.getString(7));
		 user.setCity(rst.getString(8));
		 user.setPincode(rst.getInt(9));
		
	System.out.println(user);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return user;
}


public List<User> getAllUser(){
	List<User> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from user ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		User user=new User();
		user.setId(rst.getInt(1));
		user.setName(rst.getString(2));
		user.setEmail(rst.getString(3));
		user.setPassword(rst.getString(4));
		user.setPhone(rst.getLong(5));
		user.setHouseNo(rst.getInt(6));
		user.setColony(rst.getString(7));
		user.setCity(rst.getString(8));
		user.setPincode(rst.getInt(9));
		
		list.add(user);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public void delete(int id) {
	Connection con=null;
	PreparedStatement pst=null;
	final String SELECT_QUERY="delete from user where id=?";
	try {
		con=DBConnection.getConnection();
		pst=con.prepareStatement(SELECT_QUERY);
		pst.setInt(1,  id);
		pst.executeUpdate();
	} catch(Exception e) {
		System.out.println(e);
	}
	
	}

public int editUser(User user) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update user set name= ?, email = ?,password=?,phone=?,houseNo = ?,colony = ?,city = ?,pincode = ? where id = ?");
		
		pst.setInt(1, user.getId());
		pst.setString(2, user.getName());
		pst.setString(3, user.getEmail());
		pst.setString(4, user.getPassword());
		pst.setLong(5, user.getPhone());
		pst.setInt(6, user.getHouseNo());
		pst.setString(7, user.getColony());
		pst.setString(8, user.getCity());
		pst.setInt(9, user.getPincode());
				
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+user);
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




