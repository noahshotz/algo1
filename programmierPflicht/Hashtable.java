package programmierPflicht;

import java.util.LinkedList;

public class Hashtable implements IntStringMap {

    // length of hashtable & mod-factor
    int k;

    public Hashtable() {
        k = 5;
    }

    // array of linkedlists with length k
    @SuppressWarnings({ "unchecked" })

    LinkedList<String>[] testListe = new LinkedList[5];

    // put method
    public String put(Integer key, String value) {
        // Key soll per Hashfunktion als Index festgelegt werden
        // Protoyp: int hashFunction(Integer key)
        // code extern

        int innerIndex = 0;

        if (testListe[key] == null) {
            System.out.println("Key: " + key + ", add value: " + value);
            testListe[key] = new LinkedList<>();
            testListe[key].add(innerIndex, value);
        } else {
            System.out.println("linkedlist at key " + key + " already exists, insert value: " + value);
            innerIndex++;
            testListe[key].add(innerIndex, value);
        }

        System.out.println(testListe[key]);

        return null;
    }

    public String get(Integer key) {        

        return null;
    }

    public String remove(Integer key) {
        return null;
    }
}