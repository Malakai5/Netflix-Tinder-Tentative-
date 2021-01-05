import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Record {
    String titleName;
    String titleId;
    String genre;
    String yearMade;
    String tvRating;
    String score;


    //Constructor for title class
    public Record(String titleName, String titleId, String genre, String yearMade, String tvRating, String score){
        this.titleId = titleId;
        this.titleName = titleName;
        this.yearMade = yearMade;
        this.genre = genre;
        this.tvRating = tvRating;
        this.score = score;
    }

    public Record(){
        this.titleId = titleId;
        this.titleName = titleName;
        this.yearMade = yearMade;
        this.genre = genre;
        this.tvRating = tvRating;
        this.score = score;
    }

    public String toCSV(List<Record> recordList, int i) {
        String titleName = recordList.get(i).titleName;
        String tvRating = recordList.get(i).tvRating;
        String genre = recordList.get(i).genre;
        String titleId = recordList.get(i).titleId;
        String yearMade = recordList.get(i).yearMade;
        String score = recordList.get(i).score;

        String result = titleName + "," + tvRating + "," + genre + "," + titleId + "," + yearMade + "," + score + "\n";
        return result;
    }

    public List<Record> likeOrDislike(List<Record> undecidedList,List<Record> likedList, List<Record> dislikedList){

        Scanner scnr = new Scanner(System.in);
        List<Record> newUndecidedList = undecidedList;
        System.out.println("Are you interested in this title?");
        System.out.println("Please enter: '1' for YES, '2' for NO, '3' to stop");

        for (int i = 0;i < undecidedList.size();i++){
            int choice = scnr.nextInt();
            if (choice == 1){
                System.out.println("That's a Like!!");
                likedList.add(undecidedList.get(i));
                newUndecidedList.remove(i);
            }
            //Add in the elif statements.

        }


        return newUndecidedList;
    }
}

