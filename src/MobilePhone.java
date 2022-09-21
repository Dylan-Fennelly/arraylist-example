import java.util.ArrayList;

public class MobilePhone
{
    private String myNumber;
    private String provider;
    private ArrayList<String> applications;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, String provider)
    {
        this.myNumber = myNumber;
        this.provider = provider;
        this.applications = new ArrayList<>();
        this.myContacts = new ArrayList<>();

    }

    public boolean addNewContact(Contact contact)
    {
        if(findContact(contact.getName())>=0)
        {
            System.out.println("Contact already exits");
            return false;:
        }
        myContacts.add(contact);
        return true;
    }
}
