package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ts.dbutility.DBConnection;
import com.ts.dto.doctorregisterDTO;

public class doctorregisterDAO {
	public static int add(doctorregisterDTO user){
		final String INSERT_QUERY="insert into registereddoctor_details(name,qualification,start,end,hospital,email) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, user.getdname());
			pst.setString(2, user.getqual());
			pst.setString(3, user.getstart());
			pst.setString(4, user.getend());
			pst.setString(5, user.gethosp());
			pst.setString(6, user.getemail());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
		
		public  doctorregisterDTO getdoctorRegisterDTO(String dname, String qual,String start,String end, String hosp,String email){
			
			PreparedStatement pst = null;
			ResultSet rst = null;
			doctorregisterDTO user=null;
		final String SELECT_QUERY = "select * from registereddoctor_details where dname = ? and qual = ?";
		try(Connection con = DBConnection.getConnection();){
			
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, dname);
			pst.setString(2, qual);
			pst.setString(3, start);
			pst.setString(4, end);
			pst.setString(5, hosp);
			pst.setString(6, email);
			rst = pst.executeQuery();
			if(rst.next()){
				 user=new doctorregisterDTO();
				 user.setdname(rst.getString(1));
			System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		}
		
}
