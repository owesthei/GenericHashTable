public class App {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("a", 1);
        hashTable.put("b", 2);
        hashTable.put("c", 3);
        hashTable.put("d", 4);
        hashTable.put("e", 5);
        hashTable.put("f", 6);
        hashTable.put("g", 7);
        hashTable.put("h", 8);
        hashTable.put("i", 9);
        hashTable.put("j", 10);
        hashTable.put("k", 11);
        hashTable.put("l", 12);
        hashTable.put("m", 13);
        hashTable.put("n", 14);
        hashTable.put("o", 15);
        hashTable.put("p", 16);
        hashTable.put("q", 17);
        hashTable.put("r", 18);
        hashTable.put("s", 19);
        hashTable.put("t", 20);
        hashTable.put("u", 21);
        hashTable.put("v", 22);
        hashTable.put("w", 23);
        hashTable.put("x", 24);
        hashTable.put("y", 25);
        hashTable.put("z", 26);

        hashTable.remove("a");
        hashTable.remove("b");
        hashTable.remove("c");
        hashTable.remove("d");
        hashTable.remove("e");
        hashTable.remove("f");
        hashTable.remove("g");
        hashTable.remove("h");
        hashTable.remove("i");
        hashTable.remove("j");
        hashTable.remove("k");
        hashTable.remove("l");
        hashTable.remove("m");
        hashTable.remove("n");
        hashTable.remove("o");
        hashTable.remove("p");
        hashTable.remove("q");
        hashTable.remove("r");
        hashTable.remove("s");
        hashTable.remove("t");
        hashTable.remove("u");
        hashTable.remove("v");
        hashTable.remove("w");

        System.out.println(hashTable.get("x"));
        System.out.println(hashTable.get("y"));
        System.out.println(hashTable.get("z"));

        System.out.println(hashTable.get("ubuntu"));
    }
}