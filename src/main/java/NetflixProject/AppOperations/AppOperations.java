package NetflixProject.AppOperations;

import NetflixProject.Record;

import java.util.List;

public interface AppOperations {
    void startOperations();
    void swipeThroughTitles();
    void compareLikedLists();
    void showRecordList(List<Record> recordList);
}
