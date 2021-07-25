package NetflixProject.ProfileManagement;

import NetflixProject.Record;
import java.util.ArrayList;
import java.util.List;

public class Profile {
   public String userName;
   public List<Record> likedTitles = new ArrayList<>();
   public List<Record> dislikedTitles = new ArrayList<>();
   public List<Record> undecidedTitles = new ArrayList<>();
   public String userID;
    int selectID;

    public Profile(String userName, String userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public Profile() {
    }

    public String toCSV(List<Profile> profileList, int i) {
        String userName = profileList.get(i).userName;
        String userID = profileList.get(i).userID;

        return userName + "," + userID + "\n";
    }

    public String toCSVSingle(Profile profile) {
        String userName = profile.userName;
        String userID = profile.userID;
        Profile pro = new Profile();

        return userName + "," + userID + "\n";

    }
}