import java.sql.SQLOutput;
import java.util.Scanner;

public class MobileMain
{
    private static Scanner keyboard = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("087-7799234","Three");

    public static void main(String[] args)
    {
        boolean quit =false;
        turnOnPhone();
        printActions();
        while(!quit)
        {
            System.out.println("Enter action: (6 to show available actions");
            int action = keyboard.nextInt();
            keyboard.nextLine();


            switch(action)
            {
                case 0:
                    System.out.println("Shuting down");
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
            System.out.println("New contact added: name="+name+" ,phone "+phoneNumber);

        }
        else
        {
            System.out.println("Cannot add "+name + " already exists");
        }
    }
    private void updateContact()
    {
        System.out.println("Enter existing contact name: ");
        String name = keyboard.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null)
        {
            System.out.println("Contact was not found");
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
            else
            {
                System.out.println("Error updating the record");
            }
        }

    }

}
