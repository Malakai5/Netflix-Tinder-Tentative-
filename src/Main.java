import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Singleton singleton = Singleton.getInstance();
        List <Record> recordList = singleton.recordList;


//        for (int i = 0; i < recordList.size();i++){
//            System.out.println(tempRecord.toCSV(recordList,i));
//        }

//        for (int i = 0;i < profileList.size();i++){
//            System.out.print(tempProfile.toCSV(profileList,i));
//        }

//        System.out.println(tempProfile.checkExistingProfile(profileList));



        System.out.println("Please enter your Username");

        Scanner scnr = new Scanner(System.in);
        String inputName = scnr.nextLine();
        String fileName = inputName + "'s Undecided Titles.csv";

        System.out.println("Looking for existing profile...");

        boolean existingProfile = singleton.checkExistingProfile(inputName);

        Profile profile = new Profile();
        if (!existingProfile) {
            profile = singleton.addToProfileCSV();

        } else {
            singleton.writeCSV(fileName,recordList);

        }
        profile.setUndecidedTitles(recordList);

    }
}

