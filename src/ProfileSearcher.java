import java.util.Collections;
import java.util.Scanner;

public class ProfileSearcher implements CSVUser, ProjectConstants {
    Boolean profileAssigned = false;

    private boolean checkExistingProfile(String inputName) {
        boolean results = false;
        if (inputName.isEmpty()){
            return false;
        }
        for (Profile value : PROFILES) {
            if (value.userName.contains(inputName)) {
                results = true;
                break;
            }
        }
        return results;
    }

    private void findValidUser(Profile profile) {
        System.out.println("Please enter username");
        Scanner scnr = new Scanner(System.in);
        String inputName = scnr.nextLine();
        if (!checkExistingProfile(inputName)) {
            System.out.println("profile not found...");
        } else {
            profile.userName = inputName;
            System.out.println("Profile found!!");
            assignListsToProfile(profile);
            profileAssigned = true;
        }
    }

        private void makeNewProfile(Profile profile) {
            Scanner scnr = new Scanner(System.in);
            String userName = scnr.nextLine();
            if (!checkExistingProfile(userName) && !userName.isEmpty()){
                int selectID = PROFILES.size();
                String userID = Integer.toString(selectID);
                Profile newProfile = new Profile(userName, userID);
                PROFILES.add(newProfile);
                csvWriter.writeProfileCSV(newProfile,PROFILES);
                profile.userName = userName;
                makeEmptyCSVs(profile);
            }
            else
                System.out.println("Please pick a different Username");

        }

        private void makeEmptyCSVs(Profile profile) {
            String undecidedList = profile.userName + "'s Undecided Titles.csv";
            String likedList = profile.userName + "'s Liked Titles.csv";
            String dislikedList = profile.userName + "'s Disliked Titles.csv";
            csvWriter.headerWriter(likedList);
            csvWriter.headerWriter(dislikedList);
            Collections.shuffle(ORIGINALRECORDS);

            csvWriter.writeCSV(undecidedList, ORIGINALRECORDS);
            assignListsToProfile(profile);
        }

        private void assignListsToProfile(Profile profile){
            String undecidedList = profile.userName + "'s Undecided Titles.csv";
            String likedList = profile.userName + "'s Liked Titles.csv";
            String dislikedList = profile.userName + "'s Disliked Titles.csv";
            profile.undecidedTitles = csvReader.readCSV(undecidedList);
            profile.likedTitles = csvReader.readCSV(likedList);
            profile.dislikedTitles = csvReader.readCSV(dislikedList);

        }


    public void assignProfile(Profile profile) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Would you like to make a new Profile?");
        System.out.println("enter '1' for YES or '2' for NO");
        int newProfileChoice = scnr.nextInt();
        if (newProfileChoice == 1 || newProfileChoice == 2) {
            if (newProfileChoice == 1) {
                System.out.println("Alright choose your Username");
                makeNewProfile(profile);
            }
            else findValidUser(profile);

        }
        else System.out.println("Please enter either '1' or '2'");


    }
}

