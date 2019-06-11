import Entidades.Athlete;
import TADS.Heap.HeapMax;
import TADS.LinkedList.src.*;


public class Repositorio {


    //clase encargada de contener y manejar datos

    private Lector lector = new Lector();

    private HeapMax<Integer,Athlete> MedallasOro = null;
    private HeapMax<Integer,Athlete> MedallasBronce = null;
    private HeapMax<Integer,Athlete> MedallasPlata = null;

    public Repositorio(){
        lector.leerArchivos();
    }

    public void imprimirAtletasConMasMedallas(int num){

        if(num == 1){
            if(MedallasOro == null){
                generarHeapOro();
            }
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasOro.obtenerYEliminar();
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasOro());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
            }
        }

        if(num == 2){
            if(MedallasPlata == null){
                generarHeapPlata();
            }
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasPlata.obtenerYEliminar();
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasPlata());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
            }
        }

        if(num == 3){
            if(MedallasBronce == null){
                generarHeapBronce();
            }
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasBronce.obtenerYEliminar();
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasBronze());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
            }
        }

        if(num < 1 || num >3){
            System.out.println("Opcion no valida");
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
        generarHeapPlata();
        generarHeapOro();
        generarHeapBronce();
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

    private void generarHeapBronce(){
        for(int i=0;i<lector.Atletas.size();i++){
            MedallasBronce.agregar(lector.Atletas.get(i).getMedallasBronze(),lector.Atletas.get(i));
        }
    }
}
