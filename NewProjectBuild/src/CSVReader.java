import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final String COMMA_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static CSVReader single_instance = null;
    private List<Record> originalRecordList;
    private List<Record> currentRecordList;
    private List<Profile> profileList;

    public List<Record> getOriginalRecordList() {
        return originalRecordList;
    }
    public void setOriginalRecordList(List<Record> originalRecordList) {
        this.originalRecordList = originalRecordList;
    }
    public List<Record> getCurrentRecordList() {
        return currentRecordList;
    }
    public void setCurrentRecordList(List<Record> currentRecordList) {
        this.currentRecordList = currentRecordList;
    }
    public List<Profile> getProfileList() {
        return profileList;
    }
    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public List<Record> readCSV(String fileName, Record record) throws IOException {
        String[] data;
        List<Record> recordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //Reads the initial file
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_DELIMITER);//Will split the lines into pieces
                String titleName = data[0];
                String tvRating = data[1];
                String genre = data[2];
                String titleId = data[3]; //Throwing an index out of bounds clause
                String yearMade = data[4];
                String score = data[5];
                Record currentRecords = new Record(titleName, tvRating, genre, titleId, yearMade, score);
                recordList.add(currentRecords);
                if (fileName.equals("Netflix database-CSV.csv")) {
                    setOriginalRecordList(recordList);
                } else {
                    setCurrentRecordList(recordList);
                }
            }
        }
         catch (IOException e) {

        }
        return recordList;
    }
}
