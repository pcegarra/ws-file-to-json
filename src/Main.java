import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        final File folder = new File("/Users/pablopumpun/Desktop/words");
        List<File> files = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get("/Users/pablopumpun/Desktop/words"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> files.add(new File(path.toUri())));
        }

        List<Word> words = new ArrayList<>();
        int idCounter = 0;

        for (File f:files) {
            Scanner in = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            while(in.hasNext()) {
                idCounter++;
                words.add(new Word(idCounter,in.next(),f.getName()));
            }
            in.close();
        }

        List<JSONObject> jsonObjects = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();

        for(Word word: words){
            JSONObject obj = new JSONObject();
            obj.put("id", word.id);
            obj.put("name", word.name);
            obj.put("category", word.categoryId);
            obj.put("language", word.languageId);
            jsonArray.add(obj);
            jsonObjects.add(obj);
        }

        try (FileWriter file = new FileWriter("/Users/pablopumpun/Desktop/words.json")) {
            file.write(jsonArray.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
        }

    }



}
