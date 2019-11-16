package com.ts.dbutility;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection()
    {
      try {
          DriverManager.registerDriver(new Driver());
          return DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit","root","123456");
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
		public static void main(String[] args) {
			Connection connection = DBConnection.getConnection();
			Connection con = null;
			try {
				con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit","root","123456");
			
				if(con != null) {
					System.out.println("connected successfully to database");
				}
			
			} catch(Exception e) {
				System.out.println("not connected to database");
		}
		}
}
		
	

	
	

