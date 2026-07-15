package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/demodb";
		String username="postgres";
		String password="root";
		String querry="select sid,sname,email,mobile from student";
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection conn=DriverManager.getConnection(url, username, password);
			
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(querry);
			System.out.println("sid   |  sname  |  email |  mobile");
			System.out.println("-----------------------------------");

            // Process results
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                String email = rs.getString("email");
                String mobile = rs.getString("mobile");

                System.out.println(sid + " | " + sname + " | " + email + " | " + mobile);
            }

            // Close resources
            rs.close();
            st.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
