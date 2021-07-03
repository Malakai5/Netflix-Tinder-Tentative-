package NetflixProject;

import java.util.List;

public class Record {
    String titleName;
    String titleId;
    String genre;
    String yearMade;
    String tvRating;
    String score;

    public Record(String titleName, String titleId, String genre, String yearMade, String tvRating, String score){
        this.titleId = titleId;
        this.titleName = titleName;
        this.yearMade = yearMade;
        this.genre = genre;
        this.tvRating = tvRating;
        this.score = score;
    }

    public Record(){
    }

    public String toCSV(List<Record> recordList, int i) {
        String titleName = recordList.get(i).titleName;
        String tvRating = recordList.get(i).tvRating;
        String genre = recordList.get(i).genre;
        String titleId = recordList.get(i).titleId;
        String yearMade = recordList.get(i).yearMade;
        String score = recordList.get(i).score;

        return titleName.toLowerCase() + "," + tvRating + "," + genre + "," + titleId + "," + yearMade + "," + score + "\n";
    }

    public String toCSVSingle(){
        return titleName.toLowerCase() + "," + tvRating + "," + genre + "," + titleId + "," + yearMade + "," + score + "\n";
    }

}
