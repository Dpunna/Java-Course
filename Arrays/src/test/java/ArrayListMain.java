import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dilip on 20/07/17.
 */
public class ArrayListMain {
    private static Scanner s = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();


    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = s.nextInt();
            s.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0- To print choice options");
        System.out.println("\t 1- To print the list of grocery items");
        System.out.println("\t 2- To add an item to the list");
        System.out.println("\t 3- To modify an item to the list");
        System.out.println("\t 4- To remove an item the list");
        System.out.println("\t 5- To Search an item in the list");
        System.out.println("\t 6- To quit the application");
    }

    public static void  addItem() {
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(s.nextLine());
    }

    public static void modifyItem() {
        System.out.println("current item name:");
        String itemNo= s.nextLine();
        System.out.println("Enter new item: ");
        String newItem = s.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.println("Enter item number: ");
        String itemNo = s.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchItem(){
        System.out.println("Enter item to search for:");
        String searchItem = s.nextLine();
        if(groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem);
        } else {
            System.out.println(searchItem + "not on file.");
        }
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
