import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Singleton { // Used to read CSV file on initiation and never need to read it again.
    private static final String COMMA_REGEX_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static Singleton single_instance = null;
    List<Profile> profileList;
    List<Record> recordList;

    private Singleton() {
        this.profileList = readProfileCSV();
        this.recordList = readCSV("Netflix(Original!!).csv");


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

    public Profile addToProfileCSV() throws IOException {//Adds new Profile to profileCSV.csv
        System.out.println("Profile not found");
        System.out.println("Please enter your UserName");
        String file = "ProfileCSV.csv";
        Profile newProfile = new Profile();
        Profile tempProfile = new Profile();

        newProfile = newProfile.makeNewProfile(profileList);

        createCsv(newProfile.userName, recordList);//Creates the undecided list for new Profiles.

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
        return newProfile;
    }


//    public List<Record> getUndecidedTitles(List<Record> recordList) throws IOException {
//        List<Record> undecidedTitles = new ArrayList<>();
//        Profile tempProfile = new Profile();
//        System.out.println("Please enter your Username");
//        Scanner scnr = new Scanner(System.in);
//        String inputName = scnr.nextLine();
//        String fileName = inputName + "'s Undecided Titles.csv";
//        System.out.println("Looking for existing profile...");
//
//        boolean existingProfile = checkExistingProfile(inputName);
//
//        if (!existingProfile){
//           addToProfileCSV(recordList);
//        }
//        else{
//            undecidedTitles = readCSV(fileName);
////            for (int i = 0; i < recordList.size();i++){
////                System.out.println(tempRecord.toCSV(recordList,i)); // for testing in case of failures.
////            }
//        }
//        return undecidedTitles;
//    }

    public void createCsv(String userName, List<Record> recordList){
        String csvTag = ".csv";
        String file = userName + "'s Undecided Titles" + csvTag;
        writeCSV(file, recordList);
    }

    public boolean checkExistingProfile(String inputName){
        boolean results = false;
        for (int i = 0;i < profileList.size();i++){
            if (profileList.get(i).userName.contains(inputName)) {
                results = true;
                System.out.println("Profile found!!");
                break;
            }
        }
        return results;
    }

    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    }

    //Create attribute inside of singleton constructer that Keeps the profileList.