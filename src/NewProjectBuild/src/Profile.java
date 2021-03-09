import java.util.ArrayList;
import java.util.List;

public class Profile extends Converter {
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
    String userID;
    int selectID;

    public Profile(String userName, String userID) {
        this.userName = userName;
        this.selectID = Integer.parseInt(userID);
    }

    public Profile(String userName){
        this.userName = userName;
    }

    public Profile createProfile(String userName, List<Profile> profileList){
        Profile profile = new Profile(userName.toLowerCase());
        profileList.add(profile);
        return profile;
    }



}
