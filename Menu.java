package RaliwayManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;

public class Menu implements Serializable{
    public static void menu() {
		//Creating a Frame
		JFrame f = new JFrame();
		Color c = new Color(210,210,238);
		f.getContentPane().setBackground(c);

		//Declaring the label
		JLabel l0;

		//Declaring buttons
		JButton b1, b2, b3, b4, b5, b6, b7;

		//Setting the headings
		l0 = new JLabel("MENU");
		l0.setBounds(20, 4,200, 50);
		l0.setFont(new Font("Stencil",Font.PLAIN,20));
		l0.setForeground(Color.blue);

		//Creating Buttons
		b1 = new JButton("Book Ticket");
		b1.setBounds(20, 50, 120, 30);
		b2 = new JButton("Cancel Ticket");
		b2.setBounds(150, 50, 120, 30);
        b3 = new JButton("Show My Info");
		b3.setBounds(20, 100, 120, 30);
        b4 = new JButton("Train Details");
		b4.setBounds(150, 100, 120, 30);
		b5 = new JButton("Station Details");
		b5.setBounds(20, 150, 120, 30);
		b6 = new JButton("Delete Account");
		b6.setBounds(150,150,120,30);
        b7 = new JButton("Logout");
		b7.setBounds(105, 200, 80, 30);
		
		// Adding action listeners
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{				
				try {
					Train.frame();
					f.dispose();
				}
				catch (IOException | ClassNotFoundException ex) {
					System.out.println(ex);
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{				
				try {
					Ticket.CancelTicket();
					f.dispose();
				}
				catch (IOException ex) {
					System.out.println(ex);
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				try {
					Passenger.showmyInfo();
					f.dispose();
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{							
				try {
					Train.frame();
					f.dispose();
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{							
					Station.stframe();
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					Passenger.deletaccount();
					f.dispose();
				} catch (IOException | ClassNotFoundException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
					loginclass.loginmethod();
					f.dispose();					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// Adding the created objects in the Frame
		f.add(b1);
		f.add(b2);
        f.add(b3);
		f.add(b4);
        f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(l0);

		//Setting Frame Bounds
		f.setLayout(null);
		f.setSize(300,300);
		f.setLocationRelativeTo(null);	
		f.setVisible(true);

		//Creating Closing Dialogue
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int x = JOptionPane.showConfirmDialog(null, "Do You really want to close?","Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(x==JOptionPane.YES_OPTION){
					e.getWindow().dispose();					
				}
			}
		});
	}
}