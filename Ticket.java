package RaliwayManagementSystem;

import javax.naming.Name;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Ticket implements Serializable {
	static int noOftickets = 8;

	public static void BookTicket() throws IOException, ClassNotFoundException
	{
		// Creating a Frame
		JFrame f= new JFrame("Book Tickets");
		Color c = new ColorUIResource(210,210,238);
		f.getContentPane().setBackground(c);

		// Creating the labels
		JLabel l0, l1, l2, l3, l4, l5, l6;

		// Creating three text fields.
		JTextField t1, t2, t3,t4;

		// Declaring two JComboboxes
		JComboBox j1, j2, j3;

		// Declaring two buttons
		JButton b1, b2;

		//Declaring two JComboboxes
		String s1[] = {" Jan "," Feb "," Mar "," Apr "," May "," June "," July "," Aug "," Sept "," Oct "," Nov "," Dec "};
			
		String s2[]= {  "                          1",
						"                          2",
						"                          3",
						"                          4",
						"                          5",
						"                          6",
						"                          7"};
		String sdate[] = {" 1 "," 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "," 9 "," 10 "," 11 "," 12 "," 13 "," 14 "," 15 "," 16 "," 17 "," 18 "," 19 "," 20 "," 21 "," 22 "," 23 "," 24 "," 25 "," 26 "," 27 "," 28 "," 29 "," 30 "," 31 ",};


		// Creating the labels
		l0 = new JLabel("BOOK TICKET");
		l0.setBounds(40, 4,200, 50);
		l0.setFont(new Font("Stencil",Font.PLAIN,20));
		l0.setForeground(Color.blue);
		l1 = new JLabel("Enter Name:");
		l1.setBounds(50, 50, 100, 30);
		l2 = new JLabel("CNIC.:");
		l2.setBounds(395, 50, 120, 30);
		l3 = new JLabel("Phone:");
		l3.setBounds(50, 120, 150, 30);
		l4 = new JLabel("Date :");
		l4.setBounds(395, 120, 70, 30);
		l5 = new JLabel("Easypaisa Account Number");
		l5.setBounds(50, 190, 70, 30);
        l6 = new JLabel("Tickets:");
		l6.setBounds(395, 190, 70, 30);

		// Creating the textfields 
		t1 = new JTextField();
		t1.setBounds(150, 50, 130, 30);
		t2 = new JTextField();
		t2.setBounds(470, 50, 130, 30);
		t3 = new JTextField();
		t3.setBounds(150, 120, 130, 30);
		t4 = new JTextField();
		t4.setBounds(150, 190,130,30);

		// Creating buttons
		b1 = new JButton("Save");
		b1.setBounds(410, 250, 70, 30);
		b2 = new JButton("Close");
		b2.setBounds(481, 250, 70, 30);

		//Creating JComboboxes
		j1 = new JComboBox<>(sdate);
		j1.setBounds(470, 120, 60, 30);
		j2 = new JComboBox<>(s2);
 		j2.setBounds(470, 190, 130, 30);
		j3 = new JComboBox<>(s1);
		j3.setBounds(535, 120, 60, 30);

		// Adding action listeners
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Random seat = new Random();
				int seatt = seat.nextInt(80);
				int coachno = seat.nextInt(5);
				Date d1 = new Date();

				if(t1.getText().isEmpty()){	
					JOptionPane.showMessageDialog(f,"Please fill all fields...!");


				}else{	
					try {
						String Name   = t1.getText(); 
						String CNIC   = t2.getText();
						String phone  = t3.getText();
						String date = j1.getName();
						String ep   = t4.getText();
						int    Ticket = j2.getSelectedIndex()+1;
						ArrayList<BookedTickets> bookedticket = new ArrayList<>();
                        bookedticket.add(new BookedTickets(Name, CNIC, phone, date, ep, Ticket));
						ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("BookedTickets.dat"));
						oos.writeObject(bookedticket);
						oos.close();						
					}
					catch (Exception ex) {
						System.out.println(ex);
					}

					JOptionPane.showMessageDialog(f,"Ticket Generated Successfully \n Receipt (Copy has been messaged on the number)" + "\n Name : " + t1.getText() + "\n CNIC : "+ t2.getText() + "\n Phone Number : "+ t3.getText() + "\n Seat Number : " + seatt + "\n Coach Number : "+coachno + "\n Date :   " +j1.getSelectedItem() +j3.getSelectedItem() +" 2023" +"\n  Ticket Generated at " + d1);
					f.dispose();
					Menu.menu();
				}
			}
		});
		b2.addActionListener(new ActionListener() {
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
		f.add(l0);
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);		
		f.add(l4);		
		f.add(t3);        
		f.add(b1);
		f.add(b2);        
        f.add(l5);		
		f.add(j1);
		f.add(t4);
		f.add(j2);
		f.add(j3);
		f.add(l6);

		//Setting Frame Bounds
		f.setLayout(null);
		f.setSize(700, 350);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		//Creating Closing dialogue for frame when "X" is clicked
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

	public static void CancelTicket() throws IOException{
		// Creating a new frame
		JFrame f= new JFrame("Cancel Ticket");
		Color c = new ColorUIResource(210,210,238);
		f.getContentPane().setBackground(c);

		// Declaring the labels
		JLabel l0, l1;

		// Declaring a text field for CNIC
		JTextField t1;

		// Declaring two buttons
		JButton b1, b2;

		// Creating the labels
		l0 = new JLabel("Cancel Ticket");
		l0.setBounds(20, 4,200, 50);
		l0.setFont(new Font("Stencil",Font.PLAIN,20));
		l0.setForeground(Color.blue);
		l1 = new JLabel("Enter CNIC:");
		l1.setBounds(30, 50, 100, 30);

		// Creating the textfield
		t1 = new JTextField();
		t1.setBounds(110, 50, 170, 30);

		// Creating buttons
		b1 = new JButton("Cancel Ticket");
		b1.setBounds(141, 210, 130, 30);
		b2 = new JButton("Close");
		b2.setBounds(70, 210, 70, 30);
		
		// Adding action listeners
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){	
					try {					
						ObjectInputStream ois=new ObjectInputStream(new FileInputStream("BookedTickets.dat"));
						ArrayList<BookedTickets> bookedtickets = (ArrayList)ois.readObject();
						ois.close();
						int found = 0;
						int j = 0;
						
						for(int i = 0; i < bookedtickets.size(); i++){
							if(bookedtickets.get(i).getCnic().equals(t1.getText())){
								found = 1;
								j=i;
							}
						}

						if(found==1){
							bookedtickets.remove(j);
							ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("BookedTickets.dat"));
		 					oos.writeObject(bookedtickets);
							oos.close();
							JOptionPane.showMessageDialog(f,"Ticket Successfully Cancelled..!");
						}else{
							JOptionPane.showMessageDialog(f,"Ticket Not Found..!");
						}
					}
					catch (Exception ex) {
						System.out.println(ex);
					}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Menu.menu();
				f.dispose();				
			}
		});
		
		// Adding the created objects in the Frame
		f.add(l0);
		f.add(l1);
		f.add(t1);
		f.add(b1);
		f.add(b2);

		//Setting Frame Bounds
		f.setLayout(null);
		f.setSize(350, 350);
		f.setLocationRelativeTo(null);	
		f.setVisible(true);	
		
		//Creating Closing dialogue for frame when "X" is clicked
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