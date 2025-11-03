package RaliwayManagementSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.io.*;
import java.util.*;

public class Search implements Serializable{
    public static void searchName()  throws IOException, FileNotFoundException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.dat"));
        ArrayList<Passenger> plist = (ArrayList)ois.readObject();
        ois.close();

            JFrame j_f = new JFrame("Name");
            Color c = new Color(210,210,238);
            j_f.getContentPane().setBackground(c);
            JLabel l_0;
            l_0 = new JLabel("Enter Name: ");
            l_0.setBounds(20, 4,200, 50);
            l_0.setFont(new Font("Stencil",Font.PLAIN,20));
            l_0.setForeground(Color.blue);
            JTextField jt_f = new JTextField();
            jt_f.setBounds(150, 100, 130, 30);
            
            for ( int i = 0; i<plist.size(); i++){
                if(plist.get(i).getName().equals(jt_f.getText())){
                    
                }
            } 
        }
    public static void 	searchCNIC() throws IOException, FileNotFoundException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.dat"));
        ArrayList<Passenger> plist = (ArrayList)ois.readObject();
        ois.close();


            JFrame j_f = new JFrame("CNIC");
            Color c = new Color(210,210,238);
            j_f.getContentPane().setBackground(c);
            JLabel l_0;
            l_0 = new JLabel("Enter CNIC: ");
            l_0.setBounds(20, 4,200, 50);
            l_0.setFont(new Font("Stencil",Font.PLAIN,20));
            l_0.setForeground(Color.blue);
            JTextField jt_f = new JTextField();
            jt_f.setBounds(150, 100, 130, 30);
            
            for ( int i = 0; i<plist.size(); i++){
                if(plist.get(i).getCNIC().equals(jt_f.getText())){
                    
                }
            }   
    }
    public static void 	searchPhone() throws IOException, FileNotFoundException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.dat"));
        ArrayList<Passenger> plist = (ArrayList)ois.readObject();
        ois.close();


            JFrame j_f = new JFrame("Phone");
            Color c = new Color(210,210,238);
            j_f.getContentPane().setBackground(c);
            JLabel l_0;
            l_0 = new JLabel("Enter Phone: ");
            l_0.setBounds(20, 4,200, 50);
            l_0.setFont(new Font("Stencil",Font.PLAIN,20));
            l_0.setForeground(Color.blue);
            JTextField jt_f = new JTextField();
            jt_f.setBounds(150, 100, 130, 30);
            
            for ( int i = 0; i<plist.size(); i++){
                if(plist.get(i).getPhone().equals(jt_f.getText())){
                    
                }
            }    
    }
}

//File Info = new File(Test.class.getResource("Data.dat").getFile());