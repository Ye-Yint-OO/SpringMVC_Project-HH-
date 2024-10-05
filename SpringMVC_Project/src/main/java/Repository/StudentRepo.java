package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud.model.StudentBean;

public class StudentRepo {
	public int createStudent(StudentBean bean) {
		int i=0;
		
		try {
			Connection cn=LinkConnection.linkConnection();
			String query="INSERT INTO htoohtoo.student (name,email,password,role) VALUES (?,?,?,?);";
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getRole());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("CreateStudent Error "+e.getMessage());
		}
		return i;
	}
	public boolean checkEmail(String email) {
		boolean result=false;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM htoohtoo.student WHERE email=?;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				result=true;
			}
		} catch (SQLException e) {
			System.out.println("Checking Email Error "+e.getMessage());
		}
		return result;
	}
	public StudentBean checkPassword(String email,String password) {
		StudentBean bean=null;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM htoohtoo.student WHERE email=? AND password=?;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean=new StudentBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setRole(rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("Checking Password Error "+e.getMessage());
		}
		return bean;
	}
}
