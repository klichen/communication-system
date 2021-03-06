
import java.util.Scanner;

public class OrganizerMainScreen {
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    OrganizerSystem os;
    SpeakerManager sm;
    String username;

    /**
     * Create an ControllerLayer.OrganizerMainScreen object and sets its variables username, am, es, om, and sm to the ones passed in
     * the constructor.
     * @param username String representing a Entities.Person's username.
     * @param am UseCases.AttendeeManager object
     * @param es UseCases.EventScheduler object
     * @param om UseCases.OrganizerManager object
     * @param sm UseCases.SpeakerManager object
     */
    public OrganizerMainScreen(String username, AttendeeManager am, EventScheduler es, OrganizerManager om,
                               SpeakerManager sm){
        this.username = username;
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
        this.os = new OrganizerSystem(am, es, om, sm);
    }

    /**
     * Prints the available actions to the screen, and takes in inputs accordingly.
     */
    public void run() {
        boolean logOut = false;
        while (!logOut) {

            System.out.println("Hello " + username + ".");
            System.out.println("To do an action, please press the corresponding number:");
            System.out.println("1 - Schedule an event (enter room into system)");
            System.out.println("2 - Create speaker account");
            System.out.println("3 - Cancel an event");
            System.out.println("4 - Send message");
            System.out.println("5 - Read messages received");
            System.out.println("6 - Log out");

            String response = os.readString();

            switch (response) {
                case "1":
                    // Schedule an event (enter room into system)
                    System.out.println("Please enter the room number of your event: ");
                    String roomNum = os.readString();
                    System.out.println("Please enter the id of your event: ");
                    String eventId = os.readString();
                    System.out.println("Please enter the hour (military time) your event starts at: ");
                    int time = os.readInt();

                    System.out.println("Please enter the username of the Entities.Speaker of this event: ");
                    String eventSpeaker = os.readString();

                    boolean eventCreated = os.createEvent(roomNum, eventId, time, eventSpeaker);
                    if (eventCreated) {
                        System.out.println("Your Entities.Event was created successfully.");
                    } else {
                        System.out.println("This Entities.Event can not be created.");
                    }
                    break;
                case "2":
                    // Create speaker account
                    System.out.println("Please username of the Entities.Speaker account: ");
                    String speakerUsername = os.readString();
                    System.out.println("Please enter the password of the Entities.Speaker account: ");
                    String speakerPass = os.readString();

                    boolean speakerCreated = os.createSpeaker(speakerUsername, speakerPass);
                    if (speakerCreated) {
                        System.out.println("The Entities.Speaker account was created successfully.");
                    } else {
                        System.out.println("This Entities.Speaker account can not be created.");
                    }
                    break;
                case "3":
                    // Cancel an event
                    System.out.println("Please enter the id of your event: ");
                    String eventId2 = os.readString();

                    boolean eventCancelled = os.cancelEvent(eventId2);
                    if (eventCancelled) {
                        System.out.println("The Entities.Event was cancelled successfully.");
                    } else {
                        System.out.println("The Entities.Event could not be cancelled.");
                    }
                    break;
                case "4":
                    // Send message
                    OrganizerMessageScreen oMsg = new OrganizerMessageScreen(username, am, om, sm);
                    oMsg.run();
                    break;
                case "5":
                    // Read messages received
                    ReadMessageScreen messageScreen = new ReadMessageScreen(am, om, sm, username);
                    messageScreen.run();
                    break;

                case "6":
                    // Log out
                    logOut = true;
            }
        }
    }
}
