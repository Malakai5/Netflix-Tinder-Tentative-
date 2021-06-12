package NetflixProject.AppOperations;

import NetflixProject.ProfileManagement.ProfileSearcher;
import NetflixProject.ProjectConstants;
import NetflixProject.User;

public class StartupProcess implements ProjectConstants {
    User user = User.getInstance();
    ProfileSearcher ps = new ProfileSearcher(user.profile);

    public void startApplication(){
        while(!ps.profileAssigned){
            ps.assignProfile();
        }
        System.out.println("Alright you are all setup");
    }


    //TODO add in a way to make sure that profileList while always be Populated
}
