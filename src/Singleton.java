import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Singleton { // Used to read CSV file on initiation and never need to read it again.
    private static final String COMMA_REGEX_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static final String COMMA_DELIMTER = ",";
    ArrayList<Record> AllRecords = new ArrayList<>();
    List<Profile> profileList = new ArrayList<>();
    private static Singleton single_instance = null;

    private Singleton() {

    }

    public List<Record> readCSV(String fileName){
        String file = fileName;
        String[] data = new String[0];
        List<Record> recordList = new ArrayList<>();

        try (BufferedReader br =  new BufferedReader(new FileReader(file))) { //Reads the initial file

            String line = "";
            while((line = br.readLine()) != null) {
                data = line.split(COMMA_REGEX_DELIMITER);//Will split the lines into pieces

                String titleName = data[0];
                String tvRating = data[1];//imports data into AllRecords.
                String genre = data[2];
                String titleId = data[3]; //Throwing an index out of bounds clause
                String yearMade = data[4];
                String score = data[5];

                Record currentRecords = new Record(titleName,tvRating,genre,titleId,yearMade,score);
                recordList.add(currentRecords);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
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

    public List<Profile> readProfileCSV() throws FileNotFoundException {
        String file = "ProfileCSV.csv";
        List<Profile> profileList = new ArrayList<>();

        try (BufferedReader br =  new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null){
                String[] data = line.split(COMMA_REGEX_DELIMITER);

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


    public void writeProfileCSV(List<Profile> profileList) throws IOException {
        Profile tempProfile = new Profile();
        tempProfile.makeNewProfile(profileList);
        String file = "Profile.CSV";

        try (PrintWriter br = new PrintWriter(new FileWriter(file))) {
            String headers;
            headers = "Name, UserId\n";
            br.write(headers);

            String entry = tempProfile.userName + "," + tempProfile.userID + "\n";
            br.write(entry);
        }//Giving an array Out of Bounds Exception
    }





    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    }