package NetflixProject.ConnectionDrivers;

import NetflixProject.ProfileManagement.Profile;
import NetflixProject.Record;
import NetflixProject.SpringSearcher;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseOperations {
   private final NamedParameterJdbcTemplate queryParameter = new NamedParameterJdbcTemplate(Driver.getDataSource());

    private List<String> splitGenres(String rawGenres){
        List<String> genreList;
        final String DELIMITER = ";";
        genreList = Arrays.asList(rawGenres.split(DELIMITER));
        return genreList;
    }

    public void test(){
        String sqlQuery = "select duration from netflix_titles";
        try{
            queryParameter.query(sqlQuery, resultSet -> {
                System.out.println(resultSet.getString("duration"));
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    private String transformIntegerList(List<Integer> titleIDs){
        StringBuilder sb = new StringBuilder();
        List<Integer> tempList = getOriginalRecordListIDs();
        tempList.forEach(id ->{sb.append(id).append(",");});
        return sb.toString();
    }

    public List<Integer> getOriginalRecordListIDs(){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("get.all.records");
        List<Integer> titledIDs = null;
        try{
            titledIDs = queryParameter.query(sqlQuery, (rs, row)-> rs.getInt("id"));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return titledIDs;
    }

    public void getUsersRecordLists(Profile profile){

    }

    public void addProfileToProfileListTable(Profile profile){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("add.to.profiles");
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("username", profile.userName)
                .addValue("password", profile.password);
        queryParameter.update(sqlQuery,mapSqlParameterSource);
    }

    public void addProfileToUserTable(Profile profile){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("add.to.user");
        String undecided = transformIntegerList(getOriginalRecordListIDs());
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("username", profile.userName)
                .addValue("undecided", undecided);
        queryParameter.update(sqlQuery,mapSqlParameterSource);
    }

    public void updateRecordLists(List<Integer> titleIDs, String listType){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("update.record.list");
       String wantedList = transformIntegerList(titleIDs);
       MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
               .addValue("listType", listType)
               .addValue("titleIDs", wantedList);
       queryParameter.update(sqlQuery,mapSqlParameterSource);
    }



}
