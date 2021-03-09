import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter extends Converter {

    private void startRecordCSVPage(String fileName) throws IOException {
        try (PrintWriter br = new PrintWriter( new FileWriter(fileName))) {
            br.write("TitleName,YearMade,Genre,TvRating,TitleId,Score \n");}
    }

    private void writeIndividualEntry(String fileName, Record record) throws IOException {
        try (PrintWriter br = new PrintWriter( new FileWriter(fileName))){
            br.write(recordToString(record));
        }
    }

    public void writeRecordToCSV(String fileName, List<Record> recordList) throws IOException {
        startRecordCSVPage(fileName);
        for (int i = 0; i < recordList.size(); i++) {
            if (i != 0) {
                writeIndividualEntry(fileName,recordList.get(i));
            }
        }
    }


    private void startProfileCSVPage(String fileName) throws IOException {
        try (PrintWriter br = new PrintWriter( new FileWriter(fileName))) {
            br.write("UserName, UserId\n");}
    }

    private void writeIndividualEntry(String fileName, Profile profile) throws IOException {
        try (PrintWriter br = new PrintWriter( new FileWriter(fileName))){
            br.write(profileToString(profile));
        }
    }

    public void writeProfileToCSV(String fileName, List<Profile> profileList) throws IOException {
        startProfileCSVPage(fileName);
        for (int i = 0; i < profileList.size(); i++) {
            if (i != 0) {
                writeIndividualEntry(fileName,profileList.get(i));
            }
        }
    }

}