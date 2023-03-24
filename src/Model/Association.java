package Model;

import java.util.HashMap;
import java.util.Map;

public class Association<K,V> implements Map.Entry<K,V> {

    //Variables
    protected K key;
    protected V value;
    private HashMap<K,V> association;

    //Extraído de: https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

    public Association(K k, V v) {
        this.key = k;
        this.value = v;
    }

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

    public void put(K key, V value){
        association.put(key, value);
    }

    public V get(Object key){
        return association.get(key);
    }

    public String toString() {

        StringBuffer str = new StringBuffer();

        str.append("(" + getKey() + ", " + getValue() + ")");
        return str.toString();
    }
}
