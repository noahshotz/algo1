package programmierPflicht;

import java.util.LinkedList;

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

    // Array von LinkedLists mit Länge k
    @SuppressWarnings({ "unchecked" })
    // Hartgecodeden Wert mit Variable aus Konstruktor ersetzen
    public LinkedList<String>[] hashtable = new LinkedList[11];

    // Put-Methode
    public String put(Integer key, String value) {

        System.out.println("---------------");
        // Hashfunktion auf Key anwenden
        int hashedKey = hashCode(key, k);
        System.out.println("hashedKey: " + hashedKey);

        // Wenn am gehashten Index des Arrays noch keine LinkedList
        // existiert soll eine neue erstellt werden
        if (hashtable[hashedKey] == null) {
            System.out.println("Key: " + hashedKey + " - add value: " + value);
            hashtable[hashedKey] = new LinkedList<>();
            hashtable[hashedKey].addLast(value);
        } else {
            System.out.println("LinkedList for key " + hashedKey + " already exists, insert value: " + value);
            hashtable[hashedKey].addLast(value);
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
                "LinkedList für key " +
                        hashedKey + ": " +
                        hashtable[hashedKey]);
        System.out.println(
                "Letztes Element für key " + hashedKey + ": " +
                        hashtable[hashedKey].getLast()
                        + "\n");

        return null;
    }

    // Remove-Methode
    public String remove(Integer key) {
        return null;
    }

}