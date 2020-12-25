import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Profile {
    String userName;
    List<Record> likedTitles;
    List<Record> dislikedTitles;
    List<Record> undecidedTitles;
    ArrayList genreInterests;
    String userID;
    int selectID;

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
        this.selectID = selectID;
    }



    public void makeNewProfile(List<Profile> profileList){// Method used to create new Profile for Singleton writeProfileCSV

        Scanner scnr = new Scanner(System.in);
        String userName = scnr.nextLine();
        selectID = profileList.size();
        String userID = Integer.toString(selectID);

        Profile newProfile = new Profile(userName, userID);
        profileList.add(newProfile);
    }

    public String toCSV(List<Profile> profileList, int i){
        String userName = profileList.get(i).userName;
        String userID = profileList.get(i).userID;

        String result = userName + "," + userID + "\n";
        return result;
    }

    public boolean checkExistingProfile(List<Profile> profileList){
        System.out.println("Please enter your UserName");
        boolean results = false;
        Scanner scnr = new Scanner(System.in);
        String inputName = scnr.nextLine();
        System.out.println("Looking for existing profile...");
        for (int i = 0;i < profileList.size();i++){
            if (profileList.get(i).userName.contains(inputName)) {
                results = true;
                System.out.println("Profile found!!");
                break;
            }
        }
        return results;
    }
}

