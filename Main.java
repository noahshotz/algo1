import programmierPflicht.*;

public class Main {
    public static void main(String[] args){
        Hashtable newHashtable = new Hashtable();
        newHashtable.put(0, "10");
        newHashtable.put(1, "12");
        newHashtable.put(2, "14");
        newHashtable.put(3, "15");
        newHashtable.put(4, "17");

        newHashtable.put(0, "15");
        newHashtable.put(2, "20");
        newHashtable.put(2, "25");
        newHashtable.put(2, "30");

    }
}