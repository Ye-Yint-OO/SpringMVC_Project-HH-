package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.BookBean;
import crud.model.StudentBean;
//import repository.UserConnection;

public class BookRepo {
	public List<BookBean> showBooks(){
		BookBean bean=null;
		List<BookBean> booklist=new ArrayList<BookBean>();
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM htoohtoo.novel WHERE status=1;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()) {
		    	bean=new BookBean();
		    	bean.setId(rs.getInt(1));
		    	bean.setTitle(rs.getString(2));
		    	bean.setAuthor(rs.getString(3));
		    	bean.setPrice(rs.getDouble(4));
		    	booklist.add(bean);
		    }
		} catch (SQLException e) {
			System.out.println("Showing BookList Error "+e.getMessage());
		}
		return booklist;
	}
	public BookBean showBookById(int id) {
		BookBean bean=null;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM htoohtoo.novel WHERE id=?;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean=new BookBean();
				bean.setId(rs.getInt(1));
				bean.setTitle(rs.getString(2));
				bean.setAuthor(rs.getString(3));
				bean.setPrice(rs.getDouble(4));
			}
		} catch (SQLException e) {
			System.out.println("ShowingBook By ID error "+e.getMessage());
		}
		return bean;
	}
	public int updateBook(BookBean bean,int id) {
		int i=0;
		Connection cn=LinkConnection.linkConnection();
		String query="UPDATE htoohtoo.novel SET title=?,author=?,price=? WHERE id=?;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setDouble(3, bean.getPrice());
			ps.setInt(4, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update Book Error "+e.getMessage());
		}
		return i;
	}
	public int deleteBook(int id) {
		int i=0;
		Connection cn=LinkConnection.linkConnection();
		String query="UPDATE htoohtoo.novel set status=0 where id=?;";
		  try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setInt(1, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete book "+e.getMessage());
		}
		return i;
	}

}
