import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter {

    protected void writeCSV(String fileName, List<Record> recordList) {
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
            e.printStackTrace();
        }
    }

    protected void writeProfileCSV(Profile profile, List<Profile> profileList){
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
            e.printStackTrace();
        }
    }

    protected void createUndecidedCsv(String userName, List<Record> recordList) {
        String csvTag = ".csv";
        String file = userName.toLowerCase() + "'s Undecided Titles" + csvTag;
        writeCSV(file, recordList);
    }

    protected void createLikedCsv(String userName, List<Record> recordList) {
        String csvTag = ".csv";
        String file = userName.toLowerCase() + "'s Liked Titles" + csvTag;
        writeCSV(file, recordList);
    }

    protected void createDislikedCsv(String userName, List<Record> recordList) {
        String csvTag = ".csv";
        String file = userName.toLowerCase() + "'s Disliked titles" + csvTag;
        writeCSV(file, recordList);
    }

    protected void headerWriter(String filename) {
        String headers;
        headers = "TitleName,YearMade,Genre,TvRating,TitleId,Score \n";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(headers);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}