import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Sayings {

    long id;
    String value;
    int languageId;

    public Sayings(long id, String value, String filename) {
        this.id = id;
        this.value = value;
        this.languageId = Utils.getLanguageIdFromFileName(filename);
    }

    public static void createFile() throws IOException {
        List<File> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get("/Users/pablopumpun/Desktop/sayings"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> files.add(new File(path.toUri())));
        }

        List<Sayings> sayings = new ArrayList<>();
        int idCounter = 0;

        for (File f:files) {
            Scanner in = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            while(in.hasNext()) {
                idCounter++;
                sayings.add(new Sayings(idCounter,in.next(),f.getName()));
            }
            in.close();
        }

        JSONArray jsonArray = new JSONArray();

        for(Sayings saying: sayings){
            JSONObject obj = new JSONObject();
            obj.put("id", saying.id);
            obj.put("value", saying.value);
            obj.put("language", saying.languageId);
            jsonArray.add(obj);
        }

        try (FileWriter file = new FileWriter("/Users/pablopumpun/Desktop/sayings.json")) {
            file.write(jsonArray.toJSONString());
            System.out.println("Successfully created sayings.json");
        }
    }
}
