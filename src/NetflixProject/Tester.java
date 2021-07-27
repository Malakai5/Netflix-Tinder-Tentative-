package NetflixProject;

import NetflixProject.ConnectionDrivers.DatabaseOperations;
import NetflixProject.ProfileManagement.Profile;


public class Tester {
    public static void main(String[] args) {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        Profile profile = new Profile();
        profile.userName = "Scooby";
        profile.password = "Coward";
//        RecordListManipulator rlm = new RecordListManipulator(profile);
//        rlm.showRecordList(databaseOperations.getOriginalRecordList());
//        databaseOperations.test();
        databaseOperations.addProfileToProfileListTable(profile);
        databaseOperations.addProfileToUserTable(profile);
    }
}
