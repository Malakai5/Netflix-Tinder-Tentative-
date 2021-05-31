import java.util.List;

public class Singleton implements CSVUser{ // Used to read CSV file on initiation and never need to read it again.
    private static Singleton single_instance = null;
    List<Profile> profileList;
    List<Record> originalRecordList;
    Profile profile;


    public Singleton(){
        this.profileList = csvReader.readProfileCSV();
        this.originalRecordList = csvReader.readCSV("Netflix(Original!!).csv");
        this.profile = new Profile();
    }


    public static Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
}