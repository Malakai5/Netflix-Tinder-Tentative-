import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        List<Record> recordsList;
        List<Profile> profileList;
        Singleton x = Singleton.getInstance();
        profileList = x.readProfileCSV();
        recordsList = x.readCSV("Netflix(Copy).csv");

        for (int i = 0; i < profileList.size();i++){
            System.out.println(profileList.get(i).userName + "," + profileList.get(i).userID);

        }

//        for(int i = 0;i < recordsList.size();i++){ // Prints out recordsList
//            System.out.println(recordsList.get(i).titleName + "," + recordsList.get(i).tvRating
//                    + "," + recordsList.get(i).genre + "," + recordsList.get(i).titleId + ","
//                    + recordsList.get(i).yearMade + "," + recordsList.get(i).score);
//        }


        x.writeCSV("TestCSVFile.csv",recordsList);
        x.writeProfileCSV();
        x.writeProfileCSV();

    }

}

