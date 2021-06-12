package NetflixProject;

import NetflixProject.ProfileManagement.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RecordListManipulator {
    Profile profile;

    RecordListManipulator(Profile profile) {
        this.profile = profile;
    }

    private void addToLikedList(Record record) {
        profile.undecidedTitles.remove(record);
        profile.likedTitles.add(record);
    }

    private void addToDislikedList(Record record) {
        profile.undecidedTitles.remove(record);
        profile.likedTitles.remove(record);
    }

    public List<Record> compareLikedLists(Profile thatProfile) {
        List<Record> sharedTitles = new ArrayList<>();
        profile.likedTitles.forEach(record -> {
            if (thatProfile.likedTitles.contains(record))
                sharedTitles.add(record);
        });
        return sharedTitles;
    }

    public void showRecordList(List<Record> recordList) {
        recordList.forEach(record -> {
            System.out.println(record.toCSVSingle());
        });
    }

    public void sortingTitles() {
        boolean stillSwiping = true;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Do you like these titles?");
        while (stillSwiping) {
            System.out.println("'1' for yes, '2' for no, and '3' to stop swiping\n");
            Record record = profile.undecidedTitles.get(1);
            System.out.println(record.toCSVSingle());
            String choice = scnr.next();
            if (choice.equals("1")) {
                addToLikedList(record);
                System.out.println("That's a like!!");
            }
            if (choice.equals("2")) {
                addToDislikedList(record);
                System.out.println("That ain't it huh?");
            }
            if (choice.equals("3")) {
                System.out.println("Alright let's stop here");
                stillSwiping = false;
            }
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))
                System.out.println("Please enter either '1', '2', or '3'");
        }
    }


}
