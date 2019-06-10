package TADS.Heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapMaxTest {

    @Test
    public void agregar() {

        HeapMax<Integer,String> heap = new HeapMax<>(1);

        heap.agregar(5,"5");
        heap.visualNoDelete();
        heap.agregar(9,"9");
        heap.agregar(9,"9");
        heap.agregar(9,"9");
        heap.agregar(9,"9");
        heap.visualNoDelete();
        heap.agregar(7,"7");
        heap.agregar(7,"7");
        heap.agregar(7,"7");
        heap.agregar(7,"7");
        heap.agregar(7,"7");
        heap.visualNoDelete();
        heap.agregar(99,"99");
        heap.agregar(99,"99");
        heap.agregar(99,"99");
        heap.visualNoDelete();
        heap.agregar(8,"8");
        heap.agregar(8,"8");
        heap.agregar(99,"99");
        heap.agregar(99,"99");

        heap.visualNoDelete();
        System.out.println("------------------");
        System.out.println("Obtener y eliminar");
        heap.visualRep();

    }
}