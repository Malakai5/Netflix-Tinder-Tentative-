package NetflixProject.ConnectionDrivers;

import NetflixProject.Record;
import NetflixProject.SpringSearcher;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Arrays;
import java.util.List;

public class DatabaseSearcher {
    NamedParameterJdbcTemplate queryParameter = new NamedParameterJdbcTemplate(Driver.getDataSource());
    public List<String> splitGenres(String rawGenres){
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

    public List<Record> getOriginalRecordList(){
        String sqlQuery = (String) SpringSearcher.getInstance().lookUp("get.all.records");
        List<Record> recordList = null;
        try{
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
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return recordList;
    }

}
