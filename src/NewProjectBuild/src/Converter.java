public class Converter {
    public String profileToString(Profile profile){
        String userName = profile.userName;
        String userID = profile.userID;

        return userName + "," + userID + "\n";
    }
    public String recordToString(Record record){
        String titleName = record.titleName;
        String tvRating = record.tvRating;
        String genre = record.genre;
        int titleId = record.titleId;
        int yearMade = record.yearMade;
        int score = record.score;

        return titleName.toLowerCase() + "," + tvRating + "," + genre + "," + titleId + "," + yearMade + "," + score + "\n";
    }
}
