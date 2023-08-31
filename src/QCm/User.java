package QCm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.*;

public class User implements ActionListener {
	JFrame frame;
	
	JLabel Title= new JLabel("Registration Form");
	JLabel CNELabel= new JLabel("CNE:");
	JLabel nameLabel= new JLabel("UserName:");
	JLabel emailLabel= new JLabel("Email:");
	JLabel filiereLabel= new JLabel("Filiere:");
	JLabel passwordLabel= new JLabel("Password:");
	
	JTextField cneTextField=new JTextField();
	JTextField nameTextField=new JTextField();
	JTextField emailTextField=new JTextField();
	
	JPasswordField  passwordField=new JPasswordField();
	
	String[] filiere={"INFO1","INFO2","INFO3","SEII1","SEII2","SEII3","GTR1","GTR2","GTR3"};
	
	JComboBox filiereName=new JComboBox(filiere);
	
	JButton submitBtn=new JButton("Submit");
	JButton  ResetBtn=new JButton("Reset");

	User(){
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}

	public void createWindow() {
	frame=new JFrame();
	frame.setTitle("Student Details Form");
	frame.setBounds (40, 10, 630, 750);
	frame.getContentPane().setBackground (new Color(0,51,102));
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.setResizable (true);

	}
	public void setLocationAndSize() {
	Title.setBounds (190, 20, 400, 40);
	Title.setBackground (Color.white);
	Title.setFont (new Font("Cambria", Font.CENTER_BASELINE, 25));
	Title.setForeground(Color.white);
	
	CNELabel.setBounds (200, 100, 200, 40);
	CNELabel.setBackground (Color.white); 
	CNELabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	CNELabel.setForeground(Color.white);
	
	cneTextField.setBounds (200, 150, 200, 40); 
	cneTextField.setBackground (Color.white);
	cneTextField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	
	nameLabel.setBounds (200, 200, 200, 40); 
	nameLabel.setBackground (Color.white);
	nameLabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	nameLabel.setForeground(Color.white);

	
	nameTextField.setBounds (200, 250, 200, 40);
	nameTextField.setBackground (Color.white);
	nameTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
	

	
	emailLabel.setBounds (200,300, 400, 40);
	emailLabel.setBackground (Color.white);
	emailLabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	emailLabel.setForeground(Color.white);

	
	emailTextField.setBounds (200, 350, 400, 40);
	emailTextField.setBackground (Color.white);
	emailTextField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	
	passwordLabel.setBounds (200, 400, 200, 40);
	passwordLabel.setBackground (Color.white);
	passwordLabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	passwordLabel.setForeground(Color.white);
	
	passwordField.setBounds (200, 450, 200, 40);
	passwordField.setBackground (Color.white);
	passwordField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	
	filiereLabel.setBounds (200, 500, 200, 40);
	filiereLabel.setBackground (Color.white);
	filiereLabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	filiereLabel.setForeground(Color.white);

	
	filiereName.setBounds (200, 550, 200, 40);
	filiereName.setBackground (Color.white);
	filiereName.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	submitBtn.setBounds (200, 620,100,40);
	submitBtn.setFont (new Font ("Cambria", Font.CENTER_BASELINE, 18));
	submitBtn.setBackground(new Color(250,102,102));
	submitBtn.setForeground (Color.white);

	ResetBtn.setBounds (400,620, 100, 40); 
	ResetBtn.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	ResetBtn.setBackground(new Color(250,102,102));
	ResetBtn.setForeground (Color.white);

	}
	public void addComponentsToFrame() {
		frame.add(Title);
		frame.add(CNELabel);
		frame.add(cneTextField);
		frame.add(nameLabel);
		frame.add(nameTextField);
		frame.add(emailLabel);
		frame.add(emailTextField);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(filiereLabel);
		frame.add(filiereName);
		frame.add(submitBtn);
		frame.add(ResetBtn);
		frame.setVisible(true);
	}
	 public void actionEvent()
	 {
		 submitBtn.addActionListener(this);
		 ResetBtn.addActionListener(this);
		 
	 }
	 
	 public void actionPerformed (ActionEvent e) {
	 if(e.getSource()==submitBtn)
	 {
		 try {
			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_qcm", "root", "");
			 
			 PreparedStatement Pstatement=conn.prepareStatement("INSERT INTO user values (?, ?, ?, ?, ?) "); 
			 
			 Pstatement.setString(1,cneTextField.getText());
			 Pstatement.setString (2, nameTextField.getText());
			 Pstatement.setString (3, emailTextField.getText()); 
			 Pstatement.setString(4,filiereName.getSelectedItem().toString());
			 Pstatement.setString(5, passwordField.getText());
			 String cne= cneTextField.getText();
			 String psw= passwordField.getText(); 
			 String email = emailTextField.getText();
			 String filiere= filiereName.getSelectedItem().toString();
			  
			 if(cne.equals(""))
			 {
				 JOptionPane.showInputDialog(null, "UseId is missing");
				 
			 }
			 else if(psw.equals(""))
			 {
				 JOptionPane.showInputDialog(null, "Password is missing");

			 }
			 else if(email.equals(""))
			 {
				 JOptionPane.showInputDialog(null, "Email is missing");

			 }
			 
			 Statement stmt=conn.createStatement();
			 String query ="SELECT * FROM user" ;
			 ResultSet res=stmt.executeQuery(query);
			 
			 while(res.next()) {
				 String UserId=res.getString("CNE");
				 String Password=res.getString("Password");
				 
				 if(UserId.equals(cne) || Password.equals(psw)) 
				 {
					 JOptionPane.showMessageDialog(null, "User is already exists");
				 }
				 else 
				 {
					 Pstatement.executeUpdate();
					 JOptionPane.showMessageDialog(null,"successfull registration");
					 frame.setVisible(false);
				 }

				 
			 }
			 if(!res.next()) 
			 {
				 Pstatement.executeUpdate();
				 JOptionPane.showMessageDialog( null, "successfull registration");
				
			 }
			 
		 } catch(SQLException e1) {
			 e1.printStackTrace();
		 }
	 }
	 
	 if(e.getSource()==ResetBtn) {
		 cneTextField.setText("");
		 nameTextField.setText("");
		 passwordField.setText("");
		 filiereName.setSelectedItem("");
		 emailTextField.setText("");
		 
	 }
	
	
}
	 public static void main(String[] args) 
		{
		 User E=new User();
		}
	
}






















