package NetflixProject.ProfileManagement;

import NetflixProject.CSVService.CSVUser;
import NetflixProject.Connections.DatabaseOperations.DatabaseOperator;
import NetflixProject.ProjectConstants;

import java.util.Collections;
import java.util.Scanner;

public class ProfileSearcher implements CSVUser, ProjectConstants {
    public Boolean profileAssigned = false;
    private Profile profile;
    Authenticator authenticator = new Authenticator();

    public ProfileSearcher(){}

    public ProfileSearcher(Profile profile){
        this.profile = profile;
    }



    private void findValidUser() {
        System.out.println("Please enter username");
        Scanner scnr = new Scanner(System.in);
        String inputName = scnr.nextLine();
        System.out.println("Please enter a password");
        String password = scnr.nextLine();
        profile.userName = inputName;
        if (authenticator.isNameTaken(profile) && authenticator.isPasswordCorrect(password,profile)){
            assignListsToProfile(profile);
            profileAssigned = true;
            System.out.println("Your Profile has been found!!\n");
        }
        else System.out.println("That profile name was not found\n");
    }

    public void makeNewProfile() {
        Scanner scnr = new Scanner(System.in);
        String userName = scnr.nextLine().toLowerCase();
        System.out.println("Please enter a password\n" + "min 7 characters");
        String password = scnr.nextLine();
        if (!authenticator.isNameTaken(profile) && authenticator.validUsername(userName)
                && authenticator.validPassword(password)) {
            System.out.println("");
            profile.userID = PROFILES.size() +1 ;
            profile.userName = userName;
            profile.password = password;
            DatabaseOperator.addProfileToUserTable(profile);
            assignListsToProfile(profile);
            System.out.println("Profile has been created");
            profileAssigned = true;
        }
        else {
            System.out.println("Please choose a different name\n");
        }
    }

    private void assignListsToProfile(Profile profile){
       profile.undecidedTitles = DatabaseOperator.getUserRecordList(profile.userID, "undecided");
       profile.likedTitles = DatabaseOperator.getUserRecordList(profile.userID, "liked");
       profile.dislikedTitles = DatabaseOperator.getUserRecordList(profile.userID, "disliked");
        Collections.shuffle(profile.undecidedTitles);
        Collections.shuffle(profile.dislikedTitles);
        Collections.shuffle(profile.likedTitles);
    }

    public void assignProfile() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Would you like to make a new Profile?");
        System.out.println("enter '1' for YES or '2' for NO");
        String newProfileChoice = scnr.nextLine();
        if (newProfileChoice.equals("1")) {
                System.out.println("Alright choose your Username");
                makeNewProfile();
            }
        if (newProfileChoice.equals("2")){
                findValidUser();
            }
        if (!newProfileChoice.equals("1") && !newProfileChoice.equals("2"))
            System.out.println("Please enter either '1' or '2'");
    }

    public Profile requestSecondProfile(){
        System.out.println("What is the name of the profile you wish to connect with?");
        Profile profile = new Profile();
        Scanner scnr = new Scanner(System.in);
        profile.userName = scnr.nextLine();
        if (authenticator.isNameTaken(profile)){
            assignListsToProfile(profile);
            System.out.println("Your Profile has been found!!\n");
            return profile;
        }
        else System.out.println("That profile name was not found\n");
        return null;
    }
}
