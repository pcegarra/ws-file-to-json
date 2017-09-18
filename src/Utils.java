public class Utils {

    public static int getLanguageIdFromFileName(String fileName){

        if(fileName.endsWith("eng.txt")){
            return 1;
        }
        else if(fileName.endsWith("esp.txt")){
            return 2;
        }
        else if(fileName.endsWith("fra.txt")){
            return 4;
        }
        else if(fileName.endsWith("ger.txt")){
            return 3;
        }
        else if(fileName.endsWith("ita.txt")){
            return 5;
        }
        else if(fileName.endsWith("jap.txt")){
            return 7;
        }
        else if(fileName.endsWith("pol.txt")){
            return 8;
        }
        else if(fileName.endsWith("por.txt")){
            return 6;
        }
        else if(fileName.endsWith("rus.txt")){
            return 9;
        }
        else if(fileName.endsWith("tur.txt")){
            return 10;
        }
        else{
            return -1;
        }
    }

}
