package TADS.Queue.CircularQueue;
public class QueueFullException extends Exception {

    public static final long serialVersionUID=700L;

    public QueueFullException(String mensaje){
        super(mensaje);
    }

}
