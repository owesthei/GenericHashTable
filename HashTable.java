public class HashTable<K, V> {
    private K[] keys;
    private V[] values;
    private int nItems;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashTable() {
        keys = (K[])new Object[Constants.TABLE_SIZE];
        values = (V[])new Object[Constants.TABLE_SIZE];

        capacity = Constants.TABLE_SIZE;
        nItems = 0; 
    }

    @SuppressWarnings("unchecked")
    private HashTable(int newCapacity) {
        keys = (K[])new Object[newCapacity];
        values = (V[])new Object[newCapacity];
    
        capacity = newCapacity;
        nItems = 0; 
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int index = hash(key);

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }

            index = (index + 1) % capacity;
        }

        return null;
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            return;
        }

        if (nItems >= (capacity * Constants.LOAD_FACTOR_THRESHOLD)) {
            resize(2 * capacity);
        }
    
        int index = hash(key);

        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }

            index = (index + 1) % capacity;
        }

        keys[index] = key;
        values[index] = value;

        nItems++;
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }

        int index = hash(key);

        while (!keys[index].equals(key) && keys[index] != null) {
            index = (index + 1) % capacity;
        }

        if (keys[index].equals(key)) {
            keys[index] = null;
            values[index] = null;

            nItems--;

            index = (index + 1) % capacity;

            while (keys[index] != null) {
                K tmpKey = keys[index];
                V tmpValue = values[index];

                keys[index] = null;
                values[index] = null;

                nItems--;

                put(tmpKey, tmpValue);

                index = (index + 1) % capacity;
            }

            if (nItems <= capacity / 3) {
                resize(capacity / 2);
            }
        }
    }

    private void resize(int newCapacity) {
        System.out.println("Resizing table: " + newCapacity);

        HashTable<K, V> newHashTable = new HashTable<>(newCapacity);

        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                newHashTable.put(keys[i], values[i]);
            }
        }

        keys = newHashTable.keys;
        values = newHashTable.values;
        capacity = newHashTable.capacity;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public int size() {
        return nItems;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}