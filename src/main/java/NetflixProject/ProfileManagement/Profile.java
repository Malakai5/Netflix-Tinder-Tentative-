package NetflixProject.ProfileManagement;

import NetflixProject.Record;
import java.util.ArrayList;
import java.util.List;

public class Profile {
   public String userName;
   public String password;
   public List<Record> likedTitles = new ArrayList<>();
   public List<Record> dislikedTitles = new ArrayList<>();
   public List<Record> undecidedTitles = new ArrayList<>();
   public String country = "";
   public List<String> preferredGenres = new ArrayList<>();
   public int userID;

    public Profile(String userName, int userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public Profile() {
    }

    public String toCSV(List<Profile> profileList, int i) {
        String userName = profileList.get(i).userName;
        int userID = profileList.get(i).userID;

        return userName + "," + userID + "\n";
    }

    public String toCSVSingle(){
        return userName + "," + userID + "\n";
    }
}