public class Record {
    String titleName;
    int titleId;
    String genre;
    int yearMade;
    String tvRating;
    int score;

    public Record(String titleName, String titleId, String genre, String yearMade, String tvRating, String score){
        this.titleId = Integer.parseInt(titleId);
        this.titleName = titleName;
        this.yearMade = Integer.parseInt(yearMade);
        this.genre = genre;
        this.tvRating = tvRating;
        this.score = Integer.parseInt(score);
    }

    public Record() {

    }
}
