package sample;

/**
 * Created by jeffryporter on 5/31/16.
 */
public class Contact
{
    private String name;
    private String phoneNumber;
    private String Email;

    //constructor
    public Contact(String name, String phoneNumber, String email)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        Email = email;
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return name + ", " + phoneNumber +
                ", " + Email;
    }


}
