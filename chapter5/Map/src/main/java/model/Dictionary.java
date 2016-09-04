package model;

import java.util.*;

/**
 *  Implementation of associate array. It means that this storage store key-value pair.
 */
public class Dictionary<K, V> implements Iterator<V> {

    /**
     * At this place hold all key-value pair.
     */
    private Entry<K, V>[] values;

    /**
     * Size of this dictionary.
     */
    private int size = 0;

    /**
     * For correct moving using iterator.
     */
    private int cursor = 0;

    /**
     * At this place hold all values.
     */
    private List<V> listValues;

    /**
     * Default constructor.
     */
    public Dictionary() {
        this(100);
    }

    /**
     * Create dictionary with given capacity.
     * @param capacity count of storage elements.
     */
    public Dictionary(int capacity) {
        this.values = new Entry[capacity];
        this.listValues = new ArrayList<>();
    }

    /**
     * Insert new key-value pair at the storage.
     * @param key for adding. Notice that is must be unique, otherwise you may loose old value.
     * @param value for adding.
     * @return true if pair was added, otherwise false.
     */
    public boolean insert(K key, V value) {
        boolean inserted = false;
        int hash = hash(key);
        int index = indexFor(hash, this.values.length);
        Entry<K, V> e = this.values[index];
        if(this.needEnsureCapacity()) {
            this.ensureCapacity();
        }
        if ((e == null) || (!this.contains(key))) {
            this.addEntry(hash, key, value, index);
            inserted = true;
        } else if (this.contains(key)) {
            e.value = value;
            inserted = true;
        }
        if (inserted) {
            this.size++;
            this.listValues.add(value);
        }
        return inserted;
    }

    /**
     * Return element from dictionary.
     * @param key unique object for each value in the dictionary.
     * @return if is find at the dictionary return object from dictionary, otherwise false.
     */
    public V get(K key) {
        int hash = hash(key);
        int index = this.indexFor(hash, this.values.length);
        Entry<K, V> node = this.values[index];
        V value = null;
        for (Entry<K, V> current = node; current != null; current = current.next) {
            if (hash == current.hash && current.key.equals(key)) {
                value = current.value;
                break;
            }
        }
        return value;
    }

    /**
     * Check that given key exist dictionary.
     * @param key object for checking.
     * @return true if object exist at the set.
     */
    public boolean contains(K key) {
        int hash = this.hash(key);
        int index = this.indexFor(hash, this.values.length);
        boolean contains = false;
        Entry<K,V> node = this.values[index];
        if(node == null) {
            throw new IllegalStateException("Null key is not valid key");
        }
        if(node.next == null && key != null && key.equals(node.key) && node.hash == hash) {
            contains = true;
        } else {
            Entry<K, V> elem = node;
            while(elem.next != null) {
                if(elem.key != null && elem.key.equals(key) && hash == elem.hash) {
                    contains = true;
                }
                elem = elem.next;
            }
        }
        return contains;
    }

    /**
     * Delete value from dictionary.
     * @param key unique object for each pair, using for find correct value.
     * @return true if object was removed, otherwise false.
     */
    public boolean delete(K key) {
        boolean removed = false;
        int hash = this.hash(key);
        int index = this.indexFor(hash, this.values.length);
        Entry<K, V> node = this.values[index];
        if (node.next == null && hash == node.hash && key.equals(node.key)) {
            listValues.remove(node.value);
            this.values[index] = null;
            this.size--;
            removed = true;
        }
        return removed;
    }

    /**
     * Return count of using element at the dictionary.
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * Return true if at the dictionary have elements yet.
     * @return true if leave elements at the dictionary.
     */
    @Override
    public boolean hasNext() {
        return this.values.length > this.cursor && this.size > 0;
    }

    /**
     * Return value from dictionary.
     * @return value from dictionary.
     */
    @Override
    public V next() {
        return listValues.get(cursor++);
    }

    /**
     * Generate hash for key.
     * @param key object which using as key at the dictionary.
     * @return hash of key.
     */
    private int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }

    /**
     * Calculate index at the array.
     * @param hash of key.
     * @param length of using array.
     * @return position at the array.
     */
    private int indexFor(int hash, int length) {
        return hash & length - 1;
    }

    /**
     * Add entry to the array.
     * @param hash of object.
     * @param key from pair.
     * @param value from pair.
     * @param index at this position will insert key-value pair.
     */
    private void addEntry(int hash, K key, V value, int index) {
        Entry<K, V> e = values[index];
        values[index] = new Entry(hash, key, value, e);
    }

    /**
     * Compute fill over array by 75 per cent.
     * @return true if array fill over 75%, otherwise false.
     */
    private boolean needEnsureCapacity() {
        return this.size > this.values.length * 3 / 4;
    }

    /**
     * Ensure capacity of storage.
     */
    private void ensureCapacity() {
        int newCapacity = (this.values.length * 3 / 2) + 1;
        Entry<K,V>[] newValues = new Entry[newCapacity];
        System.arraycopy(this.values, 0, newValues, 0, this.values.length);
        this.values = newValues;
    }

    /**
     * Bucket for key-value pair.
     * @param <K> key.
     * @param <V> value.
     */
    private class Entry<K, V> implements Map.Entry<K, V> {

        /**
         * Key of object.
         */
        K key;

        /**
         * Object.
         */
        V value;

        /**
         * Hash of object.
         */
        int hash;

        /**
         * Pointer to the next element
         */
        Entry<K, V> next;

        /**
         * Create bucket.
         * @param hash of object.
         * @param key of object.
         * @param value object.
         * @param next pointer to the next bucket.
         */
        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * Return key.
         * @return key.
         */
        @Override
        public K getKey() {
            return this.key;
        }

        /**
         * Return value of this bucket.
         * @return value.
         */
        @Override
        public V getValue() {
            return this.value;
        }

        /**
         * Update value at the bucket.
         * @param value new version of value.
         * @return old value.
         */
        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
