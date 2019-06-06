package TADS.Stack;
public interface MyStack <T>{
    void pop () throws  EmptyStack;
    T top() throws EmptyStack;
    void push(Nodo<T> element) throws  EmptyStack;
    boolean isEmpty ();
    void makeEmpty() throws  EmptyStack;
}