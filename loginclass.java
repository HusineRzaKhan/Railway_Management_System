package RaliwayManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;

public class loginclass implements Serializable {
	public static String t;
	
    public static void loginmethod() throws FileNotFoundException, IOException
	{
		// Creating a new frame
		JFrame af= new JFrame( "Login Details");
		Color c = new Color(210,210,238);
		af.getContentPane().setBackground(c);

		// Declaring the labels
		JLabel l0, l1, l2, l3;

		// Declaring two text fields. 
		JTextField t1, t2;

		// Declaring two buttons
		JButton b1, b2, b3;

		//Setting the headings
		l0 = new JLabel("LOGIN PAGE");
		l0.setBounds(20, 4,200, 50);
		l0.setFont(new Font("Stencil",Font.PLAIN,20));
		l0.setForeground(Color.blue);

		// Creating the labels
		l1 = new JLabel("User Name:");
		l1.setBounds(30, 10, 100, 100);
		l2 = new JLabel("Password:");
		l2.setBounds(30, 55, 100, 100);
		l3 = new JLabel("Not Registered?");
		l3.setBounds(50, 145, 100, 100);
        

		// Creating the textfields
		t1 = new JTextField();
		t1.setBounds(110, 45, 130, 30);
		t2 = new JTextField();
		t2.setBounds(110, 90, 130, 30);

		// Creating buttons
		b1 = new JButton("Login");
		b1.setBounds(80, 130, 80, 30);
		b2 = new JButton("Close");
		b2.setBounds(161, 130, 80, 30);
        b3 = new JButton("Signup");
		b3.setBounds(150, 181, 80, 30);
	
		// Adding action listener
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(t1.getText().isEmpty() || t2.getText().isEmpty()){
					JOptionPane.showMessageDialog(af,"Please fill all fileds..!");
				}else{
					try {
						if(Passenger.login( t1.getText(), t2.getText())==1){
							String a = t1.getText();
							loginclass.setT(a);
							af.dispose();
							Menu.menu();
						}
						else{
							JOptionPane.showMessageDialog(af,"Incorrect User name or Password..!");         
						}
					}
					catch (ClassNotFoundException | IOException e1) {	
						e1.printStackTrace();
					}
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				af.dispose();
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					af.dispose();
					Signup.signup();
					}
				catch (ClassNotFoundException | IOException e2) {					
					e2.printStackTrace();
				}
			}
		});		
		
		// Adding the created objects in the Frame
		af.add(l1);
		af.add(t1);
		af.add(l2);
		af.add(t2);	
		af.add(b1);
		af.add(b2);
        af.add(b3);
		af.add(l0);
		af.add(l3);

		//Setting Frame Bounds
		af.setLayout(null);
		af.setSize(300, 300);
		af.setLocationRelativeTo(null);
		af.setVisible(true);

		//Creating Closing Dialogue
		af.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		af.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int x = JOptionPane.showConfirmDialog(null, "Do You really want to close?","Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(x==JOptionPane.YES_OPTION){
					e.getWindow().dispose();					
				}
			}
		});	
	}
	public static String getT() {
		return t;
	}
	public static void setT(String t1) {
		loginclass.t = t1;
	}	
}