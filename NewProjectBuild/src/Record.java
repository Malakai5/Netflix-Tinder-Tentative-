public class Record {
    String titleName;
    String titleId;
    String genre;
    String yearMade;
    String tvRating;
    String score;

    public Record(){
    }

    public Record(String titleName, String titleId, String genre, String yearMade, String tvRating, String score){
        this.titleId = titleId;
        this.titleName = titleName;
        this.yearMade = yearMade;
        this.genre = genre;
        this.tvRating = tvRating;
        this.score = score;
    }
}
