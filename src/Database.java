// database connectivity
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
			//Create complete Database
			String query = "CREATE TABLE players(pname varchar(20), loan int,bal int, day int)";
			st = conn.createStatement();
			st.executeUpdate(query);

			query = "CREATE TABLE items(fid int primary key ,fname varchar(20), price int)";
			st.executeUpdate(query);

			query = "CREATE TABLE stocks(fid int references items(fid),amount int)";
			st.executeUpdate(query);

			String fnames[] = {"beef burger","cheese burger", "bbq pizza","cheese pizza",
					"pepsi","coca cola","pasta","salad","ice cream","milk shake"};
			String fprice[]= {"700","600","1000","1200","100","80","400","500","600","300"};
			for(int i = 0; i < 10;i++) {
				query = "Insert into items values("+(i+1)+",'"+fnames[i]+"',"+fprice[i] +")";
				st.executeUpdate(query);
			}
			JOptionPane.showMessageDialog(null, "Database Created",
		               "Welcome",1);
			new MainWin();
		}catch(Exception e) {
			new MainWin();
			System.out.println(e);
//			String query = "INSERT INTO employee (id, name) VALUES(2314, 'faraz') ";
//			st = conn.createStatement();
//			int row = st.executeUpdate(query);
//			if(row > 0) {
//				System.out.println("row has been inserted");
//			}
//			System.out.println("Connected with server");
		}
		
		st.close();
		conn.close();
	}
	
	public static Connection getConnection() throws Exception{
		try {
			JFrame f;  
			f=new JFrame();   
			String name=JOptionPane.showInputDialog(f,"Enter the name of your scott database");     
			
			String url = "jdbc:oracle:thin:@localhost:1521:"+name.toLowerCase();
			String username = "scott";
			String pass ="tiger";
			Connection conn = DriverManager.getConnection(url, username,pass);
			JOptionPane.showMessageDialog(null, "Database Connected",
		               "Welcome",1);
			
			return conn;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}
	
}
