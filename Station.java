package RaliwayManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Station {



    public static void stframe() {
        JLabel L0, L1, L2, L3, L4,L5, L6;
        L0 = new JLabel("Station Informations");
		L0.setBounds(40, 4,200, 50);
		L0.setFont(new Font("Segoe UI",Font.BOLD,20));
		L0.setForeground(Color.blue);
        JFrame jf = new JFrame("Train Show");
		Color c1 = new Color(210,210,238);
		jf.getContentPane().setBackground(c1);
        L1 = new JLabel("Lahore Junction Address  \t Near Empress Road, Lahore  \t 6 Trains ( 3 UP and 3 DOWN )");
		L1.setBounds(75, 60, 900, 50);
		L2 = new JLabel("Rawalpindi Railway Station  \t Saddar, beside Railway Colony, Rawalpindi  \t 6 Trains ( 3 UP and 3 DOWN )");
		L2.setBounds(75, 130, 900, 50);
		L3 = new JLabel("Wazirabad Junction Address  \t Beside Circular Road , Wazirabad  \t 2 Trains ( 1 UP and 1 DOWN )");
		L3.setBounds(75, 200, 900, 50);
		L4 = new JLabel("Gujranwala Railway Station Address  \t Near Civil Lines ,GT Road, Eminabad  Gujranwala  \t 2 Trains ( 3 UP and 3 DOWN )");
		L4.setBounds(75, 270, 900, 50);
		L5 = new JLabel("Multan Cant Station       \t Multan Cantonment , Multan  \t 4 Trains ( 2 UP and 2 DOWN )");
		L5.setBounds(75, 320, 900, 50);
		L6 = new JLabel("");
		L6.setBounds(75, 350, 900, 50);
        jf.add(L0);
		jf.add(L1);
		jf.add(L2);
		jf.add(L3);
		jf.add(L4);
		jf.add(L5);
		jf.add(L6);
		jf.setLocationRelativeTo(null);
        jf.setSize(640,480);
        jf.setVisible(true);
    }

}
