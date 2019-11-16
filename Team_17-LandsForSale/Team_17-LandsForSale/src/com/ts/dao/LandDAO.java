package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

import com.ts.dbutility.DBConnection;
import bvrit.Land;

public class LandDAO {
public Land getLand(int plotNo){
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rst = null;
	Land land=null;
final String SELECT_QUERY = "select * from land where plotNo = ? , surveyNo = ? , area = ? , category = ?, criteria = ? , price = ?, place = ?, district = ?, city = ?, state = ?, ownerId = ?, ownerName = ?, ownerPhone = ? ";
try{
	con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	pst.setInt(1, plotNo);
	rst = pst.executeQuery();
	if(rst.next()){
		 land=new Land();
		 land.setPlotNo(rst.getInt(1));
		 land.setSurveyNo(rst.getInt(2));
		 land.setArea(rst.getInt(3));
		 land.setCategory(rst.getString(4));
		 land.setCriteria(rst.getString(5));
		 land.setPrice(rst.getInt(6));
		 land.setPlace(rst.getString(7));
		 land.setDistrict(rst.getString(8));
		 land.setCity(rst.getString(9));
		 land.setState(rst.getString(10));
		 land.setOwnerId(rst.getInt(11));
		 land.setOwnerName(rst.getString(12));
		 land.setOwnerPhone(rst.getLong(13));
		 
		 
	System.out.println(land);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return land;
}

		public int add(Land land){
		final String INSERT_QUERY="insert into land(plotNo, surveyNo, area, category, criteria, price, place, district, city, state, ownerId, ownerName, ownerPhone) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try {
Connection con=DBConnection.getConnection();

			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, land.getPlotNo());
			pst.setInt(2, land.getSurveyNo());
			pst.setInt(3, (int) land.getArea());
			pst.setString(4, land.getCategory());
			pst.setString(5, land.getCriteria());
			pst.setInt(6, land.getPrice());
			pst.setString(7, land.getPlace());
			pst.setString(8, land.getDistrict());
			pst.setString(9, land.getCity());
			pst.setString(10, land.getState());
			pst.setInt(11, land.getOwnerId());
			pst.setString(12, land.getOwnerName());
			pst.setLong(13, land.getOwnerPhone());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

public List<Land> getAllLands(){
	List<Land> list=new ArrayList<>();
	
	PreparedStatement pst = null;
	ResultSet rst = null;
final String SELECT_QUERY = "select * from land ";
try{
	Connection con = DBConnection.getConnection();
	pst = con.prepareStatement(SELECT_QUERY);
	rst = pst.executeQuery();
	while(rst.next()){
		Land land=new Land();
		land.setPlotNo(rst.getInt(1));
		 land.setSurveyNo(rst.getInt(2));
		 land.setArea(rst.getInt(3));
		 land.setCategory(rst.getString(4));
		 land.setCriteria(rst.getString(5));
		 land.setPrice(rst.getInt(6));
		 land.setPlace(rst.getString(7));
		 land.setDistrict(rst.getString(8));
		 land.setCity(rst.getString(9));
		 land.setState(rst.getString(10));
		 land.setOwnerId(rst.getInt(11));
		 land.setOwnerName(rst.getString(12));
		 land.setOwnerPhone(rst.getLong(13));
		list.add(land);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
return list;
}

public void delete(int plotNo) {
	Connection con=null;
	PreparedStatement pst=null;
	final String SELECT_QUERY="delete from Land where plotNo=?";
	try {
		con=DBConnection.getConnection();
		pst=con.prepareStatement(SELECT_QUERY);
		pst.setInt(1,  plotNo);
		pst.executeUpdate();
	} catch(Exception e) {
		System.out.println(e);
	}
	
	}

public int editLand(Land land) {
Connection con = null;
PreparedStatement pst = null;
int x = 0;
	try {
		con = DBConnection.getConnection();
		pst = con.prepareStatement("update land set plotNo = ? , surveyNo = ? , area = ? , category = ?, criteria = ? , price = ?, place = ?, district = ?, city = ?, state = ?, ownerId = ?, ownerName = ?, ownerPhone = ? where plotNo = ?");
		pst.setInt(1, land.getPlotNo());
		pst.setInt(2, land.getSurveyNo());
		pst.setInt(3, (int) land.getArea());
		pst.setString(4, land.getCategory());
		pst.setString(5, land.getCriteria());
		pst.setInt(6, land.getPrice());
		pst.setString(7, land.getPlace());
		pst.setString(8, land.getDistrict());
		pst.setString(9, land.getCity());
		pst.setString(10, land.getState());
		pst.setInt(11, land.getOwnerId());
		pst.setString(12, land.getOwnerName());
		pst.setLong(13, land.getOwnerPhone());
		x = pst.executeUpdate();
		System.out.println("Inside Update....."+land);
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