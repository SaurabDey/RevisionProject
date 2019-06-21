package com.saurab.start.RevisionMavenProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

/*<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>8.0.15</version>
</dependency>*/
public class DatabaseIntroduction {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		DatabaseIntroduction ref= new DatabaseIntroduction();
		Map<String, String> mymap =ref.dbMethod();
		
		Assert.assertEquals("William", mymap.get("name"));
		
		for (String xyz : mymap.keySet()) {
			System.out.println(mymap.get(xyz));
		}
	}

	public Map<String, String> dbMethod() throws SQLException, ClassNotFoundException {
		Connection con = null;
		Map<String, String> dbValue = new HashMap<>();
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "selenium");

			System.out.println("Started Connecton");

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from employees where employeeNumber=1088");

			while (rs.next()) {

				dbValue.put("name", rs.getString("firstName"));

				dbValue.put("emailid", rs.getString("email"));
			}

		} finally {
			con.close();
		}
		return dbValue;
	}

}
