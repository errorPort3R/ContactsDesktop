package sample;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable
{

    @FXML
    ListView contactList;

    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    static ObservableList<Contact> contactsOL = FXCollections.observableArrayList();

    public void onAdd()
    {
        contactsOL.add(new Contact(name.getText(), phone.getText(), email.getText()));
        saveContacts(contactsOL, Main.FILE_LOCATION);
        contactList.refresh();
        name.clear();
        phone.clear();
        email.clear();
    }

    public void onRemove()
    {
        SelectionModel model = contactList.getSelectionModel();
        Contact contact = (Contact)model.getSelectedItem();
        contactsOL.remove(contact);
        saveContacts(contactsOL, Main.FILE_LOCATION);
    }

    public static void loadContacts(String fileLoc)
    {
        File f = new File(fileLoc);
        try
        {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            ArrayList<HashMap<String, String>> contactsHash = parser.parse(contents);
            for (HashMap h : contactsHash)
            {
                contactsOL.add(new Contact((String)h.get("name"), (String)h.get("phoneNumber"),(String)h.get("email")));
            }
            System.out.println();
        }
        catch (FileNotFoundException e)
        {

        }
    }

    public void saveContacts(ObservableList<Contact> contacts, String fileLoc)
    {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(contactsOL);
        File f = new File(fileLoc);
        try
        {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        contactList.setItems(contactsOL);
        contactList.refresh();
    }
}
