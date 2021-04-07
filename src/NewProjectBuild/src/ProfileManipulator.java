public class ProfileManipulator extends CSVWriter{


    protected void assignCSVs(Profile profile){
        startRecordCSVPage(createUndecidedCsv(profile.userName));
        startRecordCSVPage(createDislikedCsv(profile.userName));
        startRecordCSVPage(createLikedCsv(profile.userName));
    }


    private String createUndecidedCsv(String userName) {
        String csvTag = ".csv";
        return userName.toLowerCase() + "'s Undecided Titles" + csvTag;
    }
    private String createLikedCsv(String userName) {
        String csvTag = ".csv";
        return userName.toLowerCase() + "'s Liked Titles" + csvTag;
    }
    private String createDislikedCsv(String userName) {
        String csvTag = ".csv";
        return userName.toLowerCase() + "'s Disliked Titles" + csvTag;
    }
}
