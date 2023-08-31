package QCm;
 
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.*;
	import javax.swing.*;
	import java.sql.*;
	import java.awt.Color;
	import java.awt.Cursor;
	import java.awt.Font;
	import java.awt.event.*;
	import javax.swing.*;
	import java.sql.*;

	public class HomePage implements ActionListener, MouseListener, MouseMotionListener {
	    static String cne=null;
	    JFrame frame;
	    JLabel welcome = new JLabel("WRITE ONCE , RUN ANYWHERE "); 
	    JMenuBar menuBar = new JMenuBar();
	    JMenuItem menu1= new JMenuItem("Home");
	    JMenuItem menu2= new JMenuItem("New User ");
	    JMenuItem menu3 =new JMenuItem("Professor");
	    JMenuItem menu4 =new JMenuItem("LogIn");
	    JMenuItem menu5 = new JMenuItem("Start Quiz");
	    JMenuItem menu6 =new JMenuItem("LogOut");
	    Icon quiz;
	    JLabel image = new JLabel();

	    HomePage() {
	        createWindow();
	        setLocationAndSize();
	        addComponentsToFrame();
	        actionEvent();
	        addMouseListenerToMenuItems();
	    }
	    
	    public void createWindow() {
	        frame =new JFrame();
	        frame.setTitle("JAVA QCM");
	        frame.setBounds (50, 10, 1300, 1000);
	        Color color = new Color(204, 102, 0);
	        frame.getContentPane().setBackground (color);
	        frame.getContentPane().setLayout(null);
	        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	        frame.setResizable (true);
	        frame.setVisible(true);
	    }
	    
	    public void setLocationAndSize() {
	        
	        menuBar.setBounds (2, 2, 1280, 70);
	        Color color = new Color(72, 61, 139);
	        menuBar.setBackground(color);
	        
	        menu1.setBounds (2, 2, 100, 30);
	        menu1.setFont(new Font ("Cambria", Font.CENTER_BASELINE, 18));
	        menu1.setBackground(color);
	        menu1.setForeground(Color.WHITE);
	        menu1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	        
	        menu2.setBounds (12, 6, 100, 40);
	        menu2.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	        menu2.setBackground(color);
	        menu2.setForeground(Color.WHITE);
	        menu2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	        
	        menu3.setBounds (2, 10, 100, 40);
	        menu3.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	        menu3.setBackground(color);
	        menu3.setForeground(Color.WHITE);
	        menu3.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	        
	        menu4.setBounds (2, 14, 100, 40);
	        menu4.setFont (new Font("Cambria", Font.CENTER_BASELINE,18));
	        menu4.setBackground(color);
	        menu4.setForeground(Color.WHITE);
	        menu4.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	        
	        menu5.setBounds (2, 18, 100, 40);
	        menu5.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	        menu5.setBackground(color);
	        menu5.setForeground(Color.WHITE);
	        menu5.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	        
	        menu6.setBounds (30, 2, 100, 40);
	        menu6.setFont (new Font("Cambria", Font.CENTER_BASELINE, 18));
	        menu6.setBackground(color);
	        menu6.setForeground(Color.WHITE);
	        menu6.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	        
	        menuBar.add(menu1);
	        menuBar.add(menu2);
	        menuBar.add(menu3);
	        menuBar.add(menu4);
	        menuBar.add(menu5);    
	        menuBar.add(menu6);
	        
	        welcome.setBounds(320, 80, 800, 50);
	        welcome.setForeground(Color.white);
	        welcome.setFont(new Font("Cambria", Font.CENTER_BASELINE,40));
	        
	        quiz=new ImageIcon("C:\\Users\\lenovo\\eclipse-workspace\\QCM\\src\\QCm\\img.jpg");
	        
	        image.setBounds(210, 50, 1000, 700);
	        image.setIcon(quiz);
	    }
	    
	    public void addComponentsToFrame() {
	        frame.add(menuBar);
	        frame.add(welcome);
	        frame.add(image);
	    }
	    
	    public void actionEvent() {
	        menu1.addActionListener(this);
	        menu2.addActionListener(this);
	        menu3.addActionListener(this);
	        menu4.addActionListener(this); 
	        menu5.addActionListener(this);
	        menu6.addActionListener(this); 
	    }
	    
	  
	    public void addMouseListenerToMenuItems() {
	        menu1.addMouseListener(this);
	        menu2.addMouseListener(this);
	        menu3.addMouseListener(this);
	        menu4.addMouseListener(this);
	        menu5.addMouseListener(this);
	        menu6.addMouseListener(this);
	        
	      
	        menuBar.addMouseMotionListener(this);
	    }
	    
	    @Override
	    public void mouseEntered(MouseEvent e) {
	        ((JMenuItem) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        ((JMenuItem) e.getSource()).setBackground(new Color(92, 87, 182));
	    }
	    
	    @Override
	    public void mouseExited(MouseEvent e) {
	        ((JMenuItem) e.getSource()).setCursor(Cursor.getDefaultCursor());
	        ((JMenuItem) e.getSource()).setBackground(new Color(72, 61, 139));
	    }
	    
	    @Override
	    public void mouseClicked(MouseEvent e) {}
	    @Override
	    public void mousePressed(MouseEvent e) {}
	    @Override
	    public void mouseReleased(MouseEvent e) {}
	    
	    @Override
	    public void mouseMoved(MouseEvent e) {
	        menuBar.setCursor(Cursor.getDefaultCursor());
	    }
	    
	   
	    
	   
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==menu1) {
			HomePage h=new HomePage();
		}
		if(e.getSource()==menu2)
		{
			User e1 =new User();
		}
		if(e.getSource()==menu3)
		{
			Professor e1 =new Professor();
		}
		
	if(e.getSource()==menu4) 
	{
		Login l1= new Login() ;
		
	}
	if(e.getSource()==menu5) {
		cne=JOptionPane.showInputDialog("Enter Your CNE");
			try {
	Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_qcm", "root", "");
	Statement stmt= conn1.createStatement() ;
			
	String query= "SELECT CNE FROM login";
	ResultSet res= stmt.executeQuery(query);
	while (res.next())
	{ 
		String UserId=res.getString("CNE");
	
		if(UserId.equals(cne))
	{
			JOptionPane.showMessageDialog(null,"All The best for Quiz!");
			Quiz1 q=new Quiz1();
			frame.setVisible(false);
	}
		
	
	}
}
	catch (Exception ex)
			{
		ex.printStackTrace();
			}
}
	
	if(e.getSource()==(menu6))
	{
		try {
				Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_qcm","root", ""); 
				Statement stmt =conn1.createStatement() ;
				String query = "SELECT CNE FROM login";
				ResultSet res=stmt.executeQuery (query);
	while (res.next()) {
		cne=res.getString("CNE");
		PreparedStatement pst = conn1.prepareStatement ("delete from login where FROM='" +cne+ "'");
		//pst.executeUpdate();
		frame.setVisible(false);
		JOptionPane.showMessageDialog(null, "Logout Successful!");
	}
		}

	catch (Exception ex)
		{
		  ex.printStackTrace();
		}
		frame.setVisible(false);
	}
	
}
	
	
	
	public static void main(String[] args) 
	{
		HomePage h=new HomePage();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	}
