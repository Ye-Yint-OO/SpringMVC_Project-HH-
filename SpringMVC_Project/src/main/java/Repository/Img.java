package Repository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Img {

	public Blob getimg() {
		Blob b=null;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT img FROM htoohtoo.picture;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 b=rs.getBlob("img");
				 System.out.println(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
			
	}
	
}
