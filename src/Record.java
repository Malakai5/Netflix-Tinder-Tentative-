import java.util.List;

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
}
//TODO create a toCSV method