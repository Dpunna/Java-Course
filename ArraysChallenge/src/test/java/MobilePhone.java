import java.util.ArrayList;

/**
 * Created by dilip on 25/07/17.
 */
public class MobilePhone {
    private ArrayList<Contact> mobilePhone = new ArrayList<Contact>();

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition<0) {
            System.out.println(oldContact.getName() +", was not found.");
            return false;
        }
        mobilePhone.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " +newContact.getName());
        return true;
    }

    public boolean storeContact(Contact contact) {
        if(findContact(contact.getName())>=0){
            System.out.println("Contact is already on file");
            return false;
        }
      mobilePhone.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
       return mobilePhone.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i=0; i<mobilePhone.size(); i++){
            Contact contact = mobilePhone.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >=0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >=0){
            return mobilePhone.get(position);
        }

        return null;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if(foundPosition<0) {
            System.out.println(contact.getName() +", was not found.");
            return false;
        }
        mobilePhone.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }
    public void printListOfContacts(){
        System.out.println("You have " + mobilePhone.size() + "contacts in your mobile phone. ");
        for(int i=0; i<mobilePhone.size(); i++){
            System.out.println((i+1) + "." +mobilePhone.get(i).getName() + "->" + mobilePhone.get(i).getPhoneNumber());
        }
    }

    public boolean onFile(String searchItem) {
        int position = findContact(searchItem);
        if(position >=0){
            return true;
        }
        return false;
    }

}
