import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadMessageManager<T> {
    private final List<Person> people = new ArrayList<>();
    private final String currPerson;

    /**
     * The constructor for ReadMessageManager. The only parameter is the username if the logged-in user.
     * @param currPerson The username of the logged-in user.
     */
    public ReadMessageManager(String currPerson) {
        this.currPerson = currPerson;
    }

    /**
     * Precondition: T is a subtype of Entities.Person.
     * <p>
     * Extends this.people with Entities.Person objects in people
     *
     * @param people The list of Entities.Person objects to be added.
     */
    public void addUsers(List<T> people) {
        for (T person : people) {
            this.people.add((Person) person);
        }
    }

    /**
     * Returns the messages sent to the currently logged in user as a string. It takes the form
     * "sender1: message, sender2: message, ..."
     *
     * @return Returns the string of messages sent to the current user.
     */
    public List readMessage() {
        for (Person person : people) {
            if (person.getUsername().equals(currPerson)) {
                return person.getStoredMessagesList();
            }
        }
        return Collections.emptyList();
    }
}