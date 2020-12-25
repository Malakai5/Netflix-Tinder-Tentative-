import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Singleton { // Used to read CSV file on initiation and never need to read it again.
    private static final String COMMA_REGEX_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static Singleton single_instance = null;

    private Singleton() {

    }

    public List<Record> readCSV(String fileName){
        String[] data;
        List<Record> recordList = new ArrayList<>();

        try (BufferedReader br =  new BufferedReader(new FileReader(fileName))) { //Reads the initial file

            String line;
            while((line = br.readLine()) != null) {
                data = line.split(COMMA_REGEX_DELIMITER);//Will split the lines into pieces

                String titleName = data[0];
                String tvRating = data[1];
                String genre = data[2];
                String titleId = data[3]; //Throwing an index out of bounds clause
                String yearMade = data[4];
                String score = data[5];

                Record currentRecords = new Record(titleName,tvRating,genre,titleId,yearMade,score);
                recordList.add(currentRecords);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    public void writeCSV(String fileName, List<Record> recordList){
        Record tempRecord = new Record();

        try (PrintWriter br = new PrintWriter( new FileWriter(fileName))) {

            String headers;

            headers = "TitleName,TvRating,Genre,TitleId,YearMade,Score \n";
            br.write(headers);

            for (int i = 0;i < recordList.size();i++){

                if (i !=0) {
                    br.write(String.valueOf(tempRecord.toCSV(recordList,i)));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Profile> readProfileCSV() {// This Method seems to work Completely as intended
        String file = "ProfileCSV.csv";
        List<Profile> profileList = new ArrayList<>();
        String[] data;

        try (BufferedReader br =  new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null){
                data = line.split(COMMA_REGEX_DELIMITER);

                String userName = data[0];
                String userID = data[1];

                Profile currentProfile = new Profile(userName,userID);
                profileList.add(currentProfile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profileList;
    }

    public void addToProfileCSV(List<Profile> profileList, List<Record> recordList) throws IOException {//Adds new Profile to profileCSV.csv
        System.out.println("Profile not found");
        System.out.println("Please enter your UserName");
        String file = "ProfileCSV.csv";
        Profile newProfile = new Profile();
        Profile tempProfile = new Profile();


        newProfile = newProfile.makeNewProfile(profileList);
//        newProfile.makeNewProfile(profileList);

        System.out.println(newProfile.userName);
        createCsv(newProfile.userName, recordList);

        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))){

            String headers;
            headers = "UserName,UserID\n";

            br.write(headers);

            for (int i = 0;i < profileList.size();i++) {
                if (i != 0) {
                    br.write(String.valueOf(tempProfile.toCSV(profileList, i)));
                }
            }
        }
    }

    public void createCsv(String userName, List<Record> recordList){
        String csvTag = ".csv";
        String file = userName + "'s Undecided Titles" + csvTag;
        writeCSV(file, recordList);
    }

    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    }