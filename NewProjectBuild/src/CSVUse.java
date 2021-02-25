import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUse {
    protected class CSVReader {
    private static final String COMMA_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    protected List<Record> originalRecordList;
    protected List<Record> currentRecordList;
    protected List<Profile> profileList;

    public List<Record> getOriginalRecordList() {
        return originalRecordList;
    }
    public List<Record> getCurrentRecordList() {
        return currentRecordList;
    }
    public List<Profile> getProfileList() {
        return profileList;
    }
    private void setOriginalRecordList(List<Record> originalRecordList) {
        this.originalRecordList = originalRecordList;
    }
    private void setCurrentRecordList(List<Record> currentRecordList) {
        this.currentRecordList = currentRecordList;
    }
    private void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public void readCSVtoRecord(String fileName) {
        String[] data;
        List<Record> recordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //Reads the initial file
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_DELIMITER);//Will split the lines into pieces
                Record currentRecords = new Record(data[0], data[1], data[2], data[3], data[4], data[5]);
                recordList.add(currentRecords);
                if (fileName.equals("Netflix database-CSV.csv")) {
                    setOriginalRecordList(recordList);
                } else {
                    setCurrentRecordList(recordList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCSVtoProfile(String fileName) {
        String[] data;
        List<Profile> profileList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //Reads the initial file
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_DELIMITER);
                Profile profile = new Profile(data[0], data[1]);
                profileList.add(profile);
                setProfileList(profileList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    protected class CSVWriter extends Converter {

        public void writeRecordToCSV(String fileName, List<Record> recordList){
            try (PrintWriter br = new PrintWriter( new FileWriter(fileName))) {
                String headers;
                headers = "TitleName,YearMade,Genre,TvRating,TitleId,Score \n";
                br.write(headers);

                for (int i = 0;i < recordList.size();i++){
                    if (i != 0) {
                        Record record = recordList.get(i);
                        br.write(recordToString(record));
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void writeProfileToCSV(String fileName, List<Profile> profileList){
            try (PrintWriter br = new PrintWriter( new FileWriter(fileName))) {
                String headers;
                headers = "TitleName,YearMade,Genre,TvRating,TitleId,Score \n";
                br.write(headers);

                for (int i = 0;i < profileList.size();i++){
                    if (i != 0) {
                        Profile profile = profileList.get(i);
                        br.write(profileToString(profile));
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String CSVtoString(){


            return null;
        }
    }
}