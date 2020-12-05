import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Singleton { // Used to read CSV file on initiation and never need to read it again.
    private static final String COMMA_REGEX_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static final String COMMA_DELIMTER = ",";
    ArrayList<Record> AllRecords = new ArrayList<>();
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
        String file = fileName;
        String[] data = new String[0];
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
    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    }
    //TODO Place the contents of the Singleton Constructer into a method #Created the createRecords method
    //TODO public List<Records> readCSV(String fileName) #Ask bars to take a Look at method
    //TODO public void writeCSV(String fileName, List<Records> recordList) #Completed
