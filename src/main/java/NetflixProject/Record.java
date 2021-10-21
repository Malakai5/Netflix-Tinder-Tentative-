package NetflixProject;

import java.util.List;

public class Record {
    public int titleID;
    public String mediaType;
    public String titleName;
    public String country;
    public List<String> genre;
    public int releaseYear;
    public String tvRating;
    public String duration;
    public String description;

    public Record(String mediaType, String titleName, String country, int releaseYear, String tvRating,
                  String duration, List<String> genre, String description, int titleID){
        this.titleID = titleID;
        this.description = description;
        this.duration = duration;
        this.country = country;
        this.mediaType = mediaType;
        this.titleName = titleName;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.tvRating = tvRating;
    }

    public Record(){
    }

    public Record(String titleName, String tvRating, String genre, Object o, String releaseYear, Object o1) {
    }

    public String toCSV(List<Record> recordList, int i) {
        String mediaType = recordList.get(i).mediaType;
        String country = recordList.get(i).country;
        String duration = recordList.get(i).duration;
        String titleName = recordList.get(i).titleName;
        String tvRating = recordList.get(i).tvRating;
        List<String> genre = recordList.get(i).genre;
        int yearMade = recordList.get(i).releaseYear;

        return mediaType + ", " + titleName + ", " + country + ", "
                + yearMade + ", " + tvRating + ", " + duration + ", " + genre;
    }

    public String toCSVSingle(){
        return mediaType + ", " + titleName + ", " + country + ", "
                + releaseYear + ", " + tvRating + ", " + duration + ", " + genre;}

}
