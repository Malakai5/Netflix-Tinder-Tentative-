import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Singleton { // Used to read CSV file on initiation and never need to read it again.
    private static final String COMMA_REGEX_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static final String COMMA_DELIMTER = ",";
    ArrayList<Records> AllRecords = new ArrayList<>();
    private static Singleton single_instance = null;

    private Singleton() {//Singleton file to set Variable read equal to The CSV file

    }


    public ArrayList<Records> createRecords(String fileName){// returns a easily modifed set of records.

        String file = fileName;
        String[] data = new String[0];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) { //Reads the Csv file

            String line = "";
            while ((line = br.readLine()) != null) {
                data = line.split(COMMA_REGEX_DELIMITER);//Will split the lines apart.

                String titleName = data[0];
                String tvRating = data[1];//imports data into AllRecords.
                String genre = data[2];
                String titleId = data[3];
                String yearMade = data[4];
                String score = data[5];

                Records nowRecords = new Records(titleName, titleId, genre, yearMade, tvRating, score);
                AllRecords.add(nowRecords);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();}
        catch (IOException e) {
            e.printStackTrace();}

        return AllRecords;
    }

    public List<Records> readCSV(String fileName){
        String file = fileName;
        String[] data = new String[0];
        List<Records> currentFile = new ArrayList<>();

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

                Records currentRecords = new Records(titleName,tvRating,genre,titleId,yearMade,score);
                currentFile.add(currentRecords);

//                for(int i = 0;i < currentFile.size();i++){
//                    System.out.println(currentFile.get(i).titleName + "," + currentFile.get(i).tvRating
//                     + "," + currentFile.get(i).genre + "," + currentFile.get(i).titleId + ","
//                     + currentFile.get(i).yearMade + "," + currentFile.get(i).score);
//                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentFile;
    }


    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    }
    //TODO Place the contents of the Singleton Constructer into a method #Created the createRecords method
    //TODO public List<Records> readCSV(String fileName) #Ask bars to take a Look at method
    //TODO public void writeCSV(String fileName, List<Records> recordList)
