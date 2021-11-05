package NetflixProject.AppOperations;

import NetflixProject.ProfileManagement.ProfileSearcher;
import NetflixProject.ProjectConstants;
import NetflixProject.User;

public class StartupProcess implements ProjectConstants {
    private final User user = User.getInstance();
    private final ProfileSearcher ps = new ProfileSearcher(user.profile);

    public void startApplication(){
        while(!ps.profileAssigned){
            ps.assignProfile();
        }
        System.out.println("Alright you are all setup\n");
    }
}
