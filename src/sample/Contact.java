package sample;

/**
 * Created by jeffryporter on 5/31/16.
 */
public class Contact
{
    String name;
    String phoneNumber;
    String email;

    //constructor
    public Contact(String name, String phoneNumber, String email)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString()
    {
        return String.format("%-30s%-30s%-30s",name, phoneNumber, email);
    }


}
