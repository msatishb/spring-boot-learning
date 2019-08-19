import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionExample {
	public static void main(String args[]) throws SQLException{
		Connection con = null;
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		con =DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","satish");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from emp where JOB='MANAGER'");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) +" "+ rs.getString(4)
		+" "+rs.getDate(5) + " "+ rs.getInt(6) );  
		}catch(Exception e){ 
			System.out.println(e);
			}
		finally {
			con.close();
		}
		}
}
