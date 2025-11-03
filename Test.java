package RaliwayManagementSystem;

import java.io.Serializable;
import java.io.*;
import java.util.*;

public class Test implements Serializable{
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        File Info=new File("Data.dat");
		File Trains = new File("Trains.dat");
		File BookedTickets = new File("BookedTickets.dat");
		Info.createNewFile();
		Trains.createNewFile();
		BookedTickets.createNewFile();

        ArrayList<Passenger> Passengerlist = new ArrayList<Passenger>();
		Passengerlist.add(new Passenger("admin", "3230471789119", "03020005625", "M","admin"));
		Passengerlist.add(new Passenger("Zahid",  "3230471789112", "03020005626", "M","Pakistan"));
		Passengerlist.add(new Passenger("Shams",  "3230471789111", "03020005627", "M","12345"));
		Passengerlist.add(new Passenger("Amna",   "3230471789110", "03020005628", "F","Amna"));
        
    	ArrayList<Train> Trainlist = new ArrayList<Train>();
        Trainlist.add( new Train ("Lahore-Pindi Express",  "Lahore",     "Rawalpindi", "1 PM", "6 PM" , 850));
		Trainlist.add( new Train ("Lahore-Pindi Express",  "Rawalpindi", "Lahore",     "2 PM", "8 PM", 850));
		Trainlist.add( new Train ("Pakistan Express 14UP", "Lahore",     "Gujranwala", "3 PM", "5 PM", 850));
		Trainlist.add( new Train ("Pakistan Express 14UP", "Gujranwala", "Lahore",     "4 PM", "6 PM", 850));
		Trainlist.add( new Train ("Pakistan Express 14UP", "Wazirabad",  "Rawalpindi", "5 PM", "9 PM", 850));
		Trainlist.add( new Train ("Pakistan Express 14UP", "Rawalpindi", "Wazirabad",  "6 PM", "10 PM", 850));
		Trainlist.add( new Train ("Lasani Express 16DN",   "Rawalpindi", "Multan",     "7 PM", "9 AM", 1500));
		Trainlist.add( new Train ("Lasani Express 16DN",   "Multan",     "Rawalpindi", "8 PM", "10 AM", 1500));
		Trainlist.add( new Train ("Shaheen Express 16DN",  "Multan",     "Lahore",     "9 PM", "2 AM", 2000));
		Trainlist.add( new Train ("Shaheen Express 16DN",  "Lahore",     "Multan",     "10 PM","3 AM", 2000));
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Data.dat"));
		ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("Trains.dat"));
		os.writeObject(Trainlist);
		oos.writeObject(Passengerlist);
		oos.close();
		os.close();

		//Ticket.BookTicket();
        loginclass.loginmethod();
    }
}