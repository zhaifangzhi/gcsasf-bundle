package com.deletetask;

import org.springframework.stereotype.Component;
import java.sql.*;

@Component
public class JDBCservicelmp implements JDBCservice {

	@Override
	public void delete(String systemusername)  throws SQLException{
		String dbURL = "jdbc:mysql://localhost:3306/mydb";
		String username = "root";
		String password = "139738";
		
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		String sql="delete from authorities where username=?"; 
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, systemusername);
		ps.executeUpdate();

		Connection conn1 = DriverManager.getConnection(dbURL, username, password);
		String sql1="delete from users where username=?"; 
		PreparedStatement ps1=conn1.prepareStatement(sql1);
		ps1.setString(1, systemusername);
		ps1.executeUpdate();
	}

}
