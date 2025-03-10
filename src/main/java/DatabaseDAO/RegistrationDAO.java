package DatabaseDAO;

//Performing Registration process Storing the User Data in Database
import java.sql.Connection;
import java.sql.PreparedStatement;

import databaseoperation.DatabaseConnection;
import javabean.UserDataBean;

public class RegistrationDAO {

	int k = 0;

	// Method for getting UserDataBean object and storing in Data in Database if
	// stored then returning k=1
	public int addData(UserDataBean ub) {
		Connection con = DatabaseConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("Insert into skillExchangeusers values(?,?,?,?,?,?)");

			ps.setString(1, ub.getFname());
			ps.setString(2, ub.getLname());
			ps.setString(3, ub.getUsername());
			ps.setString(4, ub.getPass());
			ps.setString(5, ub.getEmail());
			ps.setLong(6, ub.getPhno());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}
}
