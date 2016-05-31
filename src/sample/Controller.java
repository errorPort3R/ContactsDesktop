package sample;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.*;

public class Controller
{

    @FXML
    ListView<String> nameList;

    @FXML
    ListView<String> phoneList;

    @FXML
    ListView<String> emailList;

    ContactsList theContactsList = ContactsList.getTheContactsList();
    ObservableList<Contact> contacts;

    public void onAdd()
    {
        int index = 0;
        if (nameList.isFocused())
        {
            index = nameList.getEditingIndex();
        }
        else if (phoneList.isFocused())
        {
            index = phoneList.getEditingIndex();
        }
        else if (emailList.isFocused())
        {
            index = emailList.getEditingIndex();
        }
        else
        {

        }
        theContactsList.addContact(new Contact(nameList.getItems().get(index), phoneList.getItems().get(index), emailList.getItems().get(index)), Main.FILE_LOCATION);
    }

    public void onRemove()
    {

    }

    public void populateOnLoad(ArrayList<Contact> contacts)
    {
        for (int i = 0;i<contacts.size();i++)
        {
            this.contacts.add(contacts(i));
            nameList.setItems((String)this.contacts.get(i).getName());
            phoneList.setItems(this.contacts.get(i).getPhoneNumber());
            emailList.setItems(this.contacts.get(i).getEmail());
        }
        nameList.setItems(this.contacts.get().getName());
    }


}
