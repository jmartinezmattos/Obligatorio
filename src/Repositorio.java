public class Repositorio {

    //clase encargada de contener y manejar datos

    private Lector lector = new Lector();

    public Repositorio(){
        lector.leerArchivos();
    }

    public void imprimirAtletasConMasMedallas(String tipoDeMedalla){

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
}
