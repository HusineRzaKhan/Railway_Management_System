package RaliwayManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Train  implements Serializable{
    static String TrainName;
    static String from;
    static String to;
    static String DepTime;
    static String ArrTime;
	static int fare ;

	public Train(String trainName, String from, String to, String depTime, String arrTime, int fare) {
        TrainName = trainName;
        this.from = from;
        this.to = to;
        DepTime = depTime;
        ArrTime = arrTime;
		this.fare = fare ;
    }

    public static void frame() throws FileNotFoundException, IOException, ClassNotFoundException{
        JFrame jf = new JFrame();
		Color c = new Color(210,210,238);
		jf.getContentPane().setBackground(c);

		// Declaring labels, Buttons & RadioButtons
		JLabel H1, H2, H3, H4, L0, L1, L2, L3, L4, L5, L6,L7, L8;
		JRadioButton r1, r2, r3, r4, r5, r6, r7, r8;
		JButton B1, B2;

		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Trains.dat"));
		ArrayList<Train> Trainlist=(ArrayList)ois.readObject();
		ois.close();

		//Creating the Labels
		L0 = new JLabel("TRAINS LIST");
		L0.setBounds(40, 4,200, 50);
		L0.setFont(new Font("Stencil",Font.PLAIN,20));
		L0.setForeground(Color.blue);
		
		H1 = new JLabel("Name");
		H1.setBounds(130, 40, 100,40);
		H1.setFont(new Font("Elephant",Font.PLAIN,15));
		H1.setForeground(Color.darkGray);
		H2 = new JLabel("Rout");
		H2.setBounds(310, 40, 100,40);
		H2.setFont(new Font("Elephant",Font.PLAIN,15));
		H2.setForeground(Color.darkGray);
		H3 = new JLabel("Economy Price");
		H3.setBounds(530, 40, 130,40);
		H3.setFont(new Font("Elephant",Font.PLAIN,15));
		H3.setForeground(Color.darkGray);
		H4 = new JLabel(" Stops ");
		H4.setBounds(685, 40, 130,40);
		H4.setFont(new Font("Elephant",Font.PLAIN,15));
		H4.setForeground(Color.darkGray);

		L1 = new JLabel("Lahore-Pindi Express 1UP           Lahore->Pindi   Nonstop                                                    850                               0           ");
		L1.setBounds(90, 60, 1000, 50);
		L2 = new JLabel("Lahore-Pindi Express 2DN           Pindi -> Lahore  Nonstop                                                   850                                0           ");
		L2.setBounds(90, 130, 900, 50);
		L3 = new JLabel("Pakistan Express 14UP                 Lahore-> Gujranwala -> Wazirabad -> Pindi                    850  	                              2         ");
		L3.setBounds(90, 200, 900, 50);
		L4 = new JLabel("Pakistan Express 16DN                 Pindi-> Wazirabad -> Gujranwala -> Lahore                    850                                   2      ");
		L4.setBounds(90, 270, 900, 50);
		L5 = new JLabel("Lasani Express 4UP                       Multan -> Lahore Nonstop                                                1500                               0         ");
		L5.setBounds(90, 340, 900, 50);  
		L6 = new JLabel("Lasani Express 6DN                       Lahore -> Multan Nonstop                                                1500                               0         ");
		L6.setBounds(90, 410, 900, 50);
		L7 = new JLabel("Shaheen Express 22DN                 Multan -> Pindi Nonstop                                                   2000                                  0      ");
		L7.setBounds(90, 480, 900, 50);
		L8 = new JLabel("Shaheen Express 24DN                 Pindi-> Multan Nonstop                                                    2000                                  0      ");
		L8.setBounds(90, 550, 900, 50);

		//Creating the Buttons and its bounds
		B1 = new JButton("Select");
		B1.setBounds(560, 650, 100, 50);
		B2 = new JButton("Back");
		B2.setBounds(661, 650, 100, 50);

		//Creating RadioButtons
		r1=new JRadioButton();    
		r2=new JRadioButton();
		r3=new JRadioButton();    
		r4=new JRadioButton();
		r5=new JRadioButton();    
		r6=new JRadioButton();
		r7=new JRadioButton();    
		r8=new JRadioButton();

		r1.setBounds(60,72, 20,30);    
		r2.setBounds(60,142,20,30); 
		r3.setBounds(60,212,20,30);    
		r4.setBounds(60,282,20,30); 
		r5.setBounds(60,352,20,30);    
		r6.setBounds(60,422,20,30); 
		r7.setBounds(60,492,20,30);    
		r8.setBounds(60,562,20,30);
		r1.setBackground(null); 
		r2.setBackground(null); 
		r3.setBackground(null); 
		r4.setBackground(null); 
		r5.setBackground(null); 
		r6.setBackground(null); 
		r7.setBackground(null); 
		r8.setBackground(null); 

		//Grouping RadioButtons
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		bg.add(r5);
		bg.add(r6);
		bg.add(r7);
		bg.add(r8);

		// Adding the created objects in the Panel
		jf.add(L0);
		jf.add(L1);
		jf.add(L2);
		jf.add(L3);
		jf.add(L4);
		jf.add(L5);
		jf.add(L6);
		jf.add(L7);
		jf.add(L8);
		jf.add(r1);
		jf.add(r2);
		jf.add(r3);
		jf.add(r4);
		jf.add(r5);
		jf.add(r6);
		jf.add(r7);
		jf.add(r8);
		jf.add(B1);
		jf.add(B2);
		jf.add(H1);
		jf.add(H2);
		jf.add(H3);
		jf.add(H4);

		//Setting Bounds for Frame
		jf.setLayout(null);
		jf.setSize(900, 800);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);	

		//Creating Closing dialogue for frame when "X" is clicked
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int x = JOptionPane.showConfirmDialog(null, "Do You really want to close?","Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(x==JOptionPane.YES_OPTION){
					e.getWindow().dispose();
					
				}
			}
		});

		//Adding Action Listeners
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{				
				try {
					Ticket.BookTicket();
					jf.dispose();
				}
				catch (IOException | ClassNotFoundException ex) {
					System.out.println(ex);
				}
			}
		});
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{				
				Menu.menu();
				jf.dispose();
			}
		});
    }	
}