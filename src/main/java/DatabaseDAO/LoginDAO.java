package DatabaseDAO;

//Checking user data in database and if it is present then returning the UserDataBean object 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseoperation.DatabaseConnection;
import javabean.UserDataBean;

public class LoginDAO {
	
	//Method for storing user data in UserDataBean and returning the object
	public UserDataBean checkLogin(String usename,String password)
	{
		UserDataBean ub=null;
		Connection con=null;
		
		try
		{
			con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from skillexchangeusers Where username=? AND password=?");
			
			ps.setString(1, usename);
			ps.setString(2, password);
			
			
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next())
			{
				ub=new UserDataBean();
				ub.setFname(rs.getString(1));
				ub.setLname(rs.getString(2));
				ub.setUsername(rs.getString(3));
				ub.setPass(rs.getString(4));
				
				System.out.println("User Email"+ rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ub;
		
	}

}
