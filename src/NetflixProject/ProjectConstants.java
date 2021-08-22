package NetflixProject;

import NetflixProject.ProfileManagement.Profile;
import java.util.List;

public interface ProjectConstants {
    User USER = new User();
    List<Profile> PROFILES = USER.profileList;
    List<Record> ORIGINALRECORDSIDS = USER.originalRecordListIDs;
}