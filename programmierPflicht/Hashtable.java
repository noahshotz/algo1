package programmierPflicht;

import java.util.LinkedList;

public class Hashtable implements IntStringMap {

    // length of hashtable & mod-factor
    public static int k;

    // constructor
    public Hashtable() {
        k = 5;
    }

    // hash Funktion mit Divisionsrestmethode
    // -> negative keys verhindern
    public static int hashCode(Integer key, int k) {
        int hashedKey = Math.abs(key % k);
        return hashedKey;
    }

    // array of linkedlists with length k
    @SuppressWarnings({ "unchecked" })
    // absoluten wert noch variable aus constructor ersetzen
    LinkedList<String>[] testListe = new LinkedList[5];

    public int innerIndex = 0;

    // put method
    public String put(Integer key, String value) {
        System.out.println("------------");
        int hashedKey = hashCode(key, k);
        System.out.println("hashedKey:" + hashedKey);

        // Wenn man gehashten Index des Arrays noch keine LinkedList
        // existiert soll eine neue erstellt werden
        if (testListe[hashedKey] == null) {
            System.out.println("Key: " + hashedKey + " - add value: " + value + " at position " + innerIndex);
            testListe[hashedKey] = new LinkedList<>();
            testListe[hashedKey].add(innerIndex, value);
        } else {
            System.out.println("Current innerIndex: " + innerIndex);
            System.out.println("LinkedList for key " + hashedKey + " already exists, insert value: " + value
                    + " at position " + innerIndex);
            testListe[hashedKey].add(innerIndex, value);
            innerIndex = innerIndex + 1;
        }
        System.out.println(testListe[hashedKey]);
        System.out.println("");

        return null;
    }

    public String get(Integer key) {

        int hashedKey = hashCode(key, k);

        System.out.println("------------");
        System.out.println("hashedKey:" + hashedKey);
        System.out.println("LinkedList für key " + hashedKey + ": " + testListe[hashedKey]);
        System.out.println("Letztes Element für key " + hashedKey + ": " + testListe[hashedKey].getLast());
        System.out.println("");

        return null;
    }

    public String remove(Integer key) {
        return null;
    }
}