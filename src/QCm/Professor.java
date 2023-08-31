package QCm;

import java.awt.Color;
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
import javax.swing.JTextField;

import java.sql.*;
public class Professor implements ActionListener  {
	
		JFrame frame;
		JLabel Title= new JLabel("Registration Form For Professor");
		JLabel nameLabel= new JLabel("Name:");
		JLabel filiereLabel= new JLabel("Filiere:");
		JLabel passwordLabel= new JLabel("Password:");
		
		JTextField nameTextField=new JTextField();
	
		
		JPasswordField  passwordField=new JPasswordField();
		
		String[] filiere={"INFO1","INFO2","INFO3"};
		JComboBox filiereName=new JComboBox(filiere);
		
		JButton submitBtn=new JButton("Submit");
		JButton  ResetBtn=new JButton("Reset");

		Professor(){
			createWindow();
			setLocationAndSize();
			addComponentsToFrame();
			actionEvent();
		}

		public void createWindow() {
		frame=new JFrame();
		frame.setTitle("Professor Details Form");
		frame.setBounds (80, 80, 600, 600);
		frame.getContentPane().setBackground (new Color(102,0,204));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setResizable (true);

		}
		public void setLocationAndSize() {
		Title.setBounds (190, 20, 400, 40);
		Title.setBackground (Color.white);
		Title.setFont (new Font("Cambria", Font.CENTER_BASELINE, 25));
		
		
		nameLabel.setBounds (200, 100, 200, 40); 
		nameLabel.setBackground (Color.white);
		nameLabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		nameTextField.setBounds (200, 150, 200, 40);
		nameTextField.setBackground (Color.white);
		nameTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		filiereLabel.setBounds (200, 200, 200, 40);
		filiereLabel.setBackground (Color.white);
		filiereLabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		filiereName.setBounds (200, 250, 200, 40);
		filiereName.setBackground (Color.white);
		filiereName.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		passwordLabel.setBounds (200, 300, 200, 40);
		passwordLabel.setBackground (Color.white);
		passwordLabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
		
		passwordField.setBounds (200, 350, 200, 40);
		passwordField.setBackground (Color.white);
		passwordField.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
		submitBtn.setBounds (200, 420,100,40);
		submitBtn.setFont (new Font ("Cambria", Font.CENTER_BASELINE, 18));
		submitBtn.setBackground(new Color(250,102,102));
		ResetBtn.setBounds (400,420, 100, 40); 
		ResetBtn.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
		ResetBtn.setBackground(new Color(250,102,102));
		}
		public void addComponentsToFrame() {
			frame.add(Title);
			frame.add(nameLabel);
			frame.add(nameTextField);
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
				//Creating Connection Object
				 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_qcm", "root", "");
				 
				 //Prepared Statement
				 PreparedStatement Pstatement=conn.prepareStatement("INSERT INTO professor values (?, ?, ?) "); 
				 //Specifying the values of its parameteT
				 
				 Pstatement.setString (1, nameTextField.getText());
				 Pstatement.setString(2,filiereName.getSelectedItem().toString());
				 Pstatement.setString(3, passwordField.getText());
				 //Checking for the Password macch
				 String name=nameTextField.getText();
				 String psw= passwordField.getText(); 
				 String filiere= filiereName.getSelectedItem().toString();
				  
				 
				 if(psw.equals(""))
				 {
					 JOptionPane.showInputDialog(null, "Password is missing");

				 }
				 
				 
				 Statement stmt=conn.createStatement();
				 String query ="SELECT * FROM professor" ;
				 ResultSet res=stmt.executeQuery(query);
				 
				 while(res.next()) {
					 String nm=res.getString("name");
					 String Password=res.getString("Password");
					 
					 if( nm.equals(name)||Password.equals(psw)) 
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
			 nameTextField.setText("");
			 passwordField.setText("");
			 filiereName.setSelectedItem("");
			 
		 }
		 TableEtudiants t=new TableEtudiants();
		
	}
		 public static void main(String[] args) 
			{
			 Professor P=new Professor();
			}
		
	}
























