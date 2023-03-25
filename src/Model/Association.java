package Model;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Association.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class Association<K,V> implements Map.Entry<K,V> {

    /**
     * The Key.
     */
//Variables
    protected K key;
    /**
     * The Value.
     */
    protected V value;
    private HashMap<K,V> association;

    //Extraído de: https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

    /**
     * Instantiates a new Association.
     *
     * @param k the k
     * @param v the v
     */
    public Association(K k, V v) {

        if (k == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        this.key = k;
        this.value = v;
    }

    /**
     * Instantiates a new Association.
     */
//Metodo que implementa el HasMap para organizar las asociaciones
    public Association() {
        association = new HashMap<K,V>();
    }

    public V getValue(){
        return value;
    }

    public K getKey() {
        return key;
    }

    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    /**
     * Put.
     *
     * @param key   the key
     * @param value the value
     */
    public void put(K key, V value){
        association.put(key, value);
    }

    /**
     * Get v.
     *
     * @param key the key
     * @return the v
     */
    public V get(Object key){
        return association.get(key);
    }

    public String toString() {

        StringBuffer str = new StringBuffer();

        str.append("(" + getKey() + ", " + getValue() + ")");
        return str.toString();
    }
}
