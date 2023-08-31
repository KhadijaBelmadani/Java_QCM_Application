package QCm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;




public class Login implements ActionListener{
	
	JFrame frame;
	JLabel cneLabel=new JLabel("CNE"); 
	JLabel Title= new JLabel("LOGIN ");
	JTextField cneTextField=new JTextField();
	JLabel passwordLabel=new JLabel ("Password");
	JPasswordField passwordField= new JPasswordField();
	
	JButton loginButton=new JButton("Login");
	
	Login()
	{
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
		
	}
	public void createWindow() {
		frame =new JFrame();
		frame.setTitle("Login Form");
		frame.setBounds (80, 80, 500, 500);
		frame.getContentPane().setBackground (new Color(0,51,102));
		frame.getContentPane().setLayout (null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
			
		}
	
	public void setLocationAndSize() {
		Title.setBounds (190, 20, 400, 40);
		Title.setFont (new Font("Camoria", Font.CENTER_BASELINE, 25));
		Title.setBackground (Color.white);
		Title.setForeground (Color.white);
		cneLabel.setBounds (200, 100, 200, 40);
		cneLabel.setFont (new Font("Cambria", Font.CENTER_BASELINE, 25));
		cneLabel.setBackground (Color.white); 
		cneLabel.setForeground (Color.white);
		cneTextField.setBounds (130,150, 200, 40);
		cneTextField.setFont(new Font("Cambria", Font.CENTER_BASELINE, 20)); 
		cneTextField.setBackground (Color.WHITE);
		passwordLabel.setBounds (170, 200, 200, 40);
		passwordLabel.setFont(new Font("Cambria", Font.CENTER_BASELINE, 25));
		passwordLabel.setBackground (Color.white);
		passwordLabel.setForeground (Color.white);
		passwordField.setBounds (130, 250, 200, 40);
		
		passwordField.setFont (new Font ("Cambria", Font.CENTER_BASELINE, 20));
		passwordField.setBackground (Color.WHITE);
		
		loginButton.setBounds (130, 350, 200, 40);
		loginButton.setBackground(new Color(250,102,102));
		loginButton.setFont(new Font("Cambria",Font.CENTER_BASELINE, 20));
		loginButton.setForeground (Color.white);

	}

	public void addComponentsToFrame() {
		frame.add(Title);
		frame.add(cneLabel);
		frame.add(cneTextField);
		frame.add(passwordLabel);
		frame.add(passwordField); 
		frame.add(loginButton);

	}

	public void actionEvent() {
		loginButton.addActionListener(this);
	}

	

	
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton)
		{
			try {
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_qcm","root","");
				Statement stmt=conn.createStatement();
				Statement stmt1=conn.createStatement();
				String cne=cneTextField.getText();
				String psw=passwordField.getText();
				
				String query ="SELECT * FROM user";
				ResultSet res=stmt.executeQuery(query);
				while(res.next())
				{
					String userId= res.getString("CNE");
					String Password=res.getString("Password");
					
					
					if(userId.equals(cne) && Password.equals(psw)) {
						JOptionPane.showMessageDialog(null, "Logged in successfully");
						
						PreparedStatement Pstatement=conn.prepareStatement("INSERT INTO login Values(?,?)");
						Pstatement.setString(1, cneTextField.getText());
						Pstatement.setString(2, passwordField.getText());
						Pstatement.executeUpdate();
						HomePage h=new HomePage();
						frame.setVisible(false);


						
					}
				}
				
				
				
				}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		else 
			JOptionPane.showMessageDialog(null,"Invalid");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) 
	{
	 Login E=new Login();
	}
	
}
