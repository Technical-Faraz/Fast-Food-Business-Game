import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Database {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		String name = "";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String username = "scott";
//		String pass ="tiger";
//		Connection conn = DriverManager.getConnection(url, username,pass);
//		String query = "INSERT INTO emp2 (empno, ename) VALUES(2314, 'faraz') ";
//		Statement st = conn.createStatement();
//		int row = st.executeUpdate(query);
//		if(row > 0) {
//			System.out.println("row has been inserted");
//		}
//		System.out.println("Connected with server");
//		st.close();
//		conn.close();
//		
		String name = "";
		Connection conn = null;
		Statement st = null;
		try {
			conn = getConnection();
			String query = "CREATE TABLE employee (id int, name varchar(20))";
			st = conn.createStatement();
			int row = st.executeUpdate(query);
			if(row > 0) {
				System.out.println("row has been inserted");
			}
			System.out.println("Database created");
		}catch(Exception e) {
			String query = "INSERT INTO employee (id, name) VALUES(2314, 'faraz') ";
			st = conn.createStatement();
			int row = st.executeUpdate(query);
			if(row > 0) {
				System.out.println("row has been inserted");
			}
			System.out.println("Connected with server");
		}
		
		st.close();
		conn.close();
	}
	
	public static Connection getConnection() throws Exception{
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "scott";
			String pass ="tiger";
			Connection conn = DriverManager.getConnection(url, username,pass);
			System.out.println("Connected");
			return conn;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
}
