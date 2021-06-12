package NetflixProject;

import NetflixProject.CSVService.CSVUser;
import NetflixProject.ProfileManagement.Profile;

import java.util.List;

public class User implements CSVUser { // Used to read CSV file on initiation and never need to read it again.
    private static User single_instance = null;
    List<Profile> profileList;
    List<Record> originalRecordList;
   public Profile profile;


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
