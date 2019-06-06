package TADS.Stack;

public class EmptyStack extends Exception {
    public static final long serialVersionUID=700L;

    public EmptyStack(String mensaje){
        super(mensaje);
    }
}
