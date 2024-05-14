package bank.management.system;
import java.sql.*;
import java.io.*;
public class Conn {
	Connection con;
	Statement s;
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Ha@18@10@20");
			 s = con.createStatement();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
