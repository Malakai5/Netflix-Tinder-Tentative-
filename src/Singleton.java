import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Singleton { // Used to read CSV file on initiation and never need to read it again.
    private static final String COMMA_REGEX_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    private static final String COMMA_DELIMTER = ",";
    ArrayList<Records> AllRecords = new ArrayList<>();
    private static Singleton single_instance = null;

    // Should split the request ArrayList into individual arrays.

    private Singleton() {//Singleton file to set Variable read equal to The CSV file
        String file = "netflix database-CSV.csv";
        String[] data = new String[0];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) { //Reads the Csv file

            String line = "";
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_REGEX_DELIMITER);//Will split the lines apart.

                String titleName = data[0];
                String tvRating = data[1];//imports data into AllRecords.
                String genre = data[2];
                String titleId = data[3]; //Throwing an index out of bounds clause
                String yearMade = data[4];
                String score = data[5];

                Records nowRecords = new Records(titleName, titleId, genre, yearMade, tvRating, score); //Needs troubleshooting.
                AllRecords.add(nowRecords);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();}
        catch (IOException e) {
            e.printStackTrace();}
    }
    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    }
    //TODO Place the contents of the Singleton Constructer into a method
    //TODO public List<Records> readCSV(String fileName)
    //TODO public void writeCSV(String fileName, List<Records> recordList)
