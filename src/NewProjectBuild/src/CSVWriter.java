import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter extends Converter {

    protected void startRecordCSVPage(String fileName) {
        try (PrintWriter br = new PrintWriter( new FileWriter(fileName))) {
            br.write("TitleName,YearMade,Genre,TvRating,TitleId,Score \n");
        } catch (Exception e){
            System.out.println("Error on creation");
        }
    }
    protected void startProfileCSVPage(List<Profile> profileList) {
        try (PrintWriter br = new PrintWriter( new FileWriter("ProfileList"))) {
            Profile profile = new Profile("UserName", "UserID");
            br.write(profileToString(profile));
            profileList.add(profile);
        } catch (Exception e){
            System.out.println("Error on creation");
        }
    }


    protected void writeIndividualEntry(String fileName, Record record) {
        try (PrintWriter br = new PrintWriter( new FileWriter(fileName))){
            br.write(recordToString(record));
        }
        catch (Exception e){
            System.out.println("Error on Writing individual Record");
        }
    }

    protected void writeRecordToCSV(String fileName, List<Record> recordList) {
        for (int i = 0; i < recordList.size(); i++) {
            if (i != 0) {
                writeIndividualEntry(fileName,recordList.get(i));
            }
        }
    }


    protected void writeIndividualEntry(Profile profile) {
        try (PrintWriter br = new PrintWriter( new FileWriter("ProfileList"))){
            br.write(profileToString(profile));
        }  catch (Exception e){
            System.out.println("Error on Writing individual Profile");
        }
    }

    protected void writeProfileToCSV(List<Profile> profileList) {
        for (int i = 0; i < profileList.size(); i++) {
            if (i != 0) {
                writeIndividualEntry(profileList.get(i));
            }
        }
    }

}