import java.util.ArrayList;

public class Attendee extends Person{

    private ArrayList<Event> schedule;

    public Attendee(String username, String password) {
        super(username, password);
        this.contactList = new ArrayList<String>();
        this.isSpeaker = false;
        this.isAttendee = true;
        this.isOrganizer = false;
        this.schedule = new ArrayList<Event>();
    }

    @Override
    ArrayList<String> getContactList() {
        return this.contactList;
    }

    @Override
    void addToContactList(String contact) {
        this.contactList.add(contact);
    }

    @Override
    boolean isSpeakerType() {
        return this.isSpeaker;
    }

    @Override
    boolean isAttendeeType() {
        return this.isAttendee;
    }

    @Override
    boolean isOrganizerType() {
        return this.isOrganizer;
    }
}
