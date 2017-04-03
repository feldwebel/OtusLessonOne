package application;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        System.out.println("TEST");
        Main app = new Main();
        try {
            app.read();
        } catch (IOException ex) {
            System.err.println("NOTHING FOUND");
        }
    }

    public void read() throws IOException
    {
        int result = 0;
        ClassLoader classLoader = this.getClass().getClassLoader();
        Reader in = new FileReader(classLoader.getResource("Sacramentorealestatetransactions.csv").getFile());
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
        for (CSVRecord record : records) {
            result += Integer.parseInt(record.get("price"));
        }
        System.out.println(result);
    }
}
