package pl.edu.agh.hangman;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class ReadTextFromInternet {

    String path;

    public ReadTextFromInternet(String path) {
        this.path = path;
    }

    public String readFile () {

        try {
            Connection connect = Jsoup.connect(path);
            Document document = connect.get();
            Element header = document.selectFirst("h1");
            String word = header.text();
            if (word.contains(" ") || word.contains("-")) {
                return readFile();
            }
            return word;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
