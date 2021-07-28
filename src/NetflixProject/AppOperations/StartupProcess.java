package NetflixProject.AppOperations;

import NetflixProject.CSVService.CSVUser;
import NetflixProject.CSVService.FileFoundResponse;
import NetflixProject.ProfileManagement.ProfileSearcher;
import NetflixProject.ProjectConstants;
import NetflixProject.User;

public class StartupProcess implements ProjectConstants,CSVUser {
    private final User user = User.getInstance();
    private final ProfileSearcher ps = new ProfileSearcher(user.profile);

    public void startApplication(){
        while(!ps.profileAssigned){
            ps.assignProfile();
        }
        System.out.println("Alright you are all setup\n");
    }
}
