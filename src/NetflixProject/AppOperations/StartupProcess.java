package NetflixProject.AppOperations;

import NetflixProject.CSVService.CSVUser;
import NetflixProject.CSVService.FileFoundResponse;
import NetflixProject.ProfileManagement.ProfileSearcher;
import NetflixProject.ProjectConstants;
import NetflixProject.User;

public class StartupProcess implements ProjectConstants,CSVUser {
    private final User user = User.getInstance();
    private final ProfileSearcher ps = new ProfileSearcher(user.profile);

    private void checkForProfileList(){
        if (csvReader.checkForProfileList() == FileFoundResponse.FILENOTFOUND){
            System.out.println("Let's create a new list of profiles");
            csvWriter.profileListCreation();
        }
    }

    public void startApplication(){
        while(!ps.profileAssigned){
            checkForProfileList();
            ps.assignProfile();
        }
        System.out.println("Alright you are all setup");
    }


}
