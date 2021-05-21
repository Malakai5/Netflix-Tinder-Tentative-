import java.util.List;

public class Main implements ProjectConstants{

    public static void main(String[] args) {

        List<Profile> profileList = SINGLETON.profileList;
        Profile profile = SINGLETON.profile;
        List<Record> originalRecordList = SINGLETON.originalRecordList;

        originalRecordList.forEach(record -> System.out.println(record.toCSVSingle(record)));













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