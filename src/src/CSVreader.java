import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVreader {
    private static final String COMMA_DELIMITER = ",";
    String titleName;
    String tvRating;
    String genre;
    String titleId;
    String yearMade;
    String score;


    public CSVreader(){
        this.titleId = titleId;
        this.tvRating = tvRating;
        this.titleName = titleName;
        this.genre = genre;
        this.yearMade = yearMade;
        this.score = score;


    }

    public List<List<String>> readCSV() {
        String file = "Netflix database-CSV.csv";
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) { //Reads the Csv file

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



        //Construct smoother singleton
}


