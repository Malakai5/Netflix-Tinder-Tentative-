package NetflixProject;

import NetflixProject.ConnectionDrivers.DatabaseSearcher;
import NetflixProject.ProfileManagement.Profile;


public class Tester {
    public static void main(String[] args) {
        DatabaseSearcher databaseSearcher = new DatabaseSearcher();
        Profile profile = new Profile();
        RecordListManipulator rlm = new RecordListManipulator(profile);
        rlm.showRecordList(databaseSearcher.getOriginalRecordList());
        databaseSearcher.test();
    }
}
