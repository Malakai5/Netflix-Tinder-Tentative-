import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Singleton x = Singleton.getInstance();
        System.out.println(x.AllRecords.size());


    }
}
