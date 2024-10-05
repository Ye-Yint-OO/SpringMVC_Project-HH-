package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LinkConnection {
	public static Connection linkConnection() {
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/htoohtoo";
			String name="root";
			String password="root";
			cn=DriverManager.getConnection(url,name,password);
			System.out.println("Connection success");
		} catch (ClassNotFoundException e) {
			System.out.println("Libaray error"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("Connection to Database error "+e.getMessage());
		}
		return cn;
	}
	
}
