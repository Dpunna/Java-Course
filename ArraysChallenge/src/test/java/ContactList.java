import java.util.ArrayList;
import java.util.List;

/**
 * Created by dilip on 31/07/17.
 */
public class ContactList {
    List<Contact> contacts;

    public ContactList() {
        contacts = new ArrayList<Contact>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }


    public boolean doesExist(Contact contact) {
        return contacts.contains(contact);
    }
}
