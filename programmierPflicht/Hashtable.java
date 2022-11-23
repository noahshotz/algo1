package programmierPflicht;

import java.util.LinkedList;

public class Hashtable implements IntStringMap {

    // length of hashtable & mod-factor
    public int k;

    public Hashtable() {
        k = 5;
    }

    // array of linkedlists with length k
    @SuppressWarnings({ "unchecked" })

    // absoluten wert noch variable aus constructor ersetzen
    LinkedList<String>[] testListe = new LinkedList[5];

    public int innerIndex = 0;

    // put method
    public String put(Integer key, String value) {
        // Key soll per Hashfunktion als Index festgelegt werden
        // Protoyp: int hashFunction(Integer key)
        // code extern

        if (testListe[key] == null) {
            System.out.println("");
            System.out.println("Key: " + key + " - add value: " + value + " at index " + innerIndex);
            testListe[key] = new LinkedList<>();
            testListe[key].add(innerIndex, value);
        } else {
            System.out.println("");
            System.out.println("Current innerIndex: " + innerIndex);
            System.out.println("LinkedList for key " + key + " already exists, insert value: " + value + " at index " + innerIndex);
            testListe[key].add(innerIndex, value);
            innerIndex = innerIndex + 1;
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