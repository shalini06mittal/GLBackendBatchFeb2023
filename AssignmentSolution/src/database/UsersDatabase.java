package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDatabase {

	public boolean loginUser(String email, String password) throws Exception
	{
		Connection conn = DBConnection.getConn();
		String sql = "select password from users where email=?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, email);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				String pwd = rs.getString(1);
				if(pwd.equals(password))
					return true;
			}
			else {
				throw new Exception("Email not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage());
		}
		return false;
	}
	
}
