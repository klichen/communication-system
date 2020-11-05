import java.util.ArrayList;

public class Attendee extends Person{
    public Attendee(String username, String password) {
        super(username, password);
        ArrayList<String> contactList = new ArrayList<String>();
    }

    @Override
    ArrayList<String> getContactList() {
        return this.contactList;
    }

    @Override
    void addToContactList(String contact) {
        this.contactList.add(contact);
    }

    // returns type of person
}
