package NetflixProject;

import NetflixProject.AppOperations.StartupProcess;
import NetflixProject.ProfileManagement.ProfileSearcher;

public class Runner {
    public static void main(String[] args) {
//        User user = User.getInstance();
        StartupProcess sp = new StartupProcess();
        sp.startApplication();
//        RecordListManipulator rlm = new RecordListManipulator(profile);
//        rlm.sortingTitles();
//        sp.checkForProfileList();
    }
}
