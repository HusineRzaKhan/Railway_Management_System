package RaliwayManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Signup {
    public static void signup() throws FileNotFoundException, IOException, ClassNotFoundException{

		//Creating a frame
        JFrame f= new JFrame( "Signup");
		Color c = new Color(210,210,238);
		f.getContentPane().setBackground(c);

		//Declaring the labels
		JLabel l0, l1, l2, l3, l4, l5, l6;

		//Declaring text fields
		JTextField t1, t2, t3, t4;

		//Declaring JComboboxes
		JComboBox j1;

		//Declaring two buttons
		JButton b1, b2;

		//Creating the labels
		l0 = new JLabel("Signup");
		l0.setBounds(40, 4,200, 50);
		l0.setFont(new Font("Stencil",Font.PLAIN,20));
		l0.setForeground(Color.blue);
		l1 = new JLabel("User Name:");
		l1.setBounds(50, 50, 100, 30);
		l2 = new JLabel("CNIC:");
		l2.setBounds(395, 50, 120, 30);
		l3 = new JLabel("Phone No:");
		l3.setBounds(50, 120, 150, 30);
		l4 = new JLabel("Gender");
		l4.setBounds(395, 120, 70, 30);
		l5 = new JLabel("Password:");
		l5.setBounds(50, 190, 70, 30);
		l6 = new JLabel("without dashes");
		l6.setBounds(415, 30, 80, 50);
		l6.setFont(new Font("Arial", Font.PLAIN, 10));

		// Creating the textfields
		t1 = new JTextField();
		t1.setBounds(150, 50, 130, 30);
		t2 = new JTextField();
		t2.setBounds(470, 50, 130, 30);
		t2.setDocument(new TextfieldLIMIT(13));      
		t3 = new JTextField("03");
		t3.setBounds(150, 120, 130, 30);
        t4 = new JTextField();
		t4.setBounds(150, 191, 130, 30);

		// Creating string array for Male and Female
		String s1[]= {"M","F"};

		// Creating JComboBox for Gender Selection
		j1 = new JComboBox<>(s1);
		j1.setBounds(470, 120, 130, 30);
		
		// Creating buttons
		b1 = new JButton("Signup");
		b1.setBounds(460, 250, 80, 30);
		b2 = new JButton("Close");
		b2.setBounds(541, 250, 80, 30);
		
		//Adding action listener
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty()){
					JOptionPane.showMessageDialog(f,"Please fill all fields..!");				
				}else if(t2.getText().length()!=13 || t3.getText().length()!=11){
					JOptionPane.showMessageDialog(f,"Fill the fields correctly..!");
				}else{
					try {
						if(Passenger.search( t1.getText(), 1) == true){					
							JOptionPane.showMessageDialog(f,"User Name Alreay Found..!");	
						}
						else if(Passenger.search( t2.getText(), 2) == true){
							JOptionPane.showMessageDialog(f, "CNIC Already Found..!");
						}
						else{
							String Name = t1.getText(); 
							String CNIC = t2.getText();
							String phone = t3.getText();
							String Gender = "M";
							String Password = t4.getText();
							Passenger passenger=new Passenger(Name,CNIC,phone,Gender,Password);
						
							try {
								ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.dat"));				
								ArrayList<Passenger> plist=(ArrayList) ois.readObject();
								ois.close();
								plist.add(passenger);
								ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Data.dat"));
								oos.writeObject(plist);
								oos.close();	

								f.dispose(); 
								JOptionPane.showMessageDialog(f,"Successfully Registered..!");
								loginclass.loginmethod();
							} catch (IOException | ClassNotFoundException e1) {							
								e1.printStackTrace();
							}
						}
					}catch(HeadlessException | ClassNotFoundException | IOException e1) {
						e1.printStackTrace();
					}
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
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(j1);
		f.add(l4);		
		f.add(l5);        
		f.add(t3);     
		f.add(b1);
		f.add(b2);
        f.add(t4);

		//Setting Frame Bounds
		f.setLayout(null);
		f.setSize(700, 400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
    }
}
