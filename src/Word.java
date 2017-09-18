public class Word {


    /*
    *
    *   {
    "id": 142,
    "name": "FINKEN",
    "categoryId": 1,
    "languageId": 3
  },
    * */

    long id;
    String name;
    int categoryId;
    int languageId;

    enum LANGUAGES{
        EN,ES,DE,FR,IT,PT,JA,PL,RU,TR
    }

    public Word(long id, String name, String fileName) {
        this.id = id;
        this.name = name;
        setLanguageId(fileName);
        setCategoryId(fileName);
    }


    private void setLanguageId(String fileName){

        /*[{"id":1,"name":"en"},{"id":2,"name":"es"},{"id":3,"name":"de"},{"id":4,"name":"fr"},{"id":5,"name":"it"},{"id":6,"name":"pt"},{"id":7,"name":"ja"},{"id":8,"name":"pl"},{"id":9,"name":"ru"},{"id":10,"name":"tr"}]*/

        if(fileName.endsWith("eng.txt")){
            languageId=1;
        }
        else if(fileName.endsWith("esp.txt")){
            languageId=2;
        }
        else if(fileName.endsWith("fra.txt")){
            languageId=4;
        }
        else if(fileName.endsWith("ger.txt")){
            languageId=3;
        }
        else if(fileName.endsWith("ita.txt")){
            languageId=5;
        }
        else if(fileName.endsWith("jap.txt")){
            languageId=7;
        }
        else if(fileName.endsWith("pol.txt")){
            languageId=8;
        }
        else if(fileName.endsWith("por.txt")){
            languageId=6;
        }
        else if(fileName.endsWith("rus.txt")){
            languageId=9;
        }
        else if(fileName.endsWith("tur.txt")){
            languageId=10;
        }
        else{
            languageId = 1;
            System.out.println("WTF:"+fileName);
        }
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
