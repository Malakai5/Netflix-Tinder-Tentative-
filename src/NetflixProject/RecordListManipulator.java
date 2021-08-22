package NetflixProject;

import NetflixProject.CSVService.CSVUser;
import NetflixProject.Connections.DatabaseOperations.DatabaseOperator;
import NetflixProject.ProfileManagement.Profile;
import NetflixProject.ProfileManagement.ProfileSearcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordListManipulator implements CSVUser {
    Profile profile;
    public RecordListManipulator(Profile profile) {
        this.profile = profile;
    }

    private void addToLikedList(Record record) {
        profile.undecidedTitles.remove(record);
        profile.likedTitles.add(record);
        DatabaseOperator.updateRecordLists(profile.userName, "LIKED", record.titleID);
        System.out.println("That's a like!!\n");
    }

    private void addToDislikedList(Record record) {
        profile.undecidedTitles.remove(record);
        profile.dislikedTitles.add(record);
        DatabaseOperator.updateRecordLists(profile.userName, "DISLIKED", record.titleID);
        System.out.println("That ain't it huh?\n");
    }

    public void compareLikedLists() {
        ProfileSearcher profileSearcher = new ProfileSearcher();
        Profile thatProfile = profileSearcher.requestSecondProfile();
        List<Record> sharedTitles = new ArrayList<>();
        if (thatProfile != null) {
            int listSize = 0;
            while (listSize < profile.likedTitles.size() && listSize < thatProfile.likedTitles.size()) {
                Record temp = profile.likedTitles.get(listSize);
                thatProfile.likedTitles.forEach(record -> {
                    if (record.titleName.equals(temp.titleName)) {
                        sharedTitles.add(temp);
                    } //TODO fix this bull
                });
                listSize++;
            }
            showRecordList(sharedTitles);
        }
    }

    public void showRecordList(List<Record> recordList) {
        if (recordList.isEmpty())
            System.out.println("That list is empty\n");
        else
        recordList.forEach(record -> System.out.println(record.toCSVSingle() +"\n"));
    }

    public void sortingTitles() {
        boolean stillSwiping = true;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Do you like these titles?");
        while (stillSwiping) {
            System.out.println("'1' for yes, '2' for no, and '3' to stop swiping\n");
            Record record = profile.undecidedTitles.get(0);
            System.out.println(record.toCSVSingle());
            String choice = scnr.next();
            if (choice.equals("1")) {
                addToLikedList(record);
            }
            if (choice.equals("2")) {
                addToDislikedList(record);
            }
            if (choice.equals("3")) {
                System.out.println("Alright let's stop here\n");
                stillSwiping = false;
            }
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))
                System.out.println("Please enter either '1', '2', or '3'");
        }
    }
}
