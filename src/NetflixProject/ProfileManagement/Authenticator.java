package NetflixProject.ProfileManagement;

import NetflixProject.ProfileManagement.Profile;
import NetflixProject.ProjectConstants;

public class Authenticator implements ProjectConstants {

    public boolean isAlphaNumeric(String s) {
        if (s != null && !s.matches("^[a-zA-Z0-9]*$")){
            System.out.println("Username can only contain alphanumeric characters");
            return false;
        }
        return true;
    }

    public boolean validUsername(String inputName){
        if (inputName.isEmpty() || !isAlphaNumeric(inputName)){
            System.out.println("That profile name can not be used\n");
            return false;
        }
        return true;
    }

    public boolean validPassword(String password){
        if (password.length() >= 7){
            System.out.println("That password works!!");
            return true;
        }
        System.out.println("password too short");
        return false;
    }

    public boolean isNameTaken(Profile profile) {
        if (!validUsername(profile.userName)) {
            return false;
        }
        for (Profile thatProfile: PROFILES){
            if (thatProfile.userName.equals(profile.userName.toLowerCase())) {
                profile.userID = thatProfile.userID;
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordCorrect(String password, Profile profile){
        if (!validPassword(password))
            return false;
        Profile temp = new Profile();
        for (Profile thatProfile: PROFILES){
            if (thatProfile.userName.equals(profile.userName.toLowerCase())) {
                profile.password = thatProfile.password;
                profile.userID = thatProfile.userID;
            }
        }
        return profile.password.equals(password);
    }
}
