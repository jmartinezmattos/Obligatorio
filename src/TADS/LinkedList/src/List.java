package TADS.LinkedList.src;

public interface List<K,V> {

    void add(K key, V value);

    public void remove (int position);

    public Object get (int position);
}
