package programmierPflicht;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Hashtable implements IntStringMap {

    // Länge der Hashtabelle und hash-Faktor
    public static int k;

    // Konstruktor
    public Hashtable() {
        k = 11;
    }

    // Hashfunktion mit Divisionsrestmethode
    // positive Keys erzwingen
    public static int hashCode(Integer key, int k) {
        int hashedKey = Math.abs(key % k);
        return hashedKey;
    }

    // Hashtable kosmetisch aufbereitet ausgeben
    public void returnHashtable() {

        String returnHashtable = "";

        for (int i = 0; i < hashtable.length; i++) {
            returnHashtable += "Index " + i + ": " + hashtable[i] + "\n";
        }
        System.out.println("---------------");
        System.out.println(returnHashtable);
        System.out.println("---------------");
    }

    class KeyValuePair {
        public static KeyValuePair newEntry;

        public static Entry<Integer, String> newEntry(Integer key, String value) {
            Map.Entry<Integer, String> newEntry = new AbstractMap.SimpleEntry<Integer, String>(key, value);

            return newEntry;
        }
    }

    // Array von LinkedLists mit Länge k
    @SuppressWarnings({ "unchecked" })
    // Hartgecodeden Wert mit Variable aus Konstruktor ersetzen
    public LinkedList<Entry<Integer, String>>[] hashtable = new LinkedList[11];

    // Put-Methode
    public String put(Integer key, String value) {

        System.out.println("---------------");
        // Hashfunktion auf Key anwenden
        int hashedKey = hashCode(key, k);
        System.out.println("hashedKey: " + hashedKey);

        // Wenn am gehashten Index des Arrays noch keine LinkedList
        // existiert soll eine neue erstellt werden
        boolean keyExists = false;
        if (hashtable[hashedKey] == null) {
            System.out.println("Key: " + hashedKey + " - add value: " + value);
            hashtable[hashedKey] = new LinkedList<Entry<Integer, String>>();
            hashtable[hashedKey].addLast(KeyValuePair.newEntry(key, value));
        } else {
            for (int i = 0; i < hashtable[hashedKey].size(); i++) {
                if (hashtable[hashedKey].get(i).getKey() == key) {
                    keyExists = true;
                    System.out.println("existing value " + hashtable[hashedKey].get(i).getValue() + " has to be replaced by value: " + value);
                    hashtable[hashedKey].set(
                        // entry position
                        0,
                        // entry value
                        KeyValuePair.newEntry(key, value));
                }
            }
            if (!keyExists) {
                hashtable[hashedKey].addLast(KeyValuePair.newEntry(key, value));
            }
        }
        System.out.println(hashtable[hashedKey] + "\n");


        return null;
    }

    // Get-Methode
    public String get(Integer key) {

        int hashedKey = hashCode(key, k);

        System.out.println("---------------");
        System.out.println("hashedKey:" + hashedKey);
        System.out.println(
                "LinkedList für hashedKey " +
                        hashedKey + ": " +
                        hashtable[hashedKey]);
        System.out.println(
                "Letztes Element für hashedKey " + hashedKey + ": " +
                        hashtable[hashedKey].getLast()
                        + "\n");

        return null;
    }

    // Remove-Methode
    public String remove(Integer key) {
        return null;
    }

}