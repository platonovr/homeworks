import java.sql.*;

public class Lal {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres", "postgres",
				"rom16tat");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT vid,vendor FROM vendors");
		while (rs.next()) {
			System.out.println(rs.getInt("vid"));
			System.out.println(rs.getString("vendor"));
		}
	}
}
