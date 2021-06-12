package NetflixProject.CSVService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import NetflixProject.ProfileManagement.Profile;
import NetflixProject.Record;

public class CSVWriter {

    public void writeCSV(String fileName, List<Record> recordList) {
        Record tempRecord = new Record();
        try (PrintWriter br = new PrintWriter(new FileWriter(fileName))) {
            String headers;
            headers = "TitleName,YearMade,Genre,TvRating,TitleId,Score \n";
            br.write(headers);
            for (int i = 0; i < recordList.size(); i++) {
                if (i != 0) {
                    br.write(String.valueOf(tempRecord.toCSV(recordList, i)));
                }
            }
        } catch (IOException e) {
            System.out.println("File not found, please try again.");
        }
    }

    public void writeProfileCSV(Profile profile, List<Profile> profileList) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("ProfileList"))) {
            String headers;
            headers = "UserName,UserID\n";
            br.write(headers);

            for (int i = 0; i < profileList.size(); i++) {
                if (i != 0) {
                    br.write(String.valueOf(profile.toCSV(profileList, i)));
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }


    public void headerWriter(String filename) {
        String headers;
        headers = "TitleName,YearMade,Genre,TvRating,TitleId,Score \n";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(headers);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

