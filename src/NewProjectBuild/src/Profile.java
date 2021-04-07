import java.util.ArrayList;
import java.util.List;

public class Profile extends ProfileManipulator {
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public List<Record> getLikedTitles() {
        return likedTitles;
    }
    public void setLikedTitles(List<Record> likedTitles) {
        this.likedTitles = likedTitles;
    }
    public List<Record> getDislikedTitles() {
        return dislikedTitles;
    }
    public void setDislikedTitles(List<Record> dislikedTitles) {
        this.dislikedTitles = dislikedTitles;
    }
    public List<Record> getUndecidedTitles() {
        return undecidedTitles;
    }
    public void setUndecidedTitles(List<Record> undecidedTitles) {
        this.undecidedTitles = undecidedTitles;
    }

    List<Record> likedTitles = new ArrayList<>();
    List<Record> dislikedTitles = new ArrayList<>();
    List<Record> undecidedTitles = new ArrayList<>();
    int userID;
    public Profile(String userName, int userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public Profile(String userName){
        this.userName = userName;
    }

    public Profile(String userName, String UserID) {
    }

    public Profile createProfile(String userName, List<Profile> profileList){
        Profile profile = new Profile(userName.toLowerCase(),profileList.size() + 1);
        assignCSVs(profile);
        profileList.add(profile);
        writeProfileToCSV(profileList);
        return profile;
    }



}
