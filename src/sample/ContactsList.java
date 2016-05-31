package sample;

import javafx.collections.ObservableList;
import jodd.json.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jeffryporter on 5/31/16.
 */
public class ContactsList
{
    //declare variables
    private static ContactsList theContactsList;
    private static ObservableList<Contact> contacts;

    //constructor
    private ContactsList()
    {
    }

    //methods
    public static ContactsList getTheContactsList()
    {
        if (theContactsList == null)
        {
            theContactsList = new ContactsList();
        }
        return theContactsList;
    }

    public void addContact(Contact newContact, String fileLoc)
    {
        contacts.add(newContact);
        saveContacts(fileLoc);
    }

    public Contact removeContact(int index)
    {
        Contact contact = contacts.get(index);
        contacts.remove(index);
        return contact;
    }

    public static void loadContacts(String fileLoc) throws FileNotFoundException {

        File f = new File(fileLoc);
        Scanner fileScanner =  new Scanner(f);
        while (fileScanner.hasNext())
        {
            String line = fileScanner.nextLine();
            String[] fields = line.split("\\|");
            Contact contact = new Contact(fields[0], fields[1], fields[2]);
            contacts.add(contact);
        }
    }

    public void saveContacts(String fileLoc)
    {
        try
        {
            PrintWriter output = new PrintWriter(fileLoc, "UTF-8");
            for (int i = 0; i < contacts.size(); i++)
            {
                output.printf("%s|%d|%s\n", contacts.get(i).getName(), contacts.get(i).getPhoneNumber(), contacts.get(i).getEmail());
            }
            output.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
