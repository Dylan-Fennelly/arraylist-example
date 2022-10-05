package MobilePhoneApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MobileMain
{
    private static Scanner keyboard = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("087-7799234","Three");

    public static void main(String[] args)
    {
        boolean quit =false;
//        turnOnPhone();
        printActions();
        while(!quit)
        {
            System.out.println("Enter action: (6 to show available actions");
            int action = keyboard.nextInt();
            keyboard.nextLine();


            switch(action)
            {
                case 0:
                    System.out.println("Shutting down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void printActions()
    {
        System.out.println("\nPress");
        System.out.println("\t 0 - To shut down phone");
        System.out.println("\t 1 - To print current contacts");
        System.out.println("\t 2 - To add a new contact to the phonebook");
        System.out.println("\t 3 - To update a current contact");
        System.out.println("\t 4 - To remove a contact from the list");
        System.out.println("\t 5 - To search if a contact is present");
        System.out.println("\t 6 - To print options");
    }


    private static void addNewContact()
    {
        System.out.println("Please enter the new contact name");
        String name = keyboard.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = keyboard.nextLine();
        System.out.println("Enter relationship");
        String relationship = keyboard.nextLine();
        Contact newContact = Contact.createContact(name,phoneNumber,relationship);
        if(mobilePhone.addNewContact(newContact))
        {
            System.out.println("New contact added: Name: "+name+", Phone: "+phoneNumber);

        }
        else
        {
            System.out.println("Cannot add "+name + " already exists");
        }
    }
    private static void updateContact()
    {
        System.out.println("Enter existing contact name: ");
        String name = keyboard.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null)
        {
            System.out.println("MobilePhoneApp.Contact was not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = keyboard.nextLine();
        System.out.println("Enter the new contact phone number:");
        String newNumber = keyboard.nextLine();
        System.out.println("Enter relationship with the new contact");
        String newRelationship = keyboard.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber,newRelationship);
        if(mobilePhone.updateContact(existingContact,newContact))
        {
            System.out.println("Successfully updated");

        }
        else
        {
            System.out.println("Error updating the record");
        }

    }
    private static void removeContact()
    {
        System.out.println("Enter existing contact name: ");
        String name = keyboard.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null)
        {
            System.out.println("MobilePhoneApp.Contact was not found");
            return;
        }
        System.out.println("Are you sure you want to delete contact"+ existingContact.getName()+"?");
        System.out.println("1 - Yes" +"\n" +
                "2 - No");
        boolean choiceLoop = false;
        int choice = 0;
        while(!choiceLoop)
        {
            try
            {
               choice = keyboard.nextInt();
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Invalid input please enter a number in the range 1-2");
            }
            switch (choice)
            {
                case 1:
                    System.out.println("Now deleting contact: "+ existingContact.getName());
                    mobilePhone.removeContact(existingContact);
                    choiceLoop = true;
                    break;
                case 2:
                    System.out.println("MobilePhoneApp.Contact: "+ existingContact.getName() + " was not deleted");
                    choiceLoop = true;
                    break;
                default:
                    System.out.println("Please enter a valid option");
            }
        }


    }
    private static void queryContact()
    {
        System.out.println("Please enter the name of the contact:");
        String name = keyboard.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null)
        {
            System.out.println("MobilePhoneApp.Contact not found");
        }
        else
        {
            System.out.println("The contact "+ existingContact.getName()+ " was found");
        }

    }


}
