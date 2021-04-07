public class Converter {
    public String profileToString(Profile profile){
        String userName = profile.userName;
        int userID = profile.userID;

        return userName + "," + userID + "\n";
    }
    public String recordToString(Record record){
        String titleName = record.titleName;
        String tvRating = record.tvRating;
        String genre = record.genre;
        String titleId = record.titleId;
        String yearMade = record.yearMade;
        String score = record.score;

        return titleName.toLowerCase() + "," + tvRating + "," + genre + "," + titleId + "," + yearMade + "," + score + "\n";
    }
}
