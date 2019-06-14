package TADS.LinkedList.src;

import TADS.Hash.HashNode;

public class LinkedListKV<K,V> implements ListKV<K,V> {

    private HashNode<K,V> first = null;
    private HashNode<K,V> last;
    private int size=0;

    public HashNode<K, V> getFirst() {
        return first;
    }

    public void setFirst(HashNode<K, V> first) {
        this.first = first;
    }

    public HashNode<K, V> getLast() {
        return last;
    }

    public void setLast(HashNode<K, V> last) {
        this.last = last;
    }

    public void add(K key, V value) {

        HashNode<K,V> nuevo = new HashNode<K,V>(key,value);

        if(size == 0){
            this.first = nuevo;
            this.last = this.first;
        }
        else{
            nuevo.setNodoAnterior(this.last);
            this.last.setNodoSiguiente(nuevo);
            this.last = nuevo;
        }
        size++;
    }

    @Override
    public void remove(int position) {

        try {

            if (0 > position || position > (size - 1)) {
                throw new NullPointerException();
            }

            HashNode<K,V> auxPrev;
            HashNode<K,V> auxNext;
            HashNode<K,V> auxDel = this.first;

            if(position == 0){
                auxNext = this.first.getNodoSiguiente();
                this.first = auxNext;
            }
            else if(position == (size-1)){
                auxPrev = this.last.getNodoAnterior();
                auxPrev.setNodoSiguiente(null);
                this.last = auxPrev;
            }
            else{

                for(int i=0; i < position; i++){
                    auxDel = auxDel.getNodoSiguiente();
                }

                auxNext = auxDel.getNodoSiguiente();
                auxPrev = auxDel.getNodoAnterior();

                auxPrev.setNodoSiguiente(auxNext);
                auxNext.setNodoAnterior(auxPrev);
            }

            size--;
        }
        catch(NullPointerException e){
            System.out.println("No se elimino objeto por indice invalido (" +position +")");
        }
    }

    @Override
    public V get(int position) {

        HashNode<K,V> buscado = this.first;
        V value = null;

        try {

            if(position<0){
                throw new  NullPointerException();
            }

            for (int i=0; i < position; i++) {
                buscado = buscado.getNodoSiguiente();
            }
            value = buscado.getValue();
        }
        catch (NullPointerException e){
            System.out.println("Indice invalido (indx max=" +(size-1) +")");
        }
        return value;
    }

    public void addFirst(K key, V value){
        HashNode<K,V> nuevo = new HashNode<K,V>(key,value);

        if(size>0) {
            nuevo.setNodoSiguiente(this.first);
        }

        this.first = nuevo;

        size++;
    } //le falta para doublelink

    public void addLast(K key, V value){
        add(key,value);
    }

}
