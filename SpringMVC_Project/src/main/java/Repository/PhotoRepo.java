package Repository;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spring.model.PhotoBean;

public class PhotoRepo {

	public int addPhoto(byte[] photoByte) throws SQLException {
		int i=0;
		Connection cn=LinkConnection.linkConnection();
		String query="INSERT INTO htoohtoo.picture (img) VALUES (?);";
		PreparedStatement ps=cn.prepareStatement(query);
		ps.setBytes(1, photoByte);
		i=ps.executeUpdate();
		return i;
	}
	public PhotoBean viewPhoto() throws SQLException {
		PhotoBean bean=null;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM htoohtoo.picture";
		PreparedStatement ps=cn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			bean=new PhotoBean();
			bean.setId(rs.getInt(1));
			Blob blob=rs.getBlob(2);
			bean.setPhotoBytes(blob.getBytes(1, (int)blob.length()));
			//bean.setPhotoBytes(rs.getBlob("img").getBytes(1, (int)rs.getBlob("img").length()));
		}
		return bean;
	}
	
}
