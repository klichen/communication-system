public class AttendeeMainScreen {
    AttendeeSystem as;
    String username;
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;

    /**
     * Constructor for the presenter showing all of the Actions Entities.Attendee can do
     * @param username The username of the Entities.Attendee as a String
     * @param am Instance of UseCases.AttendeeManager with loaded information
     * @param es Instance of UseCases.EventScheduler with loaded information
     * @param om Instance of UseCases.OrganizerManager with loaded information
     * @param sm Instance of UseCases.SpeakerManager with loaded information
     */
    public AttendeeMainScreen(String username, AttendeeManager am, EventScheduler es, OrganizerManager om,
                              SpeakerManager sm){
        this.as = new AttendeeSystem(am, es, om, sm);
        this.username = username;
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
    }

    /**
     * Prints the texts for the Entities.Attendee to see, and takes in inputs accordingly.
     */
    public void run(){
        boolean logOut = false;
        while (!logOut) {

            System.out.println("Hello " + username + ".");
            System.out.println("To do an action, please press the corresponding number:");
            System.out.println("1 - View your Schedule");
            System.out.println("2 - Register for an event");
            System.out.println("3 - Cancel your registration in an event");
            System.out.println("4 - Add a contact to your contact list");
            System.out.println("5 - Send a message to a contact");
            System.out.println("6 - View previous messages");
            System.out.println("7 - Log out");

            String response = as.readString();

            // returns schedule of user
            switch (response) {
                case "1":
                    System.out.println(this.as.getScheduleIds(username));

                    break;
                // if applicable adds an event to the users schedule, otherwise tells them they cannot
                case "2": {
                    System.out.println("Please enter the id of the event you would like to register for: ");
                    String eventID = this.as.readString();

                    // adds the event
                    if (this.as.canAddEvent(username, eventID)) {
                        this.as.addEvent(username, eventID);
                        System.out.println("You have successfully registered for event " + eventID);
                    }
                    // tells them event cannot be added
                    else {
                        System.out.println("Sorry this action cannot be done.");
                    }

                    break;
                }
                // if applicable removes an event from the users schedule, otherwise tells them they cannot
                case "3": {
                    System.out.println("Please enter the id of the event you would like to unregister for: ");
                    String eventID = this.as.readString();

                    // cancels the event
                    if (this.as.canCancelEnrollment(username, eventID)) {
                        this.as.cancelEnrollment(username, eventID);
                        System.out.println("You have successfully cancelled your enrollment in event " + eventID);
                    }
                    // tells them event cannot be cancelled
                    else {
                        System.out.println("Sorry this action cannot be done.");
                    }

                    break;
                }
                // adds a contact to contact list
                case "4": {
                    System.out.println("Please enter the username of the contact you would like to add: ");
                    String contactID = this.as.readString();

                    // adds contact
                    if (this.as.canAddContact(username, contactID)) {
                        this.as.addContact(username, contactID);
                        System.out.println("You have successfully added a contact to your contact list.");
                    }
                    // tells them contact cannot be added
                    else {
                        System.out.println("Sorry this action cannot be done.");
                    }

                    break;
                }
                // Sends a message to a contact
                case "5": {
                    AttendeeMessageScreen messageScreen = new AttendeeMessageScreen(am, om, sm, username);
                    messageScreen.run();

                    break;
                }
                // View previous messages
                case "6": {
                    ReadMessageScreen messageScreen = new ReadMessageScreen(am, om, sm, username);
                    messageScreen.run();

                    break;
                }
                // Log off
                case "7": {
                    logOut = true;
                    //pass screen back to login screen
                    break;
                }

            }

        }

    }
}
