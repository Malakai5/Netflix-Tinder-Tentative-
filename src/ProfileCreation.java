import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProfileCreation implements CSVUser{

    private boolean checkExistingProfile(String inputName, List<Profile> profileList) {
        boolean results = false;
        for (Profile value : profileList) {
            if (value.userName.contains(inputName)) {
                results = true;
                System.out.println("Profile found!!\n");
                break;
            }
        }
        return results;
    }

    public Profile makeNewProfile(List<Profile> profileList) {
        Scanner scnr = new Scanner(System.in);
        String userName = scnr.nextLine();
        int selectID = profileList.size();
        String userID = Integer.toString(selectID);
        Profile newProfile = new Profile(userName, userID);
        profileList.add(newProfile);
        return newProfile;
    }

    private void makeEmptyCSVs(List<Record> recordList, String userName) throws IOException {
        String undecidedList = userName + "'s Undecided Titles.csv";
        String likedList = userName + "'s Liked Titles.csv";
        String dislikedList = userName + "'s Disliked Titles.csv";
        csvWriter.headerWriter(likedList);
        csvWriter.headerWriter(dislikedList);
        Collections.shuffle(recordList);

        csvWriter.writeCSV(undecidedList, recordList);
    }


}
