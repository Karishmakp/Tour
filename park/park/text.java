import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        String url = "https://example.com";

        try {
            // Fetch the HTML content from the webpage
            Document document = Jsoup.connect(url).get();

            // Print the title of the webpage
            String title = document.title();
            System.out.println("Title: " + title);

            // Select specific elements from the webpage
            Elements headings = document.select("h1, h2, h3");
            for (Element heading : headings) {
                System.out.println("Heading: " + heading.text());
            }

            // Select links and print their href attribute
            Elements links = document.select("a[href]");
            for (Element link : links) {
                System.out.println("Link: " + link.attr("href") + " Text: " + link.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}