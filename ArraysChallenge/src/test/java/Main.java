import java.util.Scanner;

/**
 * Created by dilip on 25/07/17.
 */
public class Main {
        private static Scanner s = new Scanner(System.in);
        private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args){

        ContactList contactList = new ContactList();

        Contact sam = Contact.createContact("Sam", "089234234");
        Contact erica = Contact.createContact("Eric", "089234234");

        contactList.addContact(Contact.createContact("John", "089234234"));
        contactList.addContact(sam);
        contactList.addContact(erica);

        if (contactList.doesExist(erica)) {

        }



        boolean quit = false;
        startPhone();
        printInstructions();
        while(!quit) {
            System.out.println("\nEnter action: ");
            int action = s.nextInt();
            s.nextLine();

            switch(action) {
                case 0:
                    System.out.println("\nShutting down..");
                    quit=true;
                    break;
                case 1:
                    mobilePhone.printListOfContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContacts();
                    break;
                case 6:
                    printContacts();
                    break;
            }
        }
    }

    private static void printContacts(){
        mobilePhone.printListOfContacts();
    }

        public static void startPhone(){
            System.out.println("Starting Phone....");
        }

    public static void printInstructions() {
        System.out.println("\nAvailable actions: \npress: ");
        System.out.println(" 0- To shutdown\n" +
       "1- To print the contact list\n" +
       " 2- To add a contact to the list\n" + " 3- To modify the contact in the list\n" +
        "4- To remove the contact in the list\n" +
        " 5- To query an existing contact in the list\n" +
        "6- To print a list of available actions.");
        System.out.println("Choose your actions: ");
    }

    public static void addContact(){
        System.out.println("Please add the contact name:");
        String name = s.nextLine();
        System.out.println("Please add the contact number:");
        String phoneNumber = s.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if(mobilePhone.storeContact(newContact)) {
            System.out.println("New contact added: name = " +name + ", phone =" + phoneNumber);
        }
        else {
            System.out.println("cannot add, " + name + "already on file ");
        }
    }

    public static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String contactName = s.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(contactName);
        if(existingContactRecord ==null){
            System.out.println("no contact found ");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = s.nextLine();
        System.out.println("Enter new contact phone: ");
        String newNum = s.nextLine();
        System.out.println("New contact num: ");
        Contact newContact = Contact.createContact(newName,newNum);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("successfully updated the record");
        }
        else {
            System.out.println("Error updating the record. ");
        }
    }

    public static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String contactName = s.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(contactName);
        if (existingContactRecord == null) {
            System.out.println("no contact found ");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("successfully deleted");
        } else {
            System.out.println("Error deleting contact. ");
        }
    }

    public static void queryContacts() {
        System.out.println("Enter existing contact name: ");
        String contactName = s.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(contactName);
        if (existingContactRecord == null) {
            System.out.println("no contact found ");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + "phoneNumber is " + existingContactRecord.getPhoneNumber());

    }

    public static void searchContact(){
        System.out.println("Enter the contact to search for:");
        String searchContact = s.nextLine();
        if(mobilePhone.onFile(searchContact)) {
            System.out.println("Found " + searchContact);
        } else {
            System.out.println(searchContact + "not in a list.");
        }
    }
}
