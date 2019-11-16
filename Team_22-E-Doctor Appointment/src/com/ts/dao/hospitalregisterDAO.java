package com.ts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ts.dbutility.DBConnection;
import com.ts.dto.hospitalregisterDTO;

public class hospitalregisterDAO {
	public static int add(hospitalregisterDTO user){
		final String INSERT_QUERY="insert into registeredhospital_details(hosp_name,address,state,country,phone,email) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, user.gethname());
			pst.setString(2, user.getaddress());
			pst.setString(3, user.getstate());
			pst.setString(4, user.getcountry());
			pst.setString(5, user.getphone());
			pst.setString(6, user.getemail());
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
		
		public  hospitalregisterDTO gethospitalRegisterDTO(String hname,String address, String district,String state,String country,String phone,String estyear,String email){
			
			PreparedStatement pst = null;
			ResultSet rst = null;
			hospitalregisterDTO user=null;
		final String SELECT_QUERY = "select * from registeredhospital_details where hosp_name = ? and address = ?";
		try(Connection con = DBConnection.getConnection();){
			
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, hname);
			pst.setString(2, address);
			pst.setString(3, state);
			pst.setString(4, country);
			pst.setString(5, phone);
			pst.setString(6, email);
			rst = pst.executeQuery();
			if(rst.next()){
				 user=new hospitalregisterDTO();
				 user.sethname(rst.getString(1));
			System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		}
		
}

