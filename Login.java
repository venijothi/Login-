# Login-
checking whether the user entered the correct username and password or not , to login 
package oxygen.com;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginConsole {
public static void main(String[] args) {
int flag=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/veni","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from login");
			Scanner s=new Scanner(System.in);
			System.out.println("username:");
			String u=s.next();
			System.out.println("password:");
			String p=s.next();
			while(rs.next())
			{
				String du=rs.getString(3);
				String dp=rs.getString(4);
				if(u.equals(du) && p.equals(dp))
				{
				flag=1;
				}
			}
			if(flag==1)
			{
				System.out.println("Login successfull");
			}
			else
			{
				System.out.println("Login failed");
			}
			}

catch(SQLException e)
		{
	System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
	System.out.println(e);
		}
}
}

 OUTPUT:
username:
abc
password:
abc
Login successfull
