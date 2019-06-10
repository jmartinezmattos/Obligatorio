
package TADS.Heap;

import Exceptions.EmptyHeapException;
import Exceptions.KeyYaExiste;

import java.util.Arrays;

public class HeapMax<K extends Comparable<K>,D> {

    private Nodo<K,D>[] array = new Nodo[10];
    private int cantidadDatos = 0;

    public HeapMax(int size){
        if(size>0) {
            this.array = new Nodo[size];
        }
        else this.array = new Nodo[1];
    }

    public void agregar(K key,D dato) {

        Nodo<K,D> nodo = new Nodo(key,dato);

        if(array.length < this.cantidadDatos+1){// +1 pa que no de null pointer en comparacion de hijos
            Nodo<K,D>[] array2 = Arrays.copyOf(this.array, this.array.length*2);
            this.array = array2;
        }

        addNodoFinal(nodo);

        cantidadDatos++;

    }

    public D obtenerYEliminar(){

        Nodo<K,D> returnNode = array[0];

        array[0] = array[cantidadDatos -1]; //el ultimo nodo pasa a ser el primero
        boolean complete = false;
        int i=0; //usado para el indice, empieza con 0

        while(!complete){

            //primero encontrar el hijo mas grande
            if(getRightChildFromIndex(i) == null||(getLeftChildFromIndex(i) != null && getLeftChildFromIndex(i).getKey().compareTo(getRightChildFromIndex(i).getKey()) > 0)){

                //si es mas grande el izquierdo o es nulo el derecho
                if(getLeftChildFromIndex(i) != null && getLeftChildFromIndex(i).getKey().compareTo(array[i].getKey()) > 0){
                    //si el izquierdo es mas grande que el padre
                    siftDownLeft(i);
                    i = (2*i)+1;//nuevo indice
                }
                else{
                    //si no es mas grande que el padre
                    complete = true;
                }
            }

            else{

                //si es mas grande el derecho
                if(getRightChildFromIndex(i).getKey().compareTo(array[i].getKey()) >0 ){
                    siftDownRigth(i);
                    i = (2*i)+2;
                }
                else{
                    complete = true;
                }
            }

        }

        this.array[cantidadDatos-1] = null;
        this.cantidadDatos --;

        return returnNode.getDato();

    }

    public int getSize(){
        return this.cantidadDatos;
    }

    private Nodo getParentFromIndex(int indice){

        int parentIndex;

        if(indice > 0) {
           parentIndex = (indice - 1) / 2;
        }
        else {
            parentIndex = 0;
        }
        return array[parentIndex];
    }

    private Nodo getLeftChildFromIndex(int indice){ //hijos en 2k+1 y 2k+2
            int childIndex = (2 * indice + 1);
            if(childIndex < array.length) {
                return array[childIndex];
            }
            else{
                return null;
            }
    }
    private Nodo getRightChildFromIndex(int indice){
        if(indice < cantidadDatos){
            int childIndex = (2 * indice + 2);
            if(childIndex < cantidadDatos) {
                return array[childIndex];
            }
            else {
                return null;
            }
        }
        else{
            return null;
        }
    }

    private void siftUp(int indice){

        if(indice != 0) {
            Nodo aux = getParentFromIndex(indice);
            array[(indice - 1) / 2] = array[indice];
            array[indice] = aux;
        }

    }

    private void siftDownLeft(int indice){
        Nodo<K,D> aux = getLeftChildFromIndex(indice);
        array[2*indice+1] = array[indice];
        array[indice] = aux;
    }

    private void siftDownRigth(int indice){
        Nodo<K,D> aux = getRightChildFromIndex(indice);
        array[2*indice+2] = array[indice];
        array[indice] = aux;
    }

    private void addNodoFinal(Nodo<K,D> nodo) {//es para usar en otra funcion

        int indice = cantidadDatos;//entra al while con el indice del ultimo en el array
        array[indice] = nodo;//agrega el dato en el indice final
        K key = nodo.getKey();

        if (indice > 0) {
            while (getParentFromIndex(indice).getKey().compareTo(key) < 0) {//si la key es mayor lo sube
                siftUp(indice);
                indice = (indice - 1) / 2;
            }
        }
    }


    public void visualRep(){

        if(cantidadDatos == 0){
            System.out.println("Empty Stack");
        }

        while(cantidadDatos != 0) {
            System.out.println(obtenerYEliminar());
            visualNoDelete();
        }


    }

    public void visualNoDelete(){

        for(int i=0;i<cantidadDatos;i++) {
            System.out.print("[" +array[i].getDato() +"]");
        }
        System.out.println("");
    }


}
