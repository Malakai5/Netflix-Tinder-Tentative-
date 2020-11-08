import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Singleton { // Used to read CSV file on initiation and never need to read it again.
    private static final String COMMA_DELIMITER =",";

    private static Singleton single_instance = null;
    public List<List<String>> read;
    List<String> temp;

    // Should split the request ArrayList into individual arrays.
    private List<String> getRead(List<List<String>> records){ //Returning a runtime error ## Ask bars for help later.
        for (int i = 0;i < records.size();i++){//Should return every array in records as in individual array
            temp.set(i, Arrays.toString(records.get(i).toArray()));
        }
        return temp;
    }

    private Singleton() {//Singleton file to set Variable read equal to The CSV file
        String file = "Netflix database-CSV.csv";
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) { //Reads the Csv file

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        read.add(getRead(records));//Should add the results of records into an arrayList called read
    }

    public static Singleton getInstance() {

        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
    }
