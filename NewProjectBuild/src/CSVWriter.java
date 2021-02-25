import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter extends Converter {

    public void writeCSV(String fileName, List<Record> recordList){
        try (PrintWriter br = new PrintWriter( new FileWriter(fileName))) {
            String headers;
            headers = "TitleName,YearMade,Genre,TvRating,TitleId,Score \n";
            br.write(headers);

            for (int i = 0;i < recordList.size();i++){
                if (i != 0) {
                    Record record = new Record();
                    br.write(recordToString(record));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String CSVtoString(){


     return null;
    }
}
