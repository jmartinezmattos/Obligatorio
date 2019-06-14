package TADS.Hash;
import TADS.LinkedList.src.LinkedList;
import TADS.LinkedList.src.LinkedListKV;

public class HashImpl<K,V> implements Hash<K,V> {

    private LinkedList<HashNode>[] myHash;
    private int size;
    private HashNode<K,V> nodoAgregar;


    public  HashImpl(int size) {

        myHash = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            myHash[i] = new LinkedList<HashNode>();
        }
        this.size = size;

    }


    public void put(K key, V value) {

        nodoAgregar=new HashNode(key,value);
        this.colision(key, nodoAgregar);

    }

    public V find(K key) {

        V valueFind=null;
        int b=key.hashCode();
        if(b>size){
            b = b%size;
        }
        int i = 0;
        boolean terminado = false;
        HashNode<K,V> nodoNext=myHash[b].get(i);

        do {
            if (nodoNext.getKey().equals(key)) {
                valueFind = nodoNext.getValue();
                terminado = true;
            }else{
                i++;
                nodoNext=myHash[b].get(i);
            }
        }while(!terminado);

        /*
        while(nodoNext.getKey()!=key){
            nodoNext=nodoNext.getNodoSiguiente();
        }
        if(nodoNext.getKey()==key){
            valueFind=nodoNext.getValue();
        }
        */

        return valueFind;
    }


    public boolean contains(K key) {
        boolean encontrado=false;
        V valueFind=null;
        int b=key.hashCode();

        HashNode<K,V> nodoNext= myHash[b].get(0);

        while(nodoNext.getKey()!=key){
            nodoNext=nodoNext.getNodoSiguiente();
        }
        if(nodoNext.getKey()==key){
            encontrado=true;
        }
        return encontrado;
    }

    public void remove(K key)throws ElementoNoExiste {

        if (!this.contains(key)) {
            throw new ElementoNoExiste();
        }
        V valueRemove = null;
        int b = key.hashCode();
        HashNode<K, V> nodoNext = myHash[b].get(0);
        while (nodoNext.getKey() != key) {
            nodoNext = nodoNext.getNodoSiguiente();
        }
        if (nodoNext.getKey() == key) {

            HashNode<K, V> anterior = nodoNext.getNodoAnterior();
            anterior.setNodoSiguiente(nodoNext.getNodoSiguiente());
        }

    }

    public void colision(K key , HashNode<K,V> nodoAgregar) {

        int position = key.hashCode();
        if(position>size){
            position = position%size;
        }

        //HashNode<K,V> nodoAux = myHash[position].get(0);

        myHash[position].add(nodoAgregar);

        /*
        if (nodoAux != null) {
            HashNode<K, V> nodoActual = nodoAux.getNodoSiguiente();
            while (nodoActual != null && nodoActual.hasNext) {
                nodoActual = nodoActual.getNodoSiguiente();
            }
            nodoActual.setNodoSiguiente(nodoAgregar);
        }
        if (nodoAux== null) {
            //si esta vacio
            myHash[position].add(nodoAgregar.getKey(),nodoAgregar.getValue());
        }
        */




    }
}
