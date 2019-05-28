 public class MyStackIMP<T> implements MyStack<T> {
    Nodo<T> ultimo=null;

    public void pop() throws EmptyStackException {
        if(ultimo==null){ throw new EmptyStackException("No existe ");
        }else{
            ultimo=ultimo.getSiguiente();
        }
        }

     public T top() throws EmptyStackException {
         return ultimo.getValor();
     }


     public void push(Nodo<T> element) throws EmptyStackException  {
        element.setSiguiente(ultimo);
        ultimo=element;
        if(element.equals(null)){
            throw new EmptyStackException("no se aceptan elementos nulos");
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


     public void makeEmpty() throws EmptyStackException {
        while(ultimo!=null){
            ultimo=null;
        }
     }
 }