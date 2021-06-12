package NetflixProject;

import NetflixProject.ProfileManagement.Profile;

import java.util.List;

public interface ProjectConstants {
    Singleton SINGLETON = new Singleton();
    List<Profile> PROFILES = SINGLETON.profileList;
    List<Record> ORIGINALRECORDS = SINGLETON.originalRecordList;
}