package programmierPflicht;
import java.util.LinkedList;


public class Hashtable implements IntStringMap {

    int HashtableLength;

    public Hashtable() {
        HashtableLength = 5;
    }


    LinkedList<String> testListe = new LinkedList<String>();

	public String put(Integer key, String value) {
        System.out.println("key: " + key);
        System.out.println("value: " + value);

        // Key soll per Hashfunktion als Index festgelegt werden
        // Protoyp: int hashFunction(Integer key)

        testListe.add(key, value);
        System.out.println("Inserted: " + testListe);


		return null;
	}

	public String get(Integer key) {
		return null;
	}

	public String remove(Integer key) {
		return null;
	}
}