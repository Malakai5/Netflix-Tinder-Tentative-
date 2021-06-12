package NetflixProject.ProfileManagement;
import NetflixProject.CSVService.CSVUser;
import NetflixProject.CSVService.FileFoundResponse;
import NetflixProject.ProjectConstants;

import java.util.Collections;
import java.util.Scanner;

public class ProfileSearcher implements CSVUser, ProjectConstants {
    public Boolean profileAssigned = false;
    private Profile profile;

    public ProfileSearcher(Profile profile){
        this.profile = profile;
    }


    public static boolean isAlphaNumeric(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }

    private boolean validUsername(String inputName){
        return !inputName.isEmpty() && isAlphaNumeric(inputName);
    }

    private boolean checkNameAvailability(String inputName) {
        boolean nameTaken = false;
        if (validUsername(inputName))
        for (Profile value : PROFILES) {
            if (value.userName.contains(inputName.toLowerCase())) {
                nameTaken = true;
                break;
            }
        }   else System.out.println("That profile name was not available");
        return nameTaken;
    }

    private void findValidUser() {
        System.out.println("Please enter username");
        Scanner scnr = new Scanner(System.in);
        String inputName = scnr.nextLine();
        if (checkNameAvailability(inputName)){
            profile.userName = inputName;
            assignListsToProfile();
            profileAssigned = true;
            System.out.println("Your Profile has been found!!\n");
        }
        else System.out.println("That profile name was not found\n");
    }

    private void makeNewProfile() {
        Scanner scnr = new Scanner(System.in);
        String userName = scnr.nextLine();
        if (!checkNameAvailability(userName) && !userName.isEmpty()) {
            if (validUsername(userName)) {
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
                System.out.println("Username can only contain alphanumeric characters");
                System.out.println("Please try again");
            }
        } else System.out.println("Please choose a different name\n");
    }

    private void makeEmptyCSVs() {
        String undecidedList = profile.userName + "'s Undecided Titles.csv";
        String likedList = profile.userName + "'s Liked Titles.csv";
        String dislikedList = profile.userName + "'s Disliked Titles.csv";
        csvWriter.headerWriter(likedList);
        csvWriter.headerWriter(dislikedList);
        Collections.shuffle(ORIGINALRECORDS);

        csvWriter.writeCSV(undecidedList, ORIGINALRECORDS);
        assignListsToProfile();
    }

    private void assignListsToProfile(){
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
        if (newProfileChoice.equals("1") || newProfileChoice.equals("2")) {
            if (newProfileChoice.equals("1")) {
                System.out.println("Alright choose your Username");
                makeNewProfile();
            } else {
                findValidUser();
            }
        }
        else System.out.println("Please enter either '1' or '2'");
    }
}
