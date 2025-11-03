package RaliwayManagementSystem;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Passenger implements Serializable{
    private String name;
    private String CNIC;
    private String phone;
    private String gender;
    private String password;

    public Passenger(String name, String cNIC, String phone, String gender, String password) {
        this.name = name;
        this.CNIC = cNIC;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
    }

    public static int login(String t1, String t2) throws ClassNotFoundException, IOException {       
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.dat"));
        ArrayList<Passenger> plist = (ArrayList) ois.readObject();
        ois.close();
        
        int found = 0;
        for ( int i =0; i<plist.size(); i++){
            if(t1.equals(plist.get(i).getName())){
                if(t2.equals(plist.get(i).getPassword())){
                found = 1;
                }
            }
        }
        return found;           
    }

    public static boolean search(String t1, int choice) throws IOException, ClassNotFoundException{        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.dat"));
        ArrayList<Passenger> plist = (ArrayList) ois.readObject();
        ois.close();

        boolean found = false;
        if (choice == 1){
            for ( int i = 0; i<plist.size(); i++){
                if(plist.get(i).getName().equals(t1)){
                    found = true;
                }
            }       
        }
        else if (choice == 2){
            for ( int i = 0; i<plist.size(); i++){
                if(plist.get(i).getCNIC().equals(t1)){
                    found = true;
                }
            }                  
        }
        else if (choice == 3){
            for ( int i = 0; i<plist.size(); i++){
                if(plist.get(i).getPhone().equals(t1)){
                    found = true;
                }
            }       
        }       
        return found;   
    }
 
    public static void showmyInfo() throws IOException, ClassNotFoundException{
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Data.dat"));
        ArrayList<Passenger> plist = (ArrayList)oos.readObject();
        oos.close();

        loginclass m = new loginclass();
        String text = m.getT();
        
        int j = 0;
        for(int i = 0; i<plist.size(); i++){
            if(plist.get(i).getName().equals(text)){
                j=i;
            }
        }

		// Creating a frame
		JFrame f= new JFrame( "My Information");
		Color c = new Color(210,210,238);
		f.getContentPane().setBackground(c);

		// Declaring labels
		JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

		// Declaring buttons
		JButton b1, b2;

		// Creating the Labels 
		l0 = new JLabel("My Information");
		l0.setBounds(20, 4,200, 50);
		l0.setFont(new Font("Stencil",Font.BOLD,20));
		l0.setForeground(Color.blue);

        l1 = new JLabel("Name:");
        l1.setBounds(40, 40, 50,50);
        l1.setFont(new Font("Arial",Font.BOLD,15));

        l2 = new JLabel("CNIC:");
        l2.setBounds(320, 40, 50, 50);
        l2.setFont(new Font("Arial",Font.BOLD,15));

        l3 = new JLabel("Phone:");
        l3.setBounds(40, 140, 80,50);
        l3.setFont(new Font("Arial",Font.BOLD,15));

        l4 = new JLabel("Gender:");
        l4.setBounds(320, 140, 80, 50);
        l4.setFont(new Font("Arial",Font.BOLD,15));

        l5 = new JLabel("No. of Booked Tickets:");
        l5.setBounds(40, 240, 180,50);
        l5.setFont(new Font("Arial",Font.BOLD,15));

        l6 = new JLabel(text);
        l6.setBounds(115, 40, 100, 50);

        l7 = new JLabel(plist.get(j).getCNIC());
        l7.setBounds(410, 40, 100, 50);

        l8 = new JLabel(plist.get(j).getPhone());
        l8.setBounds(115, 140, 100, 50);

        l9 = new JLabel(plist.get(j).getGender());
        l9.setBounds(410, 140, 100, 50);

        String str = Integer.toString(BookedTickets.getTickets());
        l10 = new JLabel(str);
        l10.setBounds(215, 240, 100, 50);


		// Creating buttons
        b1 = new JButton("Update Profile");
		b1.setBounds(300, 360, 120, 30);
		b2 = new JButton("Back");
		b2.setBounds(421, 360, 70, 30);

		// Adding action listeners
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
                    updateprofile();
                    f.dispose();
                } catch (ClassNotFoundException | IOException e1) {
                    e1.printStackTrace();
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
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(l8);
        f.add(l9);
        f.add(l10);
		f.add(b1);
        f.add(b2);

        //Setting Frame Bounds
		f.setLayout(null);
		f.setSize(600, 500);
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

    static int k = 0;
    public static void updateprofile() throws IOException, ClassNotFoundException{
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Data.dat"));
        ArrayList<Passenger> plist = (ArrayList)oos.readObject();
        oos.close();

        loginclass m = new loginclass();
        String text = m.getT();     

        for(int i = 0; i<plist.size(); i++){
            if(plist.get(i).getName().equals(text)){
                k=i;
            }
        }

        //Creating a frame
        JFrame j = new JFrame("Update Profile");
        Color c= new Color(210,210,238);
        j.getContentPane().setBackground(c);

        //Declaring Labels
        JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9;

        //Declaring Text fields
        JTextField t1, t2, t3;

        //Declaring buttons
        JButton b1, b2;

        //Creating labels
        l0 = new JLabel("Update Profile");
		l0.setBounds(20, 4,200, 50);
		l0.setFont(new Font("Stencil",Font.BOLD,20));
		l0.setForeground(Color.blue);
        
        l1 = new JLabel("User Name:");
        l1.setBounds(40, 40, 100,50);
        l1.setFont(new Font("Arial",Font.BOLD,15));

        l2 = new JLabel("CNIC:");
        l2.setBounds(340, 40, 50, 50);
        l2.setFont(new Font("Arial",Font.BOLD,15));

        l3 = new JLabel("New Phone:");
        l3.setBounds(40, 140, 100,50);
        l3.setFont(new Font("Arial",Font.BOLD,15));

        l4 = new JLabel("Gender:");
        l4.setBounds(340, 140, 80, 50);
        l4.setFont(new Font("Arial",Font.BOLD,15));

        l5 = new JLabel("Current Password:");
        l5.setBounds(40, 240, 150,50);
        l5.setFont(new Font("Arial",Font.BOLD,15));

        l6 = new JLabel("New Password:");
        l6.setBounds(40, 290, 180,50);
        l6.setFont(new Font("Arial",Font.BOLD,15));

        l7 = new JLabel(plist.get(k).getName());
        l7.setBounds(161, 40, 100, 50);

        l8 = new JLabel(plist.get(k).getCNIC());
        l8.setBounds(410, 40, 100, 50);

        l9 = new JLabel(plist.get(k).getGender());
        l9.setBounds(410, 140, 100, 50);

        //Creating Text fields
        t1 = new JTextField("03");
        t1.setBounds(161, 150, 150, 30);
        t2 = new JTextField();
        t2.setBounds(161, 250, 150, 30);
        t3 = new JTextField();
        t3.setBounds(161, 300, 150, 30);

        //Creating Buttons
        b1 = new JButton("Save");
        b1.setBounds(350, 330, 80, 40);
        b2 = new JButton("Cancel");
        b2.setBounds(431, 330, 80, 40);

        //Adding Action Listeners
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()){
                    JOptionPane.showMessageDialog(j, "Any field shouldn't be empty..!");
                }
                else if(t1.getText().length()!=11){
                    JOptionPane.showMessageDialog(j, "Phone No. should contain 11 Charcters..!");
                }
                else if(t2.getText().equals(t3.getText())){
                    JOptionPane.showMessageDialog(j,"Current and new Password cannot be same");
                }
                else if(t2.getText().equals(plist.get(k).getPassword())){
                    plist.get(k).setPassword(t3.getText());
                    plist.get(k).setPhone(t1.getText());

                    try {
                        ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("Data.dat"));
                        os.writeObject(plist);
                        os.close();
                        JOptionPane.showMessageDialog(j,"Details successfully saved");
                        j.dispose();
                        Menu.menu();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(j,"Incorrect Current Password..!");
                }
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Menu.menu();
                j.dispose();
            }
        });

        //Adding created Objects in JFrame
        j.add(l0);
        j.add(l1);
        j.add(l2);
        j.add(l3);
        j.add(l4);
        j.add(l5);
        j.add(l6);
        j.add(l7);
        j.add(l8);
        j.add(l9);
        j.add(t1);
        j.add(t2);
        j.add(t3);
        j.add(b1);
        j.add(b2);

        //Setting bounds for Frame
        j.setLayout(null);
        j.setSize(600, 500);
		j.setLocationRelativeTo(null);	
		j.setVisible(true);	
		
        //Creating Closing Dialogue
		j.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		j.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				int x = JOptionPane.showConfirmDialog(null, "Do You really want to close?","Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(x==JOptionPane.YES_OPTION){
					e.getWindow().dispose();
					
				}
			}
		});
    }

    public static void deletaccount() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Data.dat"));
        ArrayList<Passenger> plist = (ArrayList)oos.readObject();
        oos.close();

        loginclass m = new loginclass();
        String text = m.getT();

        for(int i = 0; i<plist.size(); i++){
            if(plist.get(i).getName().equals(text)){
                k=i;
            }
        }

        //Creating a frame
        JFrame j = new JFrame("Update Profile");
        Color c= new Color(210,210,238);
        j.getContentPane().setBackground(c);

        //Declaring Labels
        JLabel l0, l1;

        //Declaring Text field
        JTextField t1;

        //Declaring buttons
        JButton b1, b2;

        //Creating labels
        l0 = new JLabel("Delete Profile");
        l0.setBounds(20, 4,200, 50);
        l0.setFont(new Font("Stencil",Font.BOLD,20));
        l0.setForeground(Color.blue);

        l1 = new JLabel("Enter Password:");
        l1.setBounds(80, 40, 150,50);
        l1.setFont(new Font("Arial",Font.BOLD,15));

        //Creating Text fields
        t1 = new JTextField();
        t1.setBounds(75, 80, 150, 30);

        //Creating Buttons
        b1 = new JButton("Delete");
        b1.setBounds(70, 200, 80, 40);
        b2 = new JButton("Cancel");
        b2.setBounds(151, 200, 80, 40);

        //Adding action listeners
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(j, "Please fill the field..!");
                }
                else if(t1.getText().equals(plist.get(k).getPassword())){
                    try {
                        ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("Data.dat"));
                        os.writeObject(plist);
                        os.close();
                        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete your account?","Delete", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (x == JOptionPane.YES_OPTION){
                            plist.remove(k);
                            JOptionPane.showMessageDialog(j,"Successfully Deleted your Account");
                            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Data.dat"));
                            oos.writeObject(plist);
                            oos.close();
                        }
                        j.dispose();
                        loginclass.loginmethod();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(j,"Incorrect Password..!");
                }
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Menu.menu();
                j.dispose();
            }
        });

        //Adding created Objects in Frame
        j.add(l0);
        j.add(l1);
        j.add(t1);
        j.add(b1);
        j.add(b2);

        //Setting Bounds for Frame
        j.setLayout(null);
        j.setSize(300, 300);
        j.setLocationRelativeTo(null);
        j.setVisible(true);

        //Creating Closing Dialogue
        j.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        j.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int x = JOptionPane.showConfirmDialog(null, "Do You really want to close?","Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(x==JOptionPane.YES_OPTION){
                    e.getWindow().dispose();
                }
            }
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String cNIC) {
        CNIC = cNIC;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
