package NetflixProject.Connections;

import NetflixProject.Connections.DatabaseOperations.DatabaseOperator;
import NetflixProject.ProfileManagement.Profile;

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
        //--------------TESTING FOR DATABASE UPDATER-------------//
//        DatabaseOperator.addProfileToUserTable(profile);
//        DatabaseOperator.updateRecordLists(profile.userName, "liked", 1);
        //--------------TESTING FOR DATABASE QUERYS--------------//
//        DatabaseOperator.getUserRecordList(profile.userName, "UNDECIDED").forEach(record -> System.out.println(record.toCSVSingle()));
//        DatabaseOperator.getAllUsers().forEach(user -> System.out.println(user.toCSVSingle()));
//        DatabaseOperator.getOriginalRecordList().forEach(record -> System.out.println(record.toCSVSingle()));
//        System.out.println(DatabaseOperator.getTitle(22).toCSVSingle());
    }
}
