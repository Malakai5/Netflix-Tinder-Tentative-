package NetflixProject.CSVService;

import NetflixProject.ProfileManagement.Profile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import NetflixProject.Record;

public class CSVReader{
    private static final String COMMA_REGEX_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    public FileFoundResponse checkForFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
        } catch (IOException e) {
            System.out.println(fileName + " wasn't found");
            return FileFoundResponse.FILENOTFOUND;
        }
        return FileFoundResponse.FILEFOUND;
    }

    public FileFoundResponse checkForProfileList() {
        try (BufferedReader br = new BufferedReader(new FileReader("ProfileList"))) {
            br.readLine();
        } catch (IOException e) {
            return FileFoundResponse.FILENOTFOUND;
        }
        return FileFoundResponse.FILEFOUND;
    }

    public List<Record> readCSV(String fileName) {
        String[] data;
        List<Record> recordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //Reads the initial file
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_REGEX_DELIMITER);

                String mediaType = data[0];
                String titleName = data[1];
                String country = data[2];
                String yearMade = data[3];
                String tvRating = data[4];
                String genre = data[5];

                //TODO fix record statements

                Record currentRecords = new Record(titleName, tvRating, genre, null, yearMade, null);
                recordList.add(currentRecords);
            }
        } catch (IOException e) {
            System.out.println(fileName + " not found");
        }
        return recordList;
    }

    public List<Profile> readProfileCSV() {
        List<Profile> profileList = new ArrayList<>();
        String[] data;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("ProfileList"));
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_REGEX_DELIMITER);
                String userName = data[0].toLowerCase();
                int userID = Integer.parseInt(data[1]);
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
