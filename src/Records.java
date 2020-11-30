import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Records {
    String titleName;
    String titleId;
    String genre;
    String yearMade;
    String tvRating;
    String score;


    //Constructor for title class
    public Records(String titleName, String titleId, String genre, String yearMade, String tvRating, String score){
        this.titleId = titleId;
        this.titleName = titleName;
        this.yearMade = yearMade;
        this.genre = genre;
        this.tvRating = tvRating;
        this.score = score;
    }
}

