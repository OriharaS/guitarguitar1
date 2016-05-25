package DB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataConn {
	private static final String DBDRIVER = "org.sqlite.JDBC";
	private static Connection conn;
public static  Connection getConnection() {
	try {
		Class.forName(DBDRIVER);
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:guitar.db"); 
		} catch (SQLException e) {

			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	return conn;

}
	
	public void close() throws Exception {
		if (DataConn.conn != null) {
			try {
				DataConn.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}