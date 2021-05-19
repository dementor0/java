import java.util.Scanner;
public class Rehashing_random {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable_random hashTable = new HashTable_random(128);
        hashTable.insert("rhino");
        hashTable.insert("man");
        hashTable.insert("computer");
        hashTable.insert("home");
        hashTable.insert("basket");
        hashTable.print();
        String word = scanner.nextLine();
        Item item = hashTable.find(word);
        if (item != null)
            System.out.println("Элемент найден, его хэш: " + hashTable.hash_random(word));
        else
            System.out.println("Элемент не найден!");
    }
}

