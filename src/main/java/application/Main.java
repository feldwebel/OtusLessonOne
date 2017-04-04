package application;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Main {
    private static final String FILE_CSV = "Sacramentorealestatetransactions.csv";

    public static void main(String[] args) {
        System.out.println("TEST");
        Main app = new Main();

        Filter gtFilter = (CSVRecord record, String column, int size) ->
        {
            return
                    Integer.parseInt(record.get(column)) > size
                            ? Integer.parseInt(record.get("price"))
                            : 0;
        };

        try {
            app.read(gtFilter);
        } catch (Exception ex) {
            System.err.println("SOMETHING WRONG");
        }
    }

    public void read(Filter filter) throws IOException, ParseException
    {
        int totalResult = 0;
        int result = 0;
        ClassLoader classLoader = this.getClass().getClassLoader();
        Reader in = new FileReader(classLoader.getResource(FILE_CSV).getFile());
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
        for (CSVRecord record : records) {
            totalResult += Integer.parseInt(record.get("price"));
            result += filter.check(record, "sq__ft", 1000);
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Totally: " + nf.format(totalResult));
        System.out.println("Large: " + nf.format(result));
    }

    interface Filter {
        int check(CSVRecord record, String column, int size);
    }
}
