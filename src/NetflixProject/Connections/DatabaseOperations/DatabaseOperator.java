package NetflixProject.Connections.DatabaseOperations;

import NetflixProject.Connections.Driver;
import NetflixProject.ProfileManagement.Profile;
import NetflixProject.Record;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class DatabaseOperator {
    private static final NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(Driver.getDataSource());
    public static DatabaseGetter databaseGetter = new DatabaseGetter(namedParameterJdbcTemplate);
    public static DatabaseUpdater databaseUpdater = new DatabaseUpdater(namedParameterJdbcTemplate);

    public static List<Record> getOriginalRecordList(){
        return databaseGetter.getOriginalRecordList();
    }

    public static List<Profile> getAllUsers(){
        return databaseGetter.getAllUsers();
    }

    public static List<Record> getUserRecordList(String username, String choice){
        return databaseGetter.getUserRecordList(username, choice);
    }

    public static Record getTitle(int id){
        return databaseGetter.getTitle(id);
    }

    public static void addProfileToUserTable(Profile profile){
        databaseUpdater.addProfileToUserTable(profile);
    }

    public static void updateRecordLists(String username, String choice, int id){
        databaseUpdater.updateRecordLists(username, choice, id);
    }
}
