package RaliwayManagementSystem;

import java.io.Serializable;

public class BookedTickets implements Serializable{
    String Name;
    String Cnic; 
    String Phone; 
    String Gender;
    String Date;
    static int Tickets = 0;

    public BookedTickets(String name, String cnic, String phone, String gender, String date, int tickets){
        this.Name=name;
        this.Cnic=cnic;
        this.Phone=phone;
        this.Gender=gender;
        this.Date=date;
        Tickets = tickets;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCnic() {
        return Cnic;
    }

    public void setCnic(String cnic) {
        Cnic = cnic;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public static int getTickets() {
        return Tickets;
    }

    public void setTickets(int tickets) {
        Tickets = tickets;        
    }
}