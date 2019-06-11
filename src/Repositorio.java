import Entidades.Athlete;
import TADS.Heap.HeapMax;
import TADS.LinkedList.src.*;


public class Repositorio {

    //clase encargada de contener y manejar datos

    private Lector lector = new Lector();

    private HeapMax<Integer,Athlete> MedallasOro = new HeapMax<>(14000);
    private HeapMax<Integer,Athlete> MedallasBronce = new HeapMax<>(14000);
    private HeapMax<Integer,Athlete> MedallasPlata = new HeapMax<>(14000);

    private boolean medallasOroExiste = false;
    private boolean medallasPlataExiste = false;
    private boolean medallasBronceExiste = false;

    public Repositorio(){
        lector.leerArchivos();
    }

    public void imprimirAtletasConMasMedallas(int num){

        if(num == 1){
            if(!medallasOroExiste){
                generarHeapOro();
            }
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasOro.obtenerYEliminar();
                System.out.println("#"+(i+1));
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasOro());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
                System.out.println("");
            }
        }

        if(num == 2){
            if(!medallasPlataExiste){
                generarHeapPlata();
            }
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasPlata.obtenerYEliminar();
                System.out.println("#"+(i+1));
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasPlata());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
                System.out.println("");
            }
        }

        if(num == 3){
            if(!medallasBronceExiste){
                generarHeapBronce();
            }
            for(int i=0;i<10;i++) {
                Athlete aux = MedallasBronce.obtenerYEliminar();
                System.out.println("#"+(i+1));
                System.out.println("Nombre: "+aux.getName());
                System.out.println("Sexo: "+aux.getSex());
                System.out.println("Cantidad De Medallas: "+aux.getMedallasBronze());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
                System.out.println("");
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

    public void generarEstructuras(){
        //genera arboles ordenados para cada consulta
        generarHeapPlata();
        generarHeapOro();
        generarHeapBronce();
    }

    private void generarHeapRegiones(){

    }

    private void generarHeapOro(){
        for(int i=0;i<lector.Atletas.size();i++){
            if(lector.Atletas.get(i).getMedallasOro()>0){//si tiene medallas
                MedallasOro.agregar(lector.Atletas.get(i).getMedallasOro(), lector.Atletas.get(i));
            }
        }
        medallasOroExiste = true;
    }
    public void generarHeapPlata(){
        for(int i=0;i<lector.Atletas.size();i++){
            if(lector.Atletas.get(i).getMedallasPlata()>0) {
                MedallasPlata.agregar(lector.Atletas.get(i).getMedallasPlata(), lector.Atletas.get(i));
            }
        }
        medallasPlataExiste = true;
    }

    private void generarHeapBronce(){
        for(int i=0;i<lector.Atletas.size();i++){
            if(lector.Atletas.get(i).getMedallasBronze()>0){
                MedallasBronce.agregar(lector.Atletas.get(i).getMedallasBronze(), lector.Atletas.get(i));
            }
        }
        medallasBronceExiste = true;
    }
}
