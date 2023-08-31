package QCm;
import java.sql.*;
public class User_score {

	public static void main(String[] args) {
		    try {
		      Connection conn = DriverManager.getConnection(
		        "jdbc:mysql://localhost:3306/java_qcm",
		        "root",
		        ""
		      );

		      Statement stmt = conn.createStatement();
		      String select_query = "SELECT CNE, UserName, Filiere FROM user";
		      ResultSet rs = stmt.executeQuery(select_query);

		      while (rs.next()) {
		    	  int count=0;
		        Quiz1 quiz=new Quiz1();
		       // int count=quiz.getCount();
		        int score = count;
		        String insert_query = "INSERT INTO user_score (CNE, UserName, Filiere, score) VALUES (?, ?, ?, ?)";
		        PreparedStatement pstmt = conn.prepareStatement(insert_query);
		        pstmt.setInt(1, rs.getInt("CNE"));
		        pstmt.setString(2, rs.getString("UserName"));
		        pstmt.setString(3, rs.getString("Filiere"));
		        pstmt.setInt(4, score);
		        pstmt.executeUpdate();
		      }

		      rs.close();
		      stmt.close();
		      conn.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		  }
		

	}


