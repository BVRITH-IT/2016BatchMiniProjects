package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ts.dbutility.DBConnection;
import com.ts.dto.registerDTO;

public class registerDAO {
	public static int add(registerDTO user){
		final String INSERT_QUERY="insert into registered_details(uname,pwd,utype) values(?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, user.getuname());
			pst.setString(2, user.getpwd());
			pst.setString(3, user.getutype());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
		
		public  registerDTO getuserRegisterDTO(String uname,String pwd, String utype){
			
			PreparedStatement pst = null;
			ResultSet rst = null;
			registerDTO user=null;
		final String SELECT_QUERY = "select * from registered_details where uname = ? and pwd = ?";
		try(Connection con = DBConnection.getConnection();){
			
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, uname);
			pst.setString(2, pwd);
			pst.setString(3, utype);
			rst = pst.executeQuery();
			if(rst.next()){
				 user=new registerDTO();
				 user.setuname(rst.getString(1));
			System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		}
		
}

