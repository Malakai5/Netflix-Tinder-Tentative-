import java.io.*;


class Records {
    String titleName;
    int titleId;
    int[] titleIdList;
    int listQuantity = titleIdList.length;
    String genre;
    int yearMade;
    String tvRating;
    int score;


    //Constructor for title class
    public Records(String titleName, int titleId, String genre, int yearMade, String tvRating, int score){
        this.titleId = titleId;
        this.titleName = titleName;
        this.yearMade = yearMade;
        this.genre = genre;
        this.tvRating = tvRating;
        this.score = score;
    }

    Singleton readCVS = Singleton.getInstance();


}

