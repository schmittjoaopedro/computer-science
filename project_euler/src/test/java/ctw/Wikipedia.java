package ctw;

import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wikipedia {

    private static final String WIKIPEDIA_URL = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=";

    /**
     *
     *
     */
    private static String getWikipediaTopicContent(String topic) throws IOException {
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        return JsonParser.parseString(response.toString()).getAsJsonObject()
                .getAsJsonObject("parse")
                .getAsJsonObject("text")
                .get("*")
                .getAsString();
    }

    /**
     *
     *
     */
    private static int getNumberOfOccurrences(String response, String topic) {
        int count = 0;
        int lastIndex = 0;
        while (true) {
            lastIndex = response.indexOf(topic, lastIndex + topic.length());
            if (lastIndex == -1) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    static int getTopicCount(String topic) {
        try {
            String response = getWikipediaTopicContent(topic);
            return getNumberOfOccurrences(response, topic);
        } catch (IOException ioe) {
            throw new RuntimeException("Error calling wikipedia API", ioe);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getTopicCount("pizza"));
    }

    static class WikipediaTopic {

        private WikipediaParser parse;

        public WikipediaTopic(WikipediaParser parser) {
            this.parse = parser;
        }

        public WikipediaParser getParse() {
            return parse;
        }
    }

    static class WikipediaParser {

        private String title;

        private Long pageid;

        private String text;

        public WikipediaParser(String title, Long pageid, String text) {
            this.title = title;
            this.pageid = pageid;
            this.text = text;
        }

        public String getTitle() {
            return title;
        }

        public Long getPageid() {
            return pageid;
        }

        public String getText() {
            return text;
        }
    }

}
