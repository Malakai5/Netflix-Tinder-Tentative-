import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final String COMMA_REGEX_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";


    public List<Record> readCSV(String fileName) {
        String[] data;
        List<Record> recordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //Reads the initial file
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_REGEX_DELIMITER);//Will split the lines into pieces

                String titleName = data[0];
                String tvRating = data[1];
                String genre = data[2];
                String titleId = data[3]; //Throwing an index out of bounds clause
                String yearMade = data[4];
                String score = data[5];

                Record currentRecords = new Record(titleName, tvRating, genre, titleId, yearMade, score);
                recordList.add(currentRecords);
            }

        } catch (IOException e) {
            System.out.println(fileName + " not found");

        }
        return recordList;
    }

    public List<Profile> readProfileCSV() {// This Method seems to work Completely as intended
        List<Profile> profileList = new ArrayList<>();
        String[] data;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("ProfileList"));
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_REGEX_DELIMITER);
                String userName = data[0].toLowerCase();
                String userID = data[1];
                Profile currentProfile = new Profile(userName, userID);
                profileList.add(currentProfile);
            }
        } catch (IOException e) {
            System.out.println("ProfileList does not exist");
        } finally {
            if (br != null) {
                try {

                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return profileList;
    }
}
