import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Profile {
    String userName;
    ArrayList likedTitles;
    ArrayList dislikedTitles;
    ArrayList undecidedTitles;
    ArrayList genreInterests;
    String userID;

//    int pairCode;


    public Profile(String userName, String userID){
        this.dislikedTitles = dislikedTitles;
        this.undecidedTitles = undecidedTitles;
        this.likedTitles = likedTitles;
        this.userName = userName;
        this.genreInterests = genreInterests;
//        this.pairCode = pairCode;
        this.userID = userID;
    }
    public Profile(){
        this.dislikedTitles = dislikedTitles;
        this.undecidedTitles = undecidedTitles;
        this.likedTitles = likedTitles;
        this.userName = userName;
        this.genreInterests = genreInterests;
//        this.pairCode = pairCode;
        this.userID = userID;
    }



    public Profile makeNewProfile(List<Profile> profileList){

        Scanner scnr = new Scanner(System.in);
        String userName = scnr.nextLine();
        int selectID = profileList.size() + 1;
        String userID = Integer.toString(selectID);

        Profile newProfile = new Profile(userName, userID);
        return newProfile;
    }
}

