package my;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;

import java.io.File;
import java.io.FileInputStream;

public class TikaTest {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("fileDetector/data/website_2.xlsx"));

        Tika tika = new Tika();
        Metadata metadata = new Metadata();

        String s = tika.parseToString(fis, metadata);
        System.out.println(s);
    }

}
