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

public class Word {



    long id;
    String name;
    int categoryId;
    int languageId;

    public static void createFile() throws IOException {
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

        JSONArray jsonArray = new JSONArray();

        for(Word word: words){
            JSONObject obj = new JSONObject();
            obj.put("id", word.id);
            obj.put("name", word.name);
            obj.put("category", word.categoryId);
            obj.put("language", word.languageId);
            jsonArray.add(obj);
        }

        try (FileWriter file = new FileWriter("/Users/pablopumpun/Desktop/words.json")) {
            file.write(jsonArray.toJSONString());
            System.out.println("Successfully created words.json");
        }

    }


    enum LANGUAGES{
        EN,ES,DE,FR,IT,PT,JA,PL,RU,TR
    }

    public Word(long id, String name, String fileName) {
        this.id = id;
        this.name = name;
        this.languageId = Utils.getLanguageIdFromFileName(fileName);
        setCategoryId(fileName);
    }

    private void setCategoryId(String fileName){

        if(fileName.startsWith("alimentos")){
            categoryId = getIdLangCat();
        }
        else if(fileName.startsWith("animales")){
            categoryId = getIdLangCat()+1;
        }
        else if(fileName.startsWith("ciencia")){
            categoryId = getIdLangCat()+3;
        }
        else if(fileName.startsWith("ciudades")){
            categoryId = getIdLangCat()+2;
        }
        else if(fileName.startsWith("colores")){
            categoryId = getIdLangCat()+4;
        }
        else if(fileName.startsWith("deportes")){
            categoryId = getIdLangCat()+5;
        }
        else if(fileName.startsWith("espacio")){
            categoryId = getIdLangCat()+8;
        }
        else if(fileName.startsWith("geografia")){
            categoryId = getIdLangCat()+9;
        }
        else if(fileName.startsWith("hogar")){
            categoryId = getIdLangCat()+11;
        }
        else if(fileName.startsWith("musica")){
            categoryId = getIdLangCat()+14;
        }
        else if(fileName.startsWith("naturaleza")){
            categoryId = getIdLangCat()+12;
        }
        else if(fileName.startsWith("nombres")){
            categoryId = getIdLangCat()+13;
        }
        else if(fileName.startsWith("peliculas")){
            categoryId = getIdLangCat()+17;
        }
        else if(fileName.startsWith("pintores")){
            categoryId = getIdLangCat()+18;
        }
        else if(fileName.startsWith("profesiones")){
            categoryId = getIdLangCat()+19;
        }
        else if(fileName.startsWith("ropa")){
            categoryId = getIdLangCat()+15;
        }
        else if(fileName.startsWith("sentimientos")){
            categoryId = getIdLangCat()+6;
        }
        else if(fileName.startsWith("transporte")){
            categoryId = getIdLangCat()+10;
        }
    }

    private int getIdLangCat(){
        LANGUAGES currentLang =  LANGUAGES.values()[languageId-1];
        if(currentLang==LANGUAGES.EN){
            return 100;
        }
        else if(currentLang==LANGUAGES.ES){
            return 200;
        }
        else if(currentLang==LANGUAGES.DE){
            return 300;
        }
        else if(currentLang==LANGUAGES.FR){
            return 400;
        }
        else if(currentLang==LANGUAGES.IT){
            return 500;
        }
        else if(currentLang==LANGUAGES.PT){
            return 600;
        }
        else if(currentLang==LANGUAGES.JA){
            return 700;
        }
        else if(currentLang==LANGUAGES.PL){
            return 800;
        }
        else if(currentLang==LANGUAGES.RU){
            return 900;
        }
        else if(currentLang==LANGUAGES.TR){
            return 1000;
        }
        else return -1;

    }
}
