package TADS.Stack;
public class MyStackIMP<T> implements MyStack<T> {
    Nodo<T> ultimo=null;

    public void pop() throws EmptyStack {
        if(ultimo==null){ throw new EmptyStack("No existe ");
        }else{
            ultimo=ultimo.getSiguiente();
        }
        }

     public T top() throws EmptyStack {
         return ultimo.getValor();
     }


     public void push(Nodo<T> element) throws EmptyStack  {
        element.setSiguiente(ultimo);
        ultimo=element;
        if(element.equals(null)){
            throw new EmptyStack("no se aceptan elementos nulos");
        }
     }


     public boolean isEmpty() {
         boolean vacio=false;
         if(ultimo!=null){
             vacio=false;
         }else{
             vacio=true;
         }
         return vacio;
     }


     public void makeEmpty() throws EmptyStack {
        while(ultimo!=null){
            ultimo=null;
        }
     }
 }