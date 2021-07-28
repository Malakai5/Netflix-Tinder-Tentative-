package NetflixProject.Connections.DatabaseOperations;

import NetflixProject.Connections.Driver;
import NetflixProject.ProfileManagement.Profile;
import NetflixProject.Record;
import NetflixProject.SpringSearcher;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUpdater {
    private final NamedParameterJdbcTemplate queryParameter;
    public DatabaseUpdater(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.queryParameter = namedParameterJdbcTemplate;
    }
    public String transformIntegerList(List<Integer> titleIDs){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i <= titleIDs.size()-1;i++){
            sb.append(titleIDs.get(i));
            count++;
            if (count <= titleIDs.size()-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void addProfileToUserTable(Profile profile, List<Integer> titleIDs){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("add.to.users");
        String undecided = transformIntegerList(titleIDs);
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("username", profile.userName)
                .addValue("undecided", undecided)
                .addValue("password", profile.password);
        queryParameter.update(sqlQuery,mapSqlParameterSource);
    }

    public void updateRecordLists(List<Record> recordList, String listType, int id){
        String rawSqlQuery = (String) SpringSearcher.getInstance().lookUp("update.record.list");
        List<Integer> titleIDs = new ArrayList<>();
        recordList.forEach(record -> titleIDs.add(record.titleID));
        String wantedList = transformIntegerList(titleIDs);
        String sqlQuery = rawSqlQuery.replace("listType", listType);
        sqlQuery = sqlQuery.replace("titleIDs","('" + wantedList + "')");
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);
        queryParameter.update(sqlQuery,mapSqlParameterSource);
    }
}
