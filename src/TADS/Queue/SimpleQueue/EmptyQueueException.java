package TADS.Queue.SimpleQueue;

public class EmptyQueueException extends Exception {

    public static final long serialVersionUID=700L;

    public EmptyQueueException(String mensaje){
        super(mensaje);
    }

}
