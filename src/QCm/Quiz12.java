package QCm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Quiz12 implements ActionListener {
	static int count;
	JFrame frame = new JFrame();
	JLabel Title = new JLabel("Question12");
	JLabel question1 = new JLabel( "12) Which type of loop is best for its boolean condition that controls entry to the loop" );
	JCheckBox answer1 = new JCheckBox("a. do-while loop");
	JCheckBox answer2 = new JCheckBox("b. for(traditional)");
	JCheckBox answer3 = new JCheckBox("c.for-each");
	JCheckBox answer4 = new JCheckBox("d. while");
	JButton submitButton = new JButton( "Submit");
	Quiz12(int count){
		this.count=count;
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
	public void createWindow() {
		frame=new JFrame();
		frame=new JFrame();
		frame.setTitle("Question 12");
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
				answer="a. do-while loop";
			}
			if(answer2.isSelected()) {
				answer="b.  for(traditional)";
			}
			if(answer3.isSelected()) {
				answer="c.for-each";
			}
			if(answer4.isSelected()) {
				answer="d. while";
			}
			if(answer=="d. while")
			{
				JOptionPane.showMessageDialog(null, "The result is");
				JOptionPane.showMessageDialog(null, "Correct Answer");
				count+=1;
				Quiz13 q13=new Quiz13(count);
				frame.setVisible(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The result is");
				JOptionPane.showMessageDialog(null, "Wrong Answer");
				Quiz13 q13=new Quiz13(count);
				frame.setVisible(false);
			}
		}
		
	}
	
}





