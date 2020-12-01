import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Records> recordsList;
        Singleton x = Singleton.getInstance();
        recordsList = x.readCSV("Netflix(Copy).csv");
        recordsList.remove(330);//removes id 330 from recordsList but not from "Netflix(Copy).csv"

        for(int i = 0;i < recordsList.size();i++){ // Prints out recordsList
            System.out.println(recordsList.get(i).titleName + "," + recordsList.get(i).tvRating
                    + "," + recordsList.get(i).genre + "," + recordsList.get(i).titleId + ","
                    + recordsList.get(i).yearMade + "," + recordsList.get(i).score);
        }


        x.writeCSV("TestCSVFIle.csv",recordsList);
    }
}
// TODO Call readCSV, print out the list #Completed
// TODO Delete things in the list #Needs to be able to permanently delete from Netflix(Copy).csv
// TODO Write the list to a file