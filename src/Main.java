import java.util.List;

public class Main{

    public static void main(String[] args) {

    ProfileSearcher ps = new ProfileSearcher();
    Profile profile = new Profile();


    ps.assignProfile(profile);

        System.out.println(profile.userName);

















//        Singleton singleton = Singleton.getInstance();
//        Profile profile = singleton.profile;
//        boolean setupComplete = false;
//        boolean usingApp = true;
//        AppOperations appOperations = new AppOperations();
//
//        while (usingApp) {
//            while (!setupComplete) {
//                setupComplete = appOperations.getUsernameCreated();
//            }
//
//
//            boolean menuOptions = false;
//
//            while (!menuOptions) {
//                int menuChoice = appOperations.menuOptions();
//                if (menuChoice == 1) {
//                    profile.setUndecidedTitles(profile.likeOrDislike(profile.undecidedTitles));
//                }
//
//                if (menuChoice == 2) {
//                    appOperations.showLikedLists();
//                }
//
//                if (menuChoice == 3) {
//                    appOperations.getSharedLists();
//                }
//
//                if (menuChoice == 4) {
//                    menuOptions = true;
//                    appOperations.closingApp();
//                    usingApp = false;
//                    System.out.println("Goodbye");
//                }
//            }
//        }

    }
}