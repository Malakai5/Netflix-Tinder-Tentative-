import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Singleton singleton = Singleton.getInstance();
        List <Record> recordList = singleton.recordList;
        Profile profile = new Profile();
        List<Record> likedTitles = new ArrayList<>();
        List<Record> dislikedTitles =new ArrayList<>();


//        for (int i = 0; i < recordList.size();i++){
//            System.out.println(tempRecord.toCSV(recordList,i));
//        }

//        for (int i = 0;i < profileList.size();i++){
//            System.out.print(tempProfile.toCSV(profileList,i));
//        }

//        System.out.println(tempProfile.checkExistingProfile(profileList));


//        System.out.println(profile.userName);


        System.out.println("Please enter your Username");

        Scanner scnr = new Scanner(System.in);
        String inputName = scnr.nextLine();
        String fileName = inputName + "'s Undecided Titles.csv";

        profile.setUserName(inputName);

        System.out.println("Looking for existing profile...");

        boolean existingProfile = singleton.checkExistingProfile(inputName);

        if (!existingProfile) {
            profile = singleton.addToProfileCSV();

        } else {
            singleton.writeCSV(fileName,recordList);

        }
        profile.setUndecidedTitles(recordList);

        profile.setUndecidedTitles(profile.likeOrDislike(profile.undecidedTitles));

        for (int i = 0; i < recordList.size();i++){
            Record tempRecord = new Record();
            System.out.println(tempRecord.toCSV(profile.likedTitles,i));
        }
        for (int i = 0; i < recordList.size();i++){
            Record tempRecord = new Record();
            System.out.println(tempRecord.toCSV(profile.dislikedTitles,i));
        }
    }
}

