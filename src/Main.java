import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        CSVreader test = new CSVreader();
        Search search = new Search();

        search.getTitleInfo(132);


        List<List<String>> data;
        data = test.readCSV();

        System.out.println(data.get(1));


    }
}
