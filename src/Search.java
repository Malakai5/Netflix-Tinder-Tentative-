//import java.util.List;
//
//public class Search {
//    CSVreader search = new CSVreader();
//
//
//    public void getTitleInfo(int titleId){
//        List<List<String>> data = search.readCSV();
//
//        System.out.println(data.get(titleId));
//    }
//
//    public void getGenreList(String genre) {// sort out the genre Lists
//        List<List<String>> data = search.readCSV();
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).contains(genre)) {
//                System.out.println(data.get(i));
//            }
//        }
//    }
//
//    public void getTvRatingList(String tvRating) {//Sort out the rvRatingLists
//        List<List<String>> data = search.readCSV();
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).contains(tvRating)) {
//                System.out.println(data.get(i));
//            }
//        }
//    }
//
//    //Not Finished, returns Exception errors
//    public void getYearMadeList(int start, int end) {
//        List<List<String>> data = search.readCSV();
//        for (int i = 0; i < data.size(); i++) {
//            int number = Integer.parseInt(data.get(i).toString());
//            if (number >= start & number <= end) {
//                System.out.println(data.get(i));
//            }
//        }
//    }
//}