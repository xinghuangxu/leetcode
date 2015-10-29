package hackerrank;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Xinghuang Leon Xu on 10/10/2015.
 */
public class TwoStringsGameSAMTest extends TestCase {

    @Test
    public void test1() throws IOException {
        TwoStringsGameSAM twoStringsGameSAM = new TwoStringsGameSAM();
        twoStringsGameSAM.main(2, 2, 5L, "ab", "cd");
    }

    @Test
    public void test2() throws IOException {
        URL inputFileResource = getClass().
                getResource("/input00.txt");
        URL outputFileResource = getClass().
                getResource("/output00.txt");
        try {
            Path outputFilePath = Paths.get(outputFileResource.toURI());
            Path inputFilePath = Paths.get(inputFileResource.toURI());
            FileInputStream outputStream = new FileInputStream(String.valueOf(outputFilePath));
            BufferedReader outputBr = new BufferedReader(new InputStreamReader(outputStream));

            FileInputStream inputStream = new FileInputStream(String.valueOf(inputFilePath));
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String strLine;
            String tmp = br.readLine();
            Integer n = Integer.parseInt((tmp.split(" "))[0]);
            Integer m = Integer.parseInt((tmp.split(" "))[1]);
            Long k = Long.parseLong((tmp.split(" "))[2]);
            TwoStringsGameSAM twoStringsGameSAM = new TwoStringsGameSAM();
            twoStringsGameSAM.main(n, m, k, br.readLine(), br.readLine());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}