package NetflixProject;

import NetflixProject.CSVService.CSVUser;
import NetflixProject.Connections.DatabaseOperations.DatabaseOperator;
import NetflixProject.ProfileManagement.Profile;

import java.util.List;

public class User implements CSVUser {
    private static User single_instance = null;
    public Profile profile;
    List<Profile> profileList;
    List<Record> originalRecordListIDs;

    public User(){
        this.profileList = DatabaseOperator.getAllUsers();
        this.originalRecordListIDs = DatabaseOperator.getOriginalRecordList();
        this.profile = new Profile();
    }

    public static User getInstance() {
        if (single_instance == null)
            single_instance = new User();
        return single_instance;
    }
}
