import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        loadAndSave las = new loadAndSave();
        LoadAndSaveObjects laso = new LoadAndSaveObjects();
        SpeakerManager speakerManager = new SpeakerManager();
        AttendeeManager attendeeManager = new AttendeeManager();
        OrganizerManager organizerManager = new OrganizerManager();
        EventScheduler scheduler = new EventScheduler();

        /*
        * In case allObjects.txt becomes corrupted you can re-download the file OR
        * uncomment out las.loadall... and comment out laso.loadall... and run the
        * program and just press enter until the program finishes. This will remake
        * allObjects.txt
        *
        * Once this is done comment out las.loadall... again and uncomment laso.loadall...
        * The program should work fine now.
        * */
        //las.loadAll(scheduler, speakerManager, attendeeManager, organizerManager);
        laso.loadAll(scheduler, speakerManager, attendeeManager, organizerManager);

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.run(attendeeManager, organizerManager, speakerManager, scheduler);

        laso.saveAll(scheduler, speakerManager, attendeeManager, organizerManager);
    }
}
