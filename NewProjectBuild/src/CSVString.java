public class CSVString {

    public String toCSVSingle(Profile profile){
        String userName = profile.userName;
        String userID = profile.userID;

        return userName + "," + userID + "\n";
    }
    public String toCSVSingle(Record record){
        String titleName = record.titleName;
        String tvRating = record.tvRating;
        String genre = record.genre;
        String titleId = record.titleId;
        String yearMade = record.yearMade;
        String score = record.score;

        return titleName.toLowerCase() + "," + tvRating + "," + genre + "," + titleId + "," + yearMade + "," + score + "\n";
    }

}
