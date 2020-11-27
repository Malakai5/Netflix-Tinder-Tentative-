import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Singleton x = Singleton.getInstance();
        System.out.println(x.AllRecords.get(22).tvRating);


    }
}
// TODO Call readCSV, print out the list
// TODO Delete things in the list
// TODO Write the list to a file