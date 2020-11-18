import java.sql.SQLOutput;
import java.util.Scanner;

public class OrganizerMainScreen {
    OrganizerMessageScreen om;
    OrganizerSystem os;
    LoginType lt;

    public void run(){
        String username = lt.getUsername();
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello " + username + ".");
        System.out.println("To do an action, please press the corresponding number:");
        System.out.println("1 - Schedule an event (enter room into system)");
        System.out.println("2 - Create speaker account");
        System.out.println("3 - Cancel an event");
        System.out.println("4 - Send message");
        System.out.println("5 - Log out");

        String response = scan.nextLine();
        scan.close();

        switch (response) {
            case "1":
                // Schedule an event (enter room into system)
                System.out.println("Please enter the room number of your event: ");
                String roomNum = os.readString();
                System.out.println("Please enter the id of your event: ");
                String eventId = os.readString();
                System.out.println("Please enter the hour (military time) your event starts at: ");
                int time = os.readInt();

                System.out.println("Please enter the username of the Speaker of this event: ");
                String eventSpeaker = os.readString();

                boolean eventCreated = os.createEvent(roomNum, eventId, time, eventSpeaker);
                if (eventCreated){
                    System.out.println("Your Event was created successfully.");
                } else {
                    System.out.println("This Event can not be created.");
                }
                break;
            case "2":
                // Create speaker account
                System.out.println("Please username of the Speaker account: ");
                String speakerUsername = os.readString();
                System.out.println("Please enter the password of the Speaker account: ");
                String speakerPass = os.readString();

                boolean speakerCreated = os.createSpeaker(speakerUsername, speakerPass);
                if (speakerCreated) {
                    System.out.println("The Speaker account was created successfully.");
                } else {
                    System.out.println("This Speaker account can not be created.");
                }
                break;
            case "3":
                // Cancel an event
                System.out.println("Please enter the id of your event: ");
                String eventId2 = os.readString();

                boolean eventCancelled = os.cancelEvent(eventId2);
                if (eventCancelled){
                    System.out.println("The Event was cancelled successfully.");
                } else {
                    System.out.println("The Event could not be cancelled.");
                }
                break;
            case "4":
                // Send message
                om.run(); // Not sure if this is right

                break;
            case "5":
                // Log out
                lt.logOut();

                break;
        }
    }
}
