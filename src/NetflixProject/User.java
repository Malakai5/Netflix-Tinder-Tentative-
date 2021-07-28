package NetflixProject;

import NetflixProject.CSVService.CSVUser;
import NetflixProject.Connections.DatabaseOperations.DatabaseOperator;
import NetflixProject.ProfileManagement.Profile;

import java.util.List;

public class User implements CSVUser {
    private static User single_instance = null;
    public Profile profile;
    List<Profile> profileList;
    List<Integer> originalRecordListIDs;

    public User(){
        this.profileList = DatabaseOperator.getAllUsers();
//        this.profileList = csvReader.readProfileCSV(); OLD METHOD
        this.originalRecordListIDs = DatabaseOperator.getOriginalRecordListIDs();
//        this.originalRecordList = csvReader.readCSV("Netflix(Original!!).csv"); OLD METHOD
        this.profile = new Profile();
    }

    public static User getInstance() {
        if (single_instance == null)
            single_instance = new User();
        return single_instance;
    }
}
