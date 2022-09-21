import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    private static Scanner keyboard = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args)
    {
        boolean quit = false;
        int choice = 0;

        printInstruction();
        while(!quit)
        {
            System.out.println("Enter your choice");
            try
            {
                choice = keyboard.nextInt();
            }
            catch(InputMismatchException ime)
            {
                System.out.println("Invalid input. PLease enter a number in the range 1-6");
            }

            keyboard.nextLine();

            switch(choice)
            {
                case 0:
                    printInstruction();
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
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Not a valid input enter a number between 0 and 6");
            }
        }
    }

    private static void searchForItem()
    {
        System.out.println("Please enter the item you wish to search for ");
        String searchItem = keyboard.nextLine();
        if(groceryList.onFile(searchItem))
        {
            System.out.println("Found  "+searchItem);
        }
        else
        {
            System.out.println(searchItem + " was not found");
        }
    }

    private static void removeItem()
    {
        System.out.println("Please enter the item you would like to remove ");
        groceryList.removeGroceryItem(keyboard.nextLine());
    }

    private static void modifyItem()
    {
        System.out.println("Please enter the item you wish to modify: ");
        String currentItem = keyboard.nextLine();
        System.out.println("Please enter the new item: ");
        String newItem = keyboard.nextLine();
        groceryList.modifyGroceryItem(currentItem,newItem);
    }

    private static void addItem()
    {
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(keyboard.nextLine());
    }

    private static void printInstruction()
    {
        System.out.println("\nPress");
        System.out.println("\t 0 - To choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list ");
        System.out.println("\t 5 - To search if an item is present");
        System.out.println("\t 6 - To exit");

    }
}