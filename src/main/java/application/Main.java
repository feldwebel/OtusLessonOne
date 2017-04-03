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
        try {
            app.read();
        } catch (Exception ex) {
            System.err.println("SOMETHING WRONG");
        }
    }

    public void read() throws IOException, ParseException
    {
        int result = 0;
        ClassLoader classLoader = this.getClass().getClassLoader();
        Reader in = new FileReader(classLoader.getResource(FILE_CSV).getFile());
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
        for (CSVRecord record : records) {
            result += Integer.parseInt(record.get("price"));
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Totally: " + nf.format(result));
    }
}
