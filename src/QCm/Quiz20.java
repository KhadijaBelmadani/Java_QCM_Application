package QCm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Quiz20 implements ActionListener {
	 static int count;
	JFrame frame = new JFrame();
	JLabel Title = new JLabel("Question20");
	JLabel question1 = new JLabel( "20) Which modifier can be applied to an abstarct interface method");
	JCheckBox answer1 = new JCheckBox("a. protected");
	JCheckBox answer2 = new JCheckBox("b. static");
	JCheckBox answer3 = new JCheckBox("c.final");
	JCheckBox answer4 = new JCheckBox("d. public");
	JButton submitButton = new JButton( "Submit");
	Quiz20(int count){
		this.count=count;
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
public static int getCount() {
		
		return count;
	}
	
	public void createWindow() {
		frame=new JFrame();
		frame=new JFrame();
		frame.setTitle("Question 19");
		frame.setBounds(50,10, 1200, 900);
		frame.getContentPane().setBackground (Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
	}
	public void setLocationAndSize() {
		Title.setBounds(350,10,600,40);
		Title.setBackground (Color.white);
		Title.setFont(new Font( "Cambria", Font.CENTER_BASELINE,25));
		
		question1.setBounds(50, 60,1200,40);
		question1.setBackground (Color.white);
		question1.setFont(new Font( "Cambria", Font.CENTER_BASELINE,  18));
		
		answer1.setBounds( 50, 130,400,40); 
		answer1.setBackground (Color.white);
		answer1.setFont(new Font( "Cambria", Font.CENTER_BASELINE,18));
		
		answer2.setBounds(50,  180,400, 40);
		answer2.setBackground (Color.white);
		answer2.setFont(new Font( "Cambria", Font.CENTER_BASELINE,18));
		
		answer3.setBounds(50, 230,400, 40);
		answer3.setBackground (Color.white);
		answer3.setFont(new Font("Cambria", Font.CENTER_BASELINE,  18));
		
		answer4.setBounds(50,280, 400, 40);
		answer4.setBackground (Color.white);
		answer4.setFont(new Font( "Cambria", Font.CENTER_BASELINE,18));
		
		submitButton.setBounds(50, 330,  200,40);
		submitButton.setBackground(new Color(250,102,102));
		submitButton.setFont(new Font("Cambria", Font.CENTER_BASELINE,18));
		
	}
	public void addComponentsToFrame() {
		frame.add(Title);
		frame.add(question1);
		frame.add(answer1);
		frame.add(answer2);
		frame.add(answer3);
		frame.add(answer4);
		frame.add(submitButton);
		
	}
	public void actionEvent() {
		submitButton.addActionListener(this);

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitButton) {
			String answer=null;
			if(answer1.isSelected()) {
				answer="a. protected";
			}
			if(answer2.isSelected()) {
				answer="b.  static";
			}
			if(answer3.isSelected()) {
				answer="c. final";
			}
			if(answer4.isSelected()) {
				answer="d. public";
			}
			if(answer=="d. public")
			{
				
				JOptionPane.showMessageDialog(null, "The result is");
				JOptionPane.showMessageDialog(null, "Correct Answer");
				count+=1;
				JOptionPane.showMessageDialog(null, "You score is:"+count+"/"+20);
				HomePage hp=new HomePage();
				frame.setVisible(false);
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The result is");
				JOptionPane.showMessageDialog(null, "Wrong Answer");
				JOptionPane.showMessageDialog(null, "You score is:"+count+"/"+20);
				HomePage hp=new HomePage();
				frame.setVisible(false);
			}
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
			    } catch (SQLException e1) {
			      e1.printStackTrace();
			    }
			  }
			

		}
		
	}
	












