import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Display the setup options to the user
    public void DisplaySetupOptions()
    {
        //TODO::Display options
    }

    public static void main(String[] args) throws IOException {

        Singleton singleton = Singleton.getInstance();
        List<Record> originalRecordList = singleton.originalRecordList;
        Profile profile = singleton.profile;

//        for (int i = 0; i < recordList.size();i++){
//            System.out.println(tempRecord.toCSV(recordList,i));
//        }

//        for (int i = 0;i < profileList.size();i++){
//            System.out.print(tempProfile.toCSV(profileList,i));
//        }

//        System.out.println(tempProfile.checkExistingProfile(profileList));


//        System.out.println(profile.userName);

//        for (int i = 0; i < profile.dislikedTitles.size();i++){
//            System.out.println(profile.dislikedTitles.get(i).toCSVSingle(profile.dislikedTitles.get(i)));
//        }
//
//        for (int i = 0; i < profile.likedTitles.size();i++){
//            System.out.println(profile.likedTitles.get(i).toCSVSingle(profile.likedTitles.get(i)));
//        }

        //Have Singleton load all available profile data

        // Setup/Login Loop
        // Options
        // 1. Login
        // 2. New User
        // 3. Quit App
        boolean setupComplete = false;
        //while(!setupComplete)
        //{
        // TODO:
        // A. Display Options 1-3
        //    DisplaySetupOptions();
        // B. Get a selection from user
        //    Read System In
        // C. Handle operation given by user
        //    Handle Operation as an integer
        //    When option 1 or 2 is handled with success, setupComplete must be set to true so we
        //    stop looping.
        //    1. Login - Use singleton to attempt to find profile with that username.
        //               If profile not found, inform user and continue loop so another option is requested.
        //               If profile found, have a member variable in singleton called currentUser which is
        //               a Profile object and set it to that profile, this is our success case.
        //    2. New User - Use singleton to verify this username is not already taken.
        //                  If username taken, inform user and continue loop so another option is requested.
        //                  If username is available, have singleton make that profile, this is our success case.
        //                  currentUser in singleton is set to this new profile.
        //    3. quit - Have your program quit
        //              System.exit(0);
        //}

        // Main Loop, we only get here is initial setup is complete
        // Options
        // 1. Display Liked List
        // 2. Swipe through titles
        // 3. Quit App
        boolean usingApp = true;
        //while(usingApp)
        //{
        // Display Options 1-3
        // Get a selection from user
        // Handle operation given by user
        //}
        Scanner scnr = new Scanner(System.in);

        while (!setupComplete) {

            System.out.println("Please enter your Username");

            String inputName = scnr.nextLine().toLowerCase();

            String undecidedListTag = inputName + "'s Undecided Titles.csv";
            String likedListTag = inputName + "'s LikedListTag Titles.csv";
            String dislikedListTag = inputName + "'s DislikedListTag Titles.csv";

            profile.setUserName(inputName.toLowerCase());


            System.out.println("Looking for existing profile...\n");

            boolean existingProfile = singleton.checkExistingProfile(inputName);
            if (!existingProfile) {
                System.out.println("Profile not found...\n");
                System.out.println("Would you like to make a new Profile?");
                System.out.println("enter '1' for YES or '2' for NO\n");
                int newProfileChoice = scnr.nextInt();

                if (newProfileChoice == 1) {
                    profile = singleton.addToProfileCSV();
                    profile.setUndecidedTitles(originalRecordList);
                    setupComplete = true;
                }
                else{
                    scnr.nextLine();
                    setupComplete = false;
                }
            }
            if (existingProfile) {
                profile.setUndecidedTitles(singleton.readCSV(undecidedListTag));
                setupComplete = true;
            }
            profile.setLikedTitles(singleton.readCSV(likedListTag));
            profile.setDislikedTitles(singleton.readCSV(dislikedListTag));
        }


        profile.setUndecidedTitles(profile.likeOrDislike(profile.undecidedTitles));

        boolean menuOptions = false;

        while (!menuOptions) {

            System.out.println("press '1' to view titles you're interested in");
            System.out.println("Press '2' to exit out of the App\n");

            int menuChoice = scnr.nextInt();

            if (menuChoice == 1) {
                for (int i = 0; i < profile.likedTitles.size(); i++) {
                    System.out.println(profile.likedTitles.get(i).toCSVSingle(profile.likedTitles.get(i)));
                }
                System.out.println("Press '1' to search a title by name");
                System.out.println("press '2' to go to the previous menu\n");

                int likedMenuChoices = scnr.nextInt();
                scnr.nextLine();
                if (likedMenuChoices == 1) {
                    String searchName = scnr.nextLine().toLowerCase();

                    for (int i = 0; i < profile.likedTitles.size(); i++) {
                        if (profile.likedTitles.get(i).titleName.contains(searchName)) {
                            System.out.println(profile.likedTitles.get(i).toCSVSingle(profile.likedTitles.get(i)));
                        }
                    }
                }
            }
                if (menuChoice == 2){
                    menuOptions = true;
                    System.out.println("Goodbye");
            }
        }
    }
}

