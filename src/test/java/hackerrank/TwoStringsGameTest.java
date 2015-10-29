package hackerrank;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Xinghuang Leon Xu on 10/10/2015.
 */
public class TwoStringsGameTest extends TestCase {

    @Test
    public void test1() throws IOException {
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
            int k = Integer.parseInt((tmp.split(" "))[2]);
            TwoStringsGame twoStringsGame = new TwoStringsGame(br.readLine(),br.readLine());
            assertEquals(outputBr.readLine()+","+outputBr.readLine(), twoStringsGame.findMinimumDecision(k));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}