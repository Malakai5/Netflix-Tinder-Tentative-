package NetflixProject;

import NetflixProject.ProfileManagement.Profile;
import NetflixProject.ProfileManagement.ProfileSearcher;

public class Runner {
    public static void main(String[] args) {
        ProfileSearcher ps = new ProfileSearcher();
        Profile profile = new Profile();

        ps.assignProfile(profile);
//        RecordListManipulator rlm = new RecordListManipulator(profile);
//        rlm.sortingTitles();
    }
}
