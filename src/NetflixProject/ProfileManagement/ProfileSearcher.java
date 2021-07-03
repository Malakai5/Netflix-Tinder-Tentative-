package NetflixProject.ProfileManagement;
import NetflixProject.CSVService.CSVUser;
import NetflixProject.CSVService.FileFoundResponse;
import NetflixProject.ProjectConstants;

import java.util.Collections;
import java.util.Scanner;

public class ProfileSearcher implements CSVUser, ProjectConstants {
    public Boolean profileAssigned = false;
    private Profile profile;

    public ProfileSearcher(){}

    public ProfileSearcher(Profile profile){
        this.profile = profile;
    }

    public static boolean isAlphaNumeric(String s) {
        if (s != null && !s.matches("^[a-zA-Z0-9]*$")){
            System.out.println("Username can only contain alphanumeric characters");
            return false;
        }
        return true;
    }

    private boolean validUsername(String inputName){
        if (inputName.isEmpty() || !isAlphaNumeric(inputName)){
            System.out.println("That profile name can not be used\n");
            return false;
        }
        return true;
    }

    private boolean nameIsBeingUsed(String inputName) {
        if (!validUsername(inputName)) {
            return false;
        }
        for (Profile profile: PROFILES){
         if (profile.userName.equals(inputName.toLowerCase())) {
             return true;
         }
        }
        return false;
    }

    private void findValidUser() {
        System.out.println("Please enter username");
        Scanner scnr = new Scanner(System.in);
        String inputName = scnr.nextLine();
        if (nameIsBeingUsed(inputName)){
            profile.userName = inputName;
            assignListsToProfile(profile);
            profileAssigned = true;
            System.out.println("Your Profile has been found!!\n");
        }
        else System.out.println("That profile name was not found\n");
    }

    private void makeNewProfile() {
        Scanner scnr = new Scanner(System.in);
        String userName = scnr.nextLine().toLowerCase();
        if (!nameIsBeingUsed(userName) && validUsername(userName)) {
                int selectID = PROFILES.size();
                String userID = Integer.toString(selectID);
                Profile newProfile = new Profile(userName, userID);
                PROFILES.add(newProfile);
                csvWriter.writeProfileCSV(newProfile, PROFILES);
                profile.userName = userName;
                makeEmptyCSVs();
                System.out.println("Profile has been created");
                profileAssigned = true;
        }
        else {
            System.out.println("Please choose a different name\n");
        }
    }

    private void makeEmptyCSVs() {
        String undecidedList = profile.userName + "'s Undecided Titles.csv";
        String likedList = profile.userName + "'s Liked Titles.csv";
        String dislikedList = profile.userName + "'s Disliked Titles.csv";
        csvWriter.recordListCSVCreation(likedList);
        csvWriter.recordListCSVCreation(dislikedList);
        Collections.shuffle(ORIGINALRECORDS);

        csvWriter.writeCSV(undecidedList, ORIGINALRECORDS);
        assignListsToProfile(profile);
    }

    private void assignListsToProfile(Profile profile){
        String undecidedList = profile.userName + "'s Undecided Titles.csv";
        String likedList = profile.userName + "'s Liked Titles.csv";
        String dislikedList = profile.userName + "'s Disliked Titles.csv";
        if (csvReader.checkForFile(undecidedList) == FileFoundResponse.FILEFOUND) {
            profile.undecidedTitles = csvReader.readCSV(undecidedList);
        }
        if (csvReader.checkForFile(likedList) == FileFoundResponse.FILEFOUND)
            profile.likedTitles = csvReader.readCSV(likedList);
        if (csvReader.checkForFile(undecidedList) == FileFoundResponse.FILEFOUND)
            profile.dislikedTitles = csvReader.readCSV(dislikedList);
        else System.out.println("\nfiles weren't found please try again");
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

    public Profile getSecondProfile(){
        System.out.println("What is the name of the profile you wish to connect with?");
        Profile profile = new Profile();
        Scanner scnr = new Scanner(System.in);
        String userName = scnr.nextLine();
        if (nameIsBeingUsed(userName)){
            profile.userName = userName;
            assignListsToProfile(profile);
            System.out.println("Your Profile has been found!!\n");
        }
        else System.out.println("That profile name was not found\n");
        return profile;
    }
}
