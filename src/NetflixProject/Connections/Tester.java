package NetflixProject.Connections;

import NetflixProject.Connections.DatabaseOperations.DatabaseOperator;
import NetflixProject.Connections.DatabaseOperations.DatabaseUpdater;
import NetflixProject.ProfileManagement.Profile;
import NetflixProject.ProfileManagement.ProfileSearcher;
import NetflixProject.ProjectConstants;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;


public class Tester {
    public static void main(String[] args) {
        Profile profile = new Profile();
//        DatabaseUpdater databaseUpdater = new DatabaseUpdater(new NamedParameterJdbcTemplate(Driver.getDataSource()));
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        profile.userID = 1;
        profile.userName = "Scooby";
        profile.password = "Coward!";
//        System.out.println(databaseUpdater.transformIntegerList(ProjectConstants.ORIGINALRECORDSIDS));
//        System.out.println(DatabaseOperator.getOriginalRecordListIDs());
//        DatabaseOperator.addProfileToUserTable(profile);
//        DatabaseOperator.getAllUsers().forEach(tempProfile ->{
//            System.out.println(profile.toCSVSingle());
//            if (tempProfile.userID == 1){
//                tempProfile.undecidedTitles.forEach(record -> System.out.println(record.toCSVSingle()));
//            }
//        });
//        DatabaseOperator.getUserRecordList(1, "undecided").forEach(record -> System.out.println(record.toCSVSingle()));
        DatabaseOperator.addProfileToUserTable(profile);
    }
}
