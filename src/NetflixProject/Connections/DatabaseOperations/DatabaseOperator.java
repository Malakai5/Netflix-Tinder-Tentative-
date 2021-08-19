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

    public static List<Integer> getOriginalRecordListIDs(){
        return databaseGetter.getOriginalRecordListIDs();
    }

    public static List<Profile> getAllUsers(){
        return databaseGetter.getAllUsers();
    }

    public static List<Record> getUserRecordList(int userID, String listType){
        return databaseGetter.getUserRecordList(userID, listType);
    }

    public static Record getTitle(int id){
        return databaseGetter.getTitle(id);
    }

    public static List<Record> getTitleList(List<Integer> titleIDs){return databaseGetter.getTitleList(titleIDs);}


    public static void addProfileToUserTable(Profile profile){
        databaseUpdater.addProfileToUserTable(profile);
    }

    public static void updateRecordLists(List<Record> recordList, String listType, int id){
        databaseUpdater.updateRecordLists(recordList, listType, id);
    }
}
