package NetflixProject;

import NetflixProject.CSVService.CSVUser;
import NetflixProject.ProfileManagement.Profile;

import java.util.List;

public class User implements CSVUser {
    private static User single_instance = null;
    public Profile profile;
    List<Profile> profileList;
    List<Record> originalRecordList;

    public User(){
        this.profileList = csvReader.readProfileCSV();
        this.originalRecordList = csvReader.readCSV("Netflix(Original!!).csv");
        this.profile = new Profile();
    }

    public static User getInstance() {
        if (single_instance == null)
            single_instance = new User();
        return single_instance;
    }
}
