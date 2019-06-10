import Entidades.Athlete;
import TADS.Heap.HeapMax;
import TADS.LinkedList.src.*;


public class Repositorio {


    //clase encargada de contener y manejar datos

    private Lector lector = new Lector();

    private HeapMax<Integer,Athlete> MedallasOro;
    private HeapMax<Integer,Athlete> MedallasBronce;
    private HeapMax<Integer,Athlete> MedallasPlata;

    public Repositorio(){
        lector.leerArchivos();
    }

    public void imprimirAtletasConMasMedallas(String tipoDeMedalla){

        //falta implementar el quicksort para que ordene por cantidad de medallas ya que el heap no nos sirve para
        //las medallas porque las keys se repiten ya sea por el valor del id del atleta o por cant de medallas, lo
        //colocamos en una linkedlist y lo ordenamos sobre la marcha segun lo que nos pidan
        if(tipoDeMedalla.equals("Oro")){
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasOro.obtenerYEliminar();
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasOro());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
            }
        }

        if(tipoDeMedalla.equals("Plata")){
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasPlata.obtenerYEliminar();
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasPlata());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
            }
        }

        if(tipoDeMedalla.equals("Bronce")){
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasBronce.obtenerYEliminar();
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasBronze());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
            }
        }

    }

    public void imprimirRegionesConMasMedallas(String tipoDeMedalla){

    }

    public void imprimirMayorParticipacionFemenina(){

    }

    public void imprimirCiertoSexo(String sexo){}

    public void imprimirEquiposEfectivosRango(String rango){}

    private void generarEstructuras(){
        //genera arboles ordenados para cada consulta
    }

    private void generarHeapRegiones(){

    }

    private void generarHeapOro(){
        for(int i=0;i<lector.Atletas.size();i++){
            MedallasOro.agregar(lector.Atletas.get(i).getMedallasOro(),lector.Atletas.get(i));
        }
    }
    private void generarHeapPlata(){
        for(int i=0;i<lector.Atletas.size();i++){
            MedallasPlata.agregar(lector.Atletas.get(i).getMedallasPlata(),lector.Atletas.get(i));
        }
    }

    private void generarHeapBronze(){
        for(int i=0;i<lector.Atletas.size();i++){
            MedallasBronce.agregar(lector.Atletas.get(i).getMedallasBronze(),lector.Atletas.get(i));
        }
    }
}
