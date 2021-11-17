package NetflixProject.ProfileManagement;

import NetflixProject.Record;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public void getPreferredGenres(){
        System.out.println("What are you favorite genres? (Enter a genre and then add a space in between)");
        Scanner scan = new Scanner(System.in);
        String rawGenreList = scan.nextLine();
        preferredGenres = Arrays.asList(rawGenreList.split(" "));
    }
}