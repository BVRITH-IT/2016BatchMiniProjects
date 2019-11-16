package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ts.dbutility.DBConnection;
import com.ts.dto.makeappointmentDTO;

public class makeappointmentDAO {
	public static int add(makeappointmentDTO user){
		final String INSERT_QUERY="insert into makeappointment_details(name,gnd,age,date,time,doctorname,hospital) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, user.getname());
			pst.setString(2, user.getgnd());
			pst.setInt(3, user.getage());
			pst.setString(4, user.getdate());
			pst.setString(5, user.gettime());
			pst.setString(6, user.getdname());
			pst.setString(7, user.gethname());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
		
		public  makeappointmentDTO getmakeappointmentDTO(String name,String gnd, int age,String date,String time,String dname,String hname){
			
			PreparedStatement pst = null;
			ResultSet rst = null;
			makeappointmentDTO user=null;
		final String SELECT_QUERY = "select * from makeappointment_details where name = ? and gnd = ?";
		try(Connection con = DBConnection.getConnection();){
			
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, name);
			pst.setString(2, gnd);
			pst.setInt(3, age);
			pst.setString(4, date);
			pst.setString(5, time);
			pst.setString(6, dname);
			pst.setString(7, hname);
			rst = pst.executeQuery();
			if(rst.next()){
				 user=new makeappointmentDTO();
				 user.setname(rst.getString(1));
			System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		}
		
}

