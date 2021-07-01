package NetflixProject.AppOperations;

import NetflixProject.ProfileManagement.Profile;
import NetflixProject.Record;

import java.util.List;

public interface AppOperations {
    void startOperations();
    void swipeThroughTitles();
    List<Record> compareLikedLists(Profile thatProfile);
    void showRecordList(List<Record> recordList);
}
