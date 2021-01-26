import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

    class AppOperations {
        boolean usernameCreated = false;
        boolean insideMenu = false;
        Singleton singleton = Singleton.getInstance();
        List<Record> originalRecordList = singleton.readCSV("Netflix(Original!!).csv");
        Profile profile = singleton.profile;
        Scanner scnr = new Scanner(System.in);

        public AppOperations() throws IOException {
        }

        public boolean getUsernameCreated() throws IOException {


            System.out.println("Please enter your Username");

            String inputName = scnr.nextLine().toLowerCase();
            String undecidedListTag = inputName + "'s Undecided Titles.csv";
            String likedListTag = inputName + "'s Liked Titles.csv";
            String dislikedListTag = inputName + "'s Disliked Titles.csv";


            profile.setUserName(inputName.toLowerCase());


            System.out.println("Looking for existing profile...\n");

            try {
                boolean existingProfile = singleton.checkExistingProfile(inputName);

                if (!existingProfile) {
                    System.out.println("Profile not found...\n");
                    System.out.println("Would you like to make a new Profile?");
                    System.out.println("enter '1' for YES or '2' for NO\n");
                    int newProfileChoice = scnr.nextInt();

                    if (newProfileChoice == 1) {
                        profile.setUndecidedTitles(originalRecordList);
                        profile = singleton.addToProfileCSV();
                        Collections.shuffle(profile.undecidedTitles);
                        usernameCreated = true;
                    } else {
                        scnr.nextLine();
                        usernameCreated = false;
                    }
                }
                if (existingProfile) {
                    usernameCreated = true;
                }
            } catch (IOException ignored){
            }
            profile.setUndecidedTitles(singleton.readCSV(undecidedListTag));
            profile.setLikedTitles(singleton.readCSV(likedListTag));
            profile.setDislikedTitles(singleton.readCSV(dislikedListTag));

            for (int i = 0; i < profile.undecidedTitles.size();i++){
                System.out.println(profile.undecidedTitles.get(i).toCSVSingle(profile.undecidedTitles.get(i)));
            }

            return usernameCreated;
        }

    }
