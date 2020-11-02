import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVreader {
    private static final String COMMA_DELIMITER = ",";
    int amountOfRows = 0;
    String titleName;
    String tvRating;
    String genre;
    String titleId;
    String yearMade;
    String score;


    public CSVreader(){
        this.amountOfRows = amountOfRows;
        this.titleId = titleId;
        this.tvRating = tvRating;
        this.titleName = titleName;
        this.genre = genre;
        this.yearMade = yearMade;
        this.score = score;


    }

    public List<List<String>> readCSV() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Netflix database-CSV.csv"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);

                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
        }


}


