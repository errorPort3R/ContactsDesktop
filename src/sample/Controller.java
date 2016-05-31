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
    ListView<Integer> phoneList;

    @FXML
    ListView<String> emailList;

    ContactsList theContactsList = ContactsList.getTheContactsList();

    public void onAdd(String name, String phone, String email)
    {
        theContactsList.addContact(new Contact(name, phone, email), Main.FILE_LOCATION);
    }

    public void onRemove()
    {

    }


}
