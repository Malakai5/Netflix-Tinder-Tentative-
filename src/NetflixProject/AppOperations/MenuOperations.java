package NetflixProject.AppOperations;

import NetflixProject.ProfileManagement.Profile;
import NetflixProject.Record;
import NetflixProject.RecordListManipulator;
import NetflixProject.User;
import java.util.List;
import java.util.Scanner;

public class MenuOperations implements AppOperations{
    private static MenuOperations single_instance;
    Scanner scnr = new Scanner(System.in);
    StartupProcess startupProcess = new StartupProcess();
    User user = User.getInstance();
    RecordListManipulator recordListManipulator = new RecordListManipulator(user.profile);

    public String menuOptions() {
        System.out.println("press '1' to 'Swipe' titles");
        System.out.println("press '2' to view titles you're interested in");
        System.out.println("Press '3' to pair likes Lists");
        System.out.println("Press '4' to exit out of the App\n");

        return scnr.next();
    }


    @Override
    public void startOperations() {
        startupProcess.startApplication();
    }

    @Override
    public void swipeThroughTitles() {
        recordListManipulator.sortingTitles();
    }

    @Override
    public List<Record> compareLikedLists() {
        return recordListManipulator.compareLikedLists();
    }

    @Override
    public void showRecordList(List<Record> recordList) {
        recordListManipulator.showRecordList(recordList);
    }

    public static MenuOperations getInstance() {
        if (single_instance == null)
            single_instance = new MenuOperations();
        return single_instance;
    }
}
