import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private static CSVReader single_instance = null;
    private static final String COMMA_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    private final List<Record> originalRecordList = readRecordCSV("TestCSVFile.csv");
    private final List<Profile> mainProfileList = readProfileCSV();

    public List<Record> currentRecordList;
    public List<Profile> profileList;

    public List<Profile> getMainProfileList() {
        return mainProfileList;
    }
    public List<Record> getOriginalRecordList() {
        return originalRecordList;
    }

    private void setCurrentRecordList(List<Record> currentRecordList) {
        this.currentRecordList = currentRecordList;
    }
    private void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }


    public List<Record> readRecordCSV(String fileName) {
        String[] partsOfRecord;
        List<Record> recordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String recordEntry;
            while ((recordEntry = br.readLine()) != null) {
                partsOfRecord = recordEntry.split(COMMA_DELIMITER);
                Record currentRecords = new Record(partsOfRecord[0], partsOfRecord[1], partsOfRecord[2], partsOfRecord[3], partsOfRecord[4], partsOfRecord[5]);
                recordList.add(currentRecords);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setCurrentRecordList(recordList);
        return recordList;
    }

    public List<Profile> readProfileCSV() {
        String[] data;
        List<Profile> profileList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ProfileList"))) {
            //Reads the initial file
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_DELIMITER);
                if (!data[0].equals("UserName")) {
                    Profile profile = new Profile(data[0], Integer.parseInt(data[1]));
                    profileList.add(profile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setProfileList(profileList);
        return profileList;
    }


    public static CSVReader getInstance() {
        if (single_instance == null)
            single_instance = new CSVReader();
        return single_instance;
    }
}