import java.io.IOException;
import java.util.ArrayList;
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
        List <Record> recordList = singleton.recordList;
        Profile profile = new Profile();
        List<Record> likedTitles = new ArrayList<>();
        List<Record> dislikedTitles =new ArrayList<>();


//        for (int i = 0; i < recordList.size();i++){
//            System.out.println(tempRecord.toCSV(recordList,i));
//        }

//        for (int i = 0;i < profileList.size();i++){
//            System.out.print(tempProfile.toCSV(profileList,i));
//        }

//        System.out.println(tempProfile.checkExistingProfile(profileList));


//        System.out.println(profile.userName);


        System.out.println("Please enter your Username");

        Scanner scnr = new Scanner(System.in);
        String inputName = scnr.nextLine();
        String fileName = inputName + "'s Undecided Titles.csv";

        profile.setUserName(inputName);

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

        System.out.println("Looking for existing profile...");

        boolean existingProfile = singleton.checkExistingProfile(inputName);

        if (!existingProfile) {
            profile = singleton.addToProfileCSV();

        } else {
            singleton.writeCSV(fileName,recordList);

        }
        profile.setUndecidedTitles(recordList);

        profile.setUndecidedTitles(profile.likeOrDislike(profile.undecidedTitles));

    }
}

