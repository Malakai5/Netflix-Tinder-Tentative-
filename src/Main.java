import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Singleton singleton = Singleton.getInstance();
        List<Record> originalRecordList = singleton.originalRecordList;
        Profile profile = singleton.profile;
        boolean setupComplete = false;
        boolean usingApp = true;
        AppOperations newSetup = new AppOperations();





        while (usingApp){
        Scanner scnr = new Scanner(System.in);

            String undecidedListTag = profile.userName + "'s Undecided Titles.csv";
            String likedListTag = profile.userName + "'s Liked Titles.csv";
            String dislikedListTag = profile.userName + "'s Disliked Titles.csv";

            while (!setupComplete) {
            setupComplete = newSetup.getUsernameCreated();
        }
            for (int i = 0; i < profile.undecidedTitles.size();i++){
                System.out.println(profile.undecidedTitles.get(i).toCSVSingle(profile.undecidedTitles.get(i)));
            }



            boolean menuOptions = false;

            while (!menuOptions) {

                System.out.println("press '1' to 'Swipe' titles");
                System.out.println("press '2' to view titles you're interested in");
                System.out.println("Press '3' to pair likes Lists");
                System.out.println("Press '4' to exit out of the App\n");
                int menuChoice = scnr.nextInt();

                if (menuChoice == 1){
                    profile.setUndecidedTitles(profile.likeOrDislike(profile.undecidedTitles));
            }

            if (menuChoice == 2) {
                for (int i = 0; i < profile.likedTitles.size(); i++) {
                    System.out.println(profile.likedTitles.get(i).toCSVSingle(profile.likedTitles.get(i)));
                }
                System.out.println("Press '1' to search a title by name");
                System.out.println("press '2' to go to the previous menu\n");

                int likedMenuChoices = scnr.nextInt();
                scnr.nextLine();
                if (likedMenuChoices == 1) {
                    System.out.println("What is the name of the title?");
                    String searchName = scnr.nextLine().toLowerCase();

                    for (int i = 0; i < profile.likedTitles.size(); i++) {
                        if (profile.likedTitles.get(i).titleName.contains(searchName)) {
                            System.out.println(profile.likedTitles.get(i).toCSVSingle(profile.likedTitles.get(i)));
                        }
                    }
                }
            }

            if (menuChoice == 3){
                boolean userNameFound = false;
                while (!userNameFound){
                    System.out.println("Please enter your Username");
                    scnr.nextLine();
                    String inputName = scnr.nextLine().toLowerCase();
                    System.out.println("Looking for existing profile...\n");
                    System.out.println(inputName);
                    String otherLikedList = inputName + "'s Liked Titles.csv";

                    boolean existingProfile = singleton.checkExistingProfile(inputName);
                    if (!existingProfile){
                        System.out.println("Please enter a valid Username\n");
                    }
                    if (existingProfile){
                        List<Record> secondLikedList = singleton.readCSV(otherLikedList);

                        profile.getSharedList(profile.likedTitles,secondLikedList);
                        userNameFound = true;
                    }
                }
            }

            if (menuChoice == 4) {
                menuOptions = true;
//                singleton.writeCSV(undecidedListTag, profile.undecidedTitles);
//                singleton.writeCSV(likedListTag, profile.likedTitles);
//                singleton.writeCSV(dislikedListTag, profile.dislikedTitles);

                usingApp = false;
                System.out.println("Goodbye");
            }
        }
        }
    }
}