import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Record tempRecord = new Record();
        Profile tempProfile = new Profile();
        List<Record> recordList = new ArrayList<>();
        List<Profile> profileList = new ArrayList<>();
        Singleton singleton = Singleton.getInstance();
        recordList = singleton.readCSV("Netflix(Original!!).csv");
        profileList = singleton.readProfileCSV();



//        for (int i = 0; i < recordList.size();i++){
//            System.out.println(tempRecord.toCSV(recordList,i));
//        }

//        for (int i = 0;i < profileList.size();i++){
//            System.out.print(tempProfile.toCSV(profileList,i));
//        }

//        System.out.println(tempProfile.checkExistingProfile(profileList));

       List<Record> undecidedList1 = singleton.getUndecidedTitles(profileList,recordList);//Takes the username and either adds a new profile or returns the undecided List

    }

}

