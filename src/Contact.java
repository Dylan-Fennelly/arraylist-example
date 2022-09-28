public class Contact
{
    private String name;
    private String relationship;
    private String phoneNumber;

    public Contact(String name,String phoneNumber, String relationship )
    {
        this.name = name;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public static Contact createContact(String name, String relationship,String phoneNumber)
    {
        return new Contact(name,relationship,phoneNumber);
    }
}
