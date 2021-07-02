package NetflixProject;

import NetflixProject.CSVService.CSVUser;
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
        System.out.println("That's a like!!");
    }

    private void addToDislikedList(Record record) {
        profile.undecidedTitles.remove(record);
        profile.dislikedTitles.add(record);
        System.out.println("That ain't it huh?");
    }

    public List<Record> compareLikedLists() {
        ProfileSearcher profileSearcher = new ProfileSearcher();
        Profile thatProfile = profileSearcher.getSecondProfile();
        List<Record> sharedTitles = new ArrayList<>();
        profile.likedTitles.forEach(record -> {
            if (thatProfile.likedTitles.contains(record))
                sharedTitles.add(record);
        });
        return sharedTitles;
    }

    public void showRecordList(List<Record> recordList) {
        if (recordList.isEmpty())
            System.out.println("That list is empty");
        else
        recordList.forEach(record -> {
            System.out.println(record.toCSVSingle());
        });
    }

    public void sortingTitles() {
        boolean stillSwiping = true;
        String undecidedListCSV = profile.userName + "'s Undecided Titles.csv";
        String likedListCSV = profile.userName + "'s Liked Titles.csv";
        String dislikedListCSV = profile.userName + "'s Disliked Titles.csv";
        Scanner scnr = new Scanner(System.in);
        System.out.println("Do you like these titles?");
        while (stillSwiping) {
            System.out.println("'1' for yes, '2' for no, and '3' to stop swiping\n");
            Record record = profile.undecidedTitles.get(1);
            System.out.println(record.toCSVSingle());
            String choice = scnr.next();
            if (choice.equals("1")) {
                addToLikedList(record);
            }
            if (choice.equals("2")) {
                addToDislikedList(record);
            }
            if (choice.equals("3")) {
                System.out.println("Alright let's stop here");
                csvWriter.writeCSV(undecidedListCSV, profile.undecidedTitles);
                csvWriter.writeCSV(likedListCSV, profile.likedTitles);
                csvWriter.writeCSV(dislikedListCSV, profile.dislikedTitles);
                stillSwiping = false;
            }
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))
                System.out.println("Please enter either '1', '2', or '3'");
        }
    }


}
