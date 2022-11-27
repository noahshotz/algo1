package programmierPflicht;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Hashtable implements IntStringMap {

    // k sets length of hashtable and mod factor
    public static int k;

    // constructor
    public Hashtable() {
        k = 11;
    }

    // hash keys using mod function
    public static int hashCode(Integer key, int k) {
        int hashedKey = Math.abs(key % k);
        return hashedKey;
    }

    // helper to pretty-print hashtable
    public void returnHashtable() {

        String returnHashtable = "";

        for (int i = 0; i < hashtable.length; i++) {
            returnHashtable += "Index " + i + ": " + hashtable[i] + "\n";
        }
        System.out.println("---------------");
        System.out.println(returnHashtable);
        System.out.println("---------------");
    }

    // store key-value-pairs in linkedlist
    class KeyValuePair {
        public static KeyValuePair newEntry;
        public static Entry<Integer, String> newEntry(Integer key, String value) {
            Map.Entry<Integer, String> newEntry = new AbstractMap.SimpleEntry<Integer, String>(key, value);
            return newEntry;
        }
    }

    // array of LinkedLists with length k
    @SuppressWarnings({ "unchecked" })
    // Hartgecodeden Wert mit Variable aus Konstruktor ersetzen
    public LinkedList<Entry<Integer, String>>[] hashtable = new LinkedList[11];

    // put-method
    public String put(Integer key, String value) {

        // apply hash function on key
        int hashedKey = hashCode(key, k);

        // create new linkedlist if none exists at index
        // index = hashed key
        boolean keyExists = false;
        if (hashtable[hashedKey] == null) {
            hashtable[hashedKey] = new LinkedList<Entry<Integer, String>>();
            hashtable[hashedKey].addLast(KeyValuePair.newEntry(key, value));
        } else {
            // overwrite value if keys are duplicate
            for (int i = 0; i < hashtable[hashedKey].size(); i++) {
                if (hashtable[hashedKey].get(i).getKey() == key) {
                    keyExists = true;
                    // store removed value
                    String removedValue = hashtable[hashedKey].get(i).getValue();
                    hashtable[hashedKey].set(
                        // entry position
                        i,
                        // entry value
                        KeyValuePair.newEntry(key, value));
                    return removedValue;
                }
            }
            // add key & value if key does not exist yet
            if (!keyExists) {
                hashtable[hashedKey].addLast(KeyValuePair.newEntry(key, value));
            }
        }
        return null;
    }

    // get-method
    public String get(Integer key) {
        int hashedKey = hashCode(key, k);
        String getValue = null;
        for(int i = 0; i < hashtable[hashedKey].size(); i++) {
            if (hashtable[hashedKey].get(i).getKey() == key) {
                getValue = hashtable[hashedKey].get(i).getValue();
            }
        };
        if (getValue == null) {
            return null;
        } else {
            System.out.println("Matching value for key " + key + ": " + getValue + "\n");
            return getValue;
        }
    }

    // remove-method
    public String remove(Integer key) {
        int hashedKey = hashCode(key, k);
        String removedValue = null;
        for(int i = 0; i < hashtable[hashedKey].size(); i++) {
            if (hashtable[hashedKey].get(i).getKey() == key) {
                removedValue = hashtable[hashedKey].get(i).getValue();
                hashtable[hashedKey].remove(i);
            }
        };
        if (removedValue == null) {
            return null;
        } else {
            System.out.println("Removed value for " + key + ": " + removedValue);
            return removedValue;
        }
    }
}