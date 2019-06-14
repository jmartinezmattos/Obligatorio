package TADS.Hash;
import TADS.LinkedList.src.LinkedList;

import java.math.BigInteger;

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
        int b=Math.abs(key.hashCode());
        if(b>this.size){
            b = b%this.size;
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

        return valueFind;
    }


    public boolean contains(K key) {
        boolean encontrado=false;
        int b=Math.abs(key.hashCode());
        int i=0;
        if(b>this.size){
            b = b%this.size;
        }
        if(b<0){
            System.out.println(b);
        }


        HashNode<K,V> nodoNext= myHash[b].get(0);
        LinkedList<HashNode> linkedList = myHash[b];


        while(linkedList.get(i) != null && !encontrado){
            if(linkedList.get(i).getKey().equals(key)){
                encontrado = true;
            }
            i++;

        }

        /*
        while(nodoNext != null && !nodoNext.getKey().equals(key)){
            nodoNext=nodoNext.getNodoSiguiente();
        }
        if(nodoNext != null && nodoNext.getKey().equals(key)){
            encontrado=true;
        }
        */


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

        int position = Math.abs(key.hashCode());
        if(position>size){
            position = position%size;
        }
        myHash[position].add(nodoAgregar);
    }
}
