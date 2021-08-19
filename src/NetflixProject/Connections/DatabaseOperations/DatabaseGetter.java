package NetflixProject.Connections.DatabaseOperations;

import NetflixProject.Connections.Driver;
import NetflixProject.ProfileManagement.Profile;
import NetflixProject.Record;
import NetflixProject.SpringSearcher;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseGetter {
    private final NamedParameterJdbcTemplate queryParameter;
    public DatabaseGetter(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.queryParameter = namedParameterJdbcTemplate;
    }

    private List<Integer> transformStringBack(String rawIDList){
        if (rawIDList == null){
            return new ArrayList<>();
        }
        List<String> rawIDStringList = Arrays.asList(rawIDList.split(","));
        List<Integer> titleIDs = new ArrayList<>();
        rawIDStringList.forEach(id -> titleIDs.add(Integer.parseInt(id)));
        return titleIDs;
    }

    private List<String> splitGenres(String rawGenres){
        List<String> genreList;
        final String DELIMITER = ";";
        genreList = Arrays.asList(rawGenres.split(DELIMITER));
        return genreList;
    }

    public List<Record> getUserRecordList(int userID, String listType){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("get.user.records");
        List<Integer> titleIDs;
        List<String> rawStringList;
        String temp = "";
        sqlQuery = sqlQuery.replace(":listType",listType);
        sqlQuery = sqlQuery.replace(":id", String.valueOf(userID));
        rawStringList = queryParameter.query(sqlQuery, (rs, row)-> temp.replace(temp,rs.getObject(listType,String.class)));
        String rawString = rawStringList.get(0);
        titleIDs = transformStringBack(rawString);
        return getTitleList(titleIDs);
    }

    public Record getTitle(int id){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("get.title");
        Record record = new Record();
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("id",id);
        queryParameter.query(sqlQuery,mapSqlParameterSource,rs ->{
            record.titleID = rs.getInt("id");
            record.mediaType = rs.getString("type");
            record.titleName = rs.getString("title");
            record.country = rs.getString("country");
            record.releaseYear = rs.getInt("release_year");
            record.tvRating = rs.getString("rating");
            record.duration = rs.getString("duration");
            record.genre = splitGenres(rs.getString("genre"));
            record.description = rs.getString("description");
        });
        return record;
    }

    public List<Integer> getOriginalRecordListIDs(){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("get.all.records");
        List<Integer> titledIDs;
        titledIDs = queryParameter.query(sqlQuery, (rs, row)-> rs.getInt("id"));
        return titledIDs;
    }

    public List<Record> getTitleList(List<Integer> titleIDs){
        List<Record> recordList = new ArrayList<>();
        for (int i=0; i<=titleIDs.size()-1;i++){
            recordList.add(getTitle(titleIDs.get(i)));
        }
        return recordList;
    }

    public List<Profile> getAllUsers(){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("get.all.users");
        List<Profile> profileList;
        profileList = queryParameter.query(sqlQuery, (rs, row)->{
            Profile profile = new Profile();
            profile.userID = rs.getInt("id");
            profile.userName = rs.getString("username");
            profile.password = rs.getString("password");
            profile.undecidedTitles = getUserRecordList(profile.userID, "undecided");
            profile.likedTitles = getUserRecordList(profile.userID, "liked");
            profile.dislikedTitles = getUserRecordList(profile.userID, "disliked");
            return profile;
        });
        return profileList;
    }
}
