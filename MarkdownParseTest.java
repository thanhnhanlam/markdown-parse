import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(5, 3 + 2);
    }

    @Test
    public void firstFile() throws IOException {
        ArrayList<String> links = new ArrayList<String>();

        links.add("https://something.com");
        links.add("some-thing.html");

        String content = Files.readString(Path.of("test-file.md"));

        ArrayList<String> parsedLinks = MarkdownParse.getLinks(content);
        
        assertEquals(parsedLinks, links);
    }

    @Test
    public void secondFile() throws IOException {
        
        ArrayList<String> links = new ArrayList<String>();

        links.add("https://something.com");
        links.add("This part breaks the program! How do we fix this?");
        links.add("some-thing.html");

        String content = Files.readString(Path.of("test-file2.md"));
        
        ArrayList<String> parsedLinks = MarkdownParse.getLinks(content);
        
        assertEquals(parsedLinks, links);
    }
}