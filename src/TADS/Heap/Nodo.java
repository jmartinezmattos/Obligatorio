
public class Nodo< K extends Comparable<K>,D>{

    private K key;
    private D dato;


    public Nodo(K key, D dato) {
        this.key = key;
        this.dato = dato;
    }
    public K getKey() {
        return key;
    }

    public D getDato() {
        return dato;
    }
}
