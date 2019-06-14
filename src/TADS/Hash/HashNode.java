package TADS.Hash;
public class HashNode<K,V> {

    private K key;
    private V value;
    private HashNode<K,V> nodoAnterior;
    private HashNode<K,V> nodoSiguiente = null;
    boolean hasNext = false;

    public HashNode(K key, V value){
        this.key=key;
        this.value=value;
    }

    public HashNode<K, V> getNodoAnterior() {
        return nodoAnterior;
    }

    public void setNodoAnterior(HashNode<K, V> nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public HashNode<K, V> getNodoSiguiente() {
        return nodoSiguiente;
    }

    public  boolean hasNext(){
        return hasNext;
    }

    public void setNodoSiguiente(HashNode<K, V> nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
        this.hasNext = true;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


}



