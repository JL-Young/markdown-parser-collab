import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.beans.Transient;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Commands for running test in terminal:
 * javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
 * java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
 */
import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void subtraction2(){
        assertEquals(3, 4- 1);
    }

    @Test
    public void getLinksTest() throws IOException {
        boolean result = false;
        Path fileName = Path.of("testFile.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        if (links.contains("https://something.com") && 
            links.contains("some-thing.html")) {
                result = true;
            }

        assertTrue(result);
    }

    @Test
    public void testFile() throws IOException {
        boolean result = false;
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        if (links.contains("https://something.com") && 
            links.contains("some-thing.html")) {
                result = true;
            }

        assertTrue(result);
    }

    @Test
    public void testFile9() throws IOException {
        boolean result = false;
        Path fileName = Path.of("test-file9.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);

        // returned array should be empty as there are no links in the file
        if (links.size() == 0) {
                result = true;
        }

        assertTrue(result);
    }
}