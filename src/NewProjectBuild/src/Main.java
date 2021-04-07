import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args) throws IOException {
        CSVWriter start = new CSVWriter();
        CSVReader read = CSVReader.getInstance();
        List<Profile> profileList = read.getMainProfileList();

        Scanner scnr = new Scanner(System.in);
        String fileName = scnr.next();
        start.startProfileCSVPage(profileList);
        Profile profile = new Profile(fileName);


      profile.createProfile(profile.userName, read.getMainProfileList());

    }
}
