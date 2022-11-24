package programmierPflicht;

import java.util.LinkedList;

public class Hashtable implements IntStringMap {

    // length of hashtable & mod-factor
    public static int k;

    // constructor
    public Hashtable() {
        k = 11;
    }

    // hash Funktion mit Divisionsrestmethode
    // nur absolute keys erzwingen
    public static int hashCode(Integer key, int k) {
        int hashedKey = Math.abs(key % k);
        return hashedKey;
    }

    // array of linkedlists with length k
    @SuppressWarnings({ "unchecked" })
    // absoluten wert noch variable aus constructor ersetzen
    LinkedList<String>[] testListe = new LinkedList[11];

    // put method
    public String put(Integer key, String value) {

        System.out.println("------------");
        int hashedKey = hashCode(key, k);
        System.out.println("hashedKey: " + hashedKey);

        // Wenn man gehashten Index des Arrays noch keine LinkedList
        // existiert soll eine neue erstellt werden
        if (testListe[hashedKey] == null) {
            System.out.println("Key: " + hashedKey + " - add value: " + value);
            testListe[hashedKey] = new LinkedList<>();
            testListe[hashedKey].addLast(value);
        } else {
            System.out.println("LinkedList for key " + hashedKey + " already exists, insert value: " + value);
            testListe[hashedKey].addLast(value);
        }
        System.out.println(testListe[hashedKey] + "\n");

        return null;
    }

    public String get(Integer key) {

        int hashedKey = hashCode(key, k);

        System.out.println("------------");
        System.out.println("hashedKey:" + hashedKey);
        System.out.println(
            "LinkedList für key " + 
            hashedKey + ": " + 
            testListe[hashedKey]);
        System.out.println(
            "Letztes Element für key " + hashedKey + ": " + 
            testListe[hashedKey].getLast() 
            + "\n");

        return null;
    }

    public String remove(Integer key) {
        return null;
    }
}