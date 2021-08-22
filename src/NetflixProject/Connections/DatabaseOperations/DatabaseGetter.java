package NetflixProject.Connections.DatabaseOperations;

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

    public List<Record> getUserRecordList(String username, String choice){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("get.user.records");
        List<Record> recordList;
        sqlQuery = sqlQuery.replace("username", username);
        sqlQuery = sqlQuery.replace("choice", choice);
        recordList = queryParameter.query(sqlQuery, (rs, row)->{
            Record record = new Record();
            record.titleID = rs.getInt("id");
            record.mediaType = rs.getString("type");
            record.titleName = rs.getString("title");
            record.country = rs.getString("country");
            record.releaseYear = rs.getInt("release_year");
            record.tvRating = rs.getString("rating");
            record.duration = rs.getString("duration");
            record.genre = splitGenres(rs.getString("genre"));
            record.description = rs.getString("description");
            return record;
        });
        return recordList;
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

    public List<Record> getOriginalRecordList(){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("get.all.records");
        List<Record> recordList;
        recordList = queryParameter.query(sqlQuery, (rs, row)->{
            Record record = new Record();
            record.titleID = rs.getInt("id");
            record.mediaType = rs.getString("type");
            record.titleName = rs.getString("title");
            record.country = rs.getString("country");
            record.releaseYear = rs.getInt("release_year");
            record.tvRating = rs.getString("rating");
            record.duration = rs.getString("duration");
            record.genre = splitGenres(rs.getString("genre"));
            record.description = rs.getString("description");
            return record;
        });
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
            profile.undecidedTitles = getUserRecordList(profile.userName, "undecided");
            profile.likedTitles = getUserRecordList(profile.userName, "liked");
            profile.dislikedTitles = getUserRecordList(profile.userName, "disliked");
            return profile;
        });
        return profileList;
    }



    //---------HELPER METHODS------------//
    private List<String> splitGenres(String rawGenres){
        List<String> genreList;
        final String DELIMITER = ";";
        genreList = Arrays.asList(rawGenres.split(DELIMITER));
        return genreList;
    }

}
