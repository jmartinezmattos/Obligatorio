import Entidades.*;
import Enums.SexType;
import TADS.Hash.HashImpl;
import TADS.Heap.HeapMax;


import java.util.ArrayList;


public class Repositorio {

    //clase encargada de contener y manejar datos

    private Lector lector = new Lector();
    private HeapMax<Integer, Athlete> MedallasOro = new HeapMax<>(14000);
    private HeapMax<Integer, Athlete> MedallasBronce = new HeapMax<>(14000);
    private HeapMax<Integer, Athlete> MedallasPlata = new HeapMax<>(14000);
    private HeapMax<Integer,Athlete> MedallasTotales=new HeapMax<>(14000);

    private HeapMax<Integer,NationalOlympicCommittee> MedallasOroNOC = new HeapMax<>(500);
    private HeapMax<Integer,NationalOlympicCommittee> MedallasPlataNOC = new HeapMax<>(500);
    private HeapMax<Integer,NationalOlympicCommittee> MedallasBronceNOC = new HeapMax<>(500);
    private HeapMax<Integer,NationalOlympicCommittee> MedallasTotalesNOC=new HeapMax<>(500);

    private HashImpl<String,Team> equipos = new HashImpl<>(500);
    private ArrayList<String> arrayListEquipos = new ArrayList<>(250);
    private HeapMax<Float,Team> HeapEquiposRangoEfectivo = new HeapMax<>(300);

    private HeapMax<Integer,OlympicGame> HeapAtletasFemeninos =new HeapMax<>(22000);

    private HashImpl<String, Event> competiciones = new HashImpl<>(5000);
    private ArrayList<String> arrayListCompeticiones = new ArrayList<>(5000);
    private HeapMax<Integer,Event> competicionesFemenino = new HeapMax<>(5000);
    private HeapMax<Integer,Event> competicionesMasculino = new HeapMax<>(5000);

    private HashImpl<String, OlympicGame> olimpiadasFemeninas = new HashImpl<>(5000);
    private ArrayList<OlympicGame> arrayListOlimpiadasFemeninas = new ArrayList<OlympicGame>(5000);

    private boolean medallasOroExiste = false;
    private boolean medallasPlataExiste = false;
    private boolean medallasBronceExiste = false;
    private boolean medallasTotalesExiste = false;

    private boolean medallasOroRegionesExiste = false;
    private boolean medallasPlataRegionesExiste = false;
    private boolean medallasBronceRegionesExiste = false;
    private boolean medallasTotalesRegionesExiste = false;

    private boolean hashRegionesExiste = false;

    private boolean equiposGenerados = false;

    private boolean hashCompeticionesGenerado = false;
    private boolean heapCompeticionesFemGenerado =false;
    private boolean heapCompeticionesMascGenerado =false;

    public Repositorio() {
        lector.leerArchivos();
    }

    public void imprimirAtletasConMasMedallas(int num) {

        if (num == 1) {
            Athlete[] obtenidos = new Athlete[10];
            if (!medallasOroExiste) {
                generarHeapOro();
            }
            for (int i = 0; i < 10; i++) {
                Athlete aux = MedallasOro.obtenerYEliminar();
                obtenidos[i] = aux;
                System.out.println("#" + (i + 1));
                System.out.println("Nombre: " + aux.getName());
                System.out.println("Sexo: " + aux.getSex());
                System.out.println("Cantidad De  Medallas: " + aux.getMedallasOro());
                System.out.println("Año Maximo: " +aux.getMaxYear());
                System.out.println("Año Minimo: " +aux.getMinYear());
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasOro.agregar(obtenidos[i].getMedallasOro(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }

        if (num == 2) {
            Athlete[] obtenidos = new Athlete[10];
            if (!medallasPlataExiste) {
                generarHeapPlata();
            }
            for (int i = 0; i < 10; i++) {
                Athlete aux = MedallasPlata.obtenerYEliminar();
                obtenidos[i] = aux;
                System.out.println("#" + (i + 1));
                System.out.println("Nombre: " + aux.getName());
                System.out.println("Sexo: " + aux.getSex());
                System.out.println("Cantidad De Medallas: " + aux.getMedallasPlata());
                System.out.println("Año Maximo: " +aux.getMaxYear());
                System.out.println("Año Minimo: " +aux.getMinYear());
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasOro.agregar(obtenidos[i].getMedallasPlata(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }

        if (num == 3) {
            Athlete[] obtenidos = new Athlete[10];
            if (!medallasBronceExiste) {
                generarHeapBronce();
            }
            for (int i = 0; i < 10; i++) {
                Athlete aux = MedallasBronce.obtenerYEliminar();
                obtenidos[i] = aux;
                System.out.println("#" + (i + 1));
                System.out.println("Nombre: " + aux.getName());
                System.out.println("Sexo: " + aux.getSex());
                System.out.println("Cantidad De Medallas: " + aux.getMedallasBronze());
                System.out.println("Año Maximo: " +aux.getMaxYear());
                System.out.println("Año Minimo: " +aux.getMinYear());
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasOro.agregar(obtenidos[i].getMedallasBronze(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }
        if (num == 4) {
            Athlete[] obtenidos = new Athlete[10];
            if (!medallasTotalesExiste) {
                generarHeapTotales();
            }
            for (int i = 0; i < 10; i++) {
                Athlete aux = MedallasTotales.obtenerYEliminar();
                obtenidos[i] = aux;
                System.out.println("#" + (i + 1));
                System.out.println("Nombre: " + aux.getName());
                System.out.println("Sexo: " + aux.getSex());
                System.out.println("Cantidad De Medallas: " + aux.getMedallasTotales());
                System.out.println("Año Maximo: " +aux.getMaxYear());
                System.out.println("Año Minimo: " +aux.getMinYear());
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasTotales.agregar(obtenidos[i].getMedallasTotales(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }

        if (num < 1 || num > 4) {
            System.out.println("Opcion no valida");
        }

    }

    private void generarHeapTotales() {

        for (int i = 0; i < lector.Atletas.size(); i++) {
            if (lector.Atletas.get(i).getMedallasTotales() > 0) {
                MedallasTotales.agregar(lector.Atletas.get(i).getMedallasTotales(), lector.Atletas.get(i));
            }
        }
        medallasTotalesExiste= true;
    }


    public void imprimirRegionesConMasMedallas(int opcion) {
        generarHeapMedallasRegiones(opcion);
        NationalOlympicCommittee[] temp = new NationalOlympicCommittee[10];

        if(opcion == 1){
            System.out.println("Paises con mas medallas de Oro: ");
            System.out.println("");
            for(int i=0;i<10;i++) {
               temp[i] = MedallasOroNOC.obtenerYEliminar();
               System.out.println("Nombre de la region: " +temp[i].getName());
               System.out.println("Cantidad de medallas: " +temp[i].getCantMedallasOro());
               System.out.println("");
            }
            for(int i = 0;i<10;i++){
                MedallasOroNOC.agregar(temp[i].getCantMedallasOro(),temp[i]);
            }
        }

        if(opcion == 2){
            System.out.println("Paises con mas medallas de Plata: ");
            System.out.println("");
            for(int i=0;i<10;i++) {
               temp[i] = MedallasPlataNOC.obtenerYEliminar();
               System.out.println("Nombre de la region: " +temp[i].getName());
               System.out.println("Cantidad de medallas: " +temp[i].getCantMedllasPlata());
               System.out.println("");
            }
            for(int i = 0;i<10;i++){
                MedallasPlataNOC.agregar(temp[i].getCantMedllasPlata(),temp[i]);
            }
        }

        if(opcion == 3){
            System.out.println("Paises con mas medallas de Bronce: ");
            System.out.println("");
            for(int i=0;i<10;i++) {
               temp[i] = MedallasBronceNOC.obtenerYEliminar();
               System.out.println("Nombre de la region: " +temp[i].getName());
               System.out.println("Cantidad de medallas: " +temp[i].getCantMedallasBronce());
               System.out.println("");
            }
            for(int i = 0;i<10;i++){
                MedallasBronceNOC.agregar(temp[i].getCantMedallasBronce(),temp[i]);
            }
        }
        if(opcion == 4) {
            System.out.println("Paises con mas medallas en General: ");
            System.out.println("");
            for (int i = 0; i < 10; i++) {
                temp[i] = MedallasTotalesNOC.obtenerYEliminar();
                System.out.println("Nombre de la region: " + temp[i].getName());
                System.out.println("Cantidad de medallas: " + temp[i].getCantMedallasTotales());
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasTotalesNOC.agregar(temp[i].getCantMedallasTotales(), temp[i]);
            }
        }


    }

    public void imprimirMayorParticipacionFemenina() {
        if (HeapAtletasFemeninos == null) {
            generarHeapAtletasFemeninos();
        }
        OlympicGame[] resultantes = new OlympicGame[10];
        for (int i = 0; i < 10; i++) {
            OlympicGame aux=HeapAtletasFemeninos.obtenerYEliminar();
            resultantes[i]=aux;
            System.out.println("#" +(i+1));
            System.out.println("Nombre de la competicion: "+ aux.getName());
            System.out.println("Año: "+aux.getYear());
            System.out.println("Cantidad: "+ aux.getCantAtletasFemeninos());
            System.out.println("");
        }
    }
    public void imprimirCiertoSexo(int opcion) {
        if(opcion == 1){
            //femenino
            if(!heapCompeticionesFemGenerado){
                generarHeapCompeticionesFemenino();
            }
            Event[] eventos = new Event[10];
            for(int i=0;i<5;i++){
                Event evento = competicionesFemenino.obtenerYEliminar();
                eventos[i] = evento;
                System.out.println("#" +(i+1));
                System.out.println("Nombre de la competicion: " +evento.getName());
                System.out.println("Deporte: " +evento.getSport());
                System.out.println("Sexo: Femenino");
                System.out.println("Cantidad: " +evento.getAtletasFemeninos());
                System.out.println("");
            }
            for(int i=0;i<5;i++){
                competicionesFemenino.agregar(eventos[i].getAtletasFemeninos(),eventos[i]);
            }
        }
        if(opcion == 2){
            //masculino
            if(!heapCompeticionesMascGenerado){
                generarHeapCompeticionesMasculino();
            }
            Event[] eventos = new Event[10];
            for(int i=0;i<5;i++){
                Event evento = competicionesMasculino.obtenerYEliminar();
                eventos[i] = evento;
                System.out.println("#" +(i+1));
                System.out.println("Nombre de la competicion: " +evento.getName());
                System.out.println("Deporte: " +evento.getSport());
                System.out.println("Sexo: Masculino");
                System.out.println("Cantidad: " +evento.getAtletasMasculinos());
                System.out.println("");
            }
            for(int i=0;i<5;i++){
                competicionesMasculino.agregar(eventos[i].getAtletasFemeninos(),eventos[i]);
            }
        }
    }

    public void imprimirEquiposEfectivosRango(int inicio, int fin) {
        generarHeapEquiposRangoEfectivo(inicio,fin);
        for(int i=0;i<10;i++){
            Team equipo = HeapEquiposRangoEfectivo.obtenerYEliminar();
            int[] datos = equipo.efectivivadRangoDetalle(inicio, fin);
            System.out.println("#" + (i + 1));
            System.out.println("Equipo: "+equipo.getName());
            System.out.println("Cantidad de competidores: " +datos[0]);
            System.out.println("Cantidad de Medallas: " +datos[1]);
            System.out.println("Cantidad de atletas totales: " +equipo.getCantidadAtletas());
            System.out.println("Ratio medalla/competidor " +equipo.efectividadRango(inicio,fin));
            System.out.println("");
        }
    }

    public void generarEstructuras() {
        //genera arboles ordenados para cada consulta
        generarHeapPlata();
        generarHeapOro();
        generarHeapBronce();
        generarHeapTotales();
        generarHashRegiones();//falta heaps regiones
    }

    public int MedallasONOC(String noc){
        return lector.nationalOlympicCommittees.find(noc).getCantMedallasOro();
    }

    private void generarHashRegiones() {

        if(!hashRegionesExiste){
            for (int i = 0; i < lector.Atletas.size(); i++) {
                Athlete atleta = lector.Atletas.get(i);
                String NOC = atleta.getNOC();
                if (NOC.equals("SGP")) {
                    NOC = "SIN";//por archivo mal escrito en el documento
                }
                NationalOlympicCommittee committee = lector.nationalOlympicCommittees.find(NOC);
                committee.addAthlete(atleta);
            }
            hashRegionesExiste = true;
        }
    }

    private void generarHeapMedallasRegiones(int opcion){
        generarHashRegiones();
        if(opcion == 1){
            if(!medallasOroRegionesExiste){
                for (int i = 0; i < lector.arrayComittees.size(); i++) {
                    String NOC = lector.arrayComittees.get(i);
                    NationalOlympicCommittee committee = lector.nationalOlympicCommittees.find(NOC);
                    this.MedallasOroNOC.agregar(committee.getCantMedallasOro(), committee);
                }
                medallasOroRegionesExiste = true;
            }
        }

        if(opcion == 2){
            if(!medallasPlataRegionesExiste){
                for (int i = 0; i < lector.arrayComittees.size(); i++) {
                    String NOC = lector.arrayComittees.get(i);
                    NationalOlympicCommittee committee = lector.nationalOlympicCommittees.find(NOC);
                    this.MedallasPlataNOC.agregar(committee.getCantMedllasPlata(), committee);
                }
                medallasPlataRegionesExiste = true;
            }
        }
        if(opcion == 3) {
            if (!medallasBronceRegionesExiste) {
                for (int i = 0; i < lector.arrayComittees.size(); i++) {
                    String NOC = lector.arrayComittees.get(i);
                    NationalOlympicCommittee committee = lector.nationalOlympicCommittees.find(NOC);
                    this.MedallasBronceNOC.agregar(committee.getCantMedallasOro(), committee);
                }
                medallasBronceRegionesExiste = true;
            }
        }
        if(opcion == 4) {
            if (!medallasTotalesRegionesExiste) {
                for (int i = 0; i < lector.arrayComittees.size(); i++) {
                    String NOC = lector.arrayComittees.get(i);
                    NationalOlympicCommittee committee = lector.nationalOlympicCommittees.find(NOC);
                    this.MedallasTotalesNOC.agregar(committee.getCantMedallasTotales(), committee);
                }
                medallasTotalesRegionesExiste = true;
            }
        }
    }

    private void generarHeapOro() {
        for (int i = 0; i < lector.Atletas.size(); i++) {
            if (lector.Atletas.get(i).getMedallasOro() > 0) {//si tiene medallas
                MedallasOro.agregar(lector.Atletas.get(i).getMedallasOro(), lector.Atletas.get(i));
            }
        }
        medallasOroExiste = true;
    }

    public void generarHeapPlata() {
        for (int i = 0; i < lector.Atletas.size(); i++) {
            if (lector.Atletas.get(i).getMedallasPlata() > 0) {
                MedallasPlata.agregar(lector.Atletas.get(i).getMedallasPlata(), lector.Atletas.get(i));
            }
        }
        medallasPlataExiste = true;
    }

    private void generarHeapBronce() {
        for (int i = 0; i < lector.Atletas.size(); i++) {
            if (lector.Atletas.get(i).getMedallasBronze() > 0) {
                MedallasBronce.agregar(lector.Atletas.get(i).getMedallasBronze(), lector.Atletas.get(i));
            }
        }
        medallasBronceExiste = true;
    }

    private void generarEquipos(){

        for(int i=0;i<lector.Atletas.size();i++){//recorre todos los atletas
            Athlete athlete = lector.Atletas.get(i);
            String teamName = athlete.getTeam();//se fija a que equipo pertenece el atleta
            if(!equipos.contains(teamName)){
                //si el equipo todavia no existe
                arrayListEquipos.add(teamName);//se genera arraylist para recorrer el Hash
                Team newTeam = new Team(teamName);//genera un nuevo equipo
                newTeam.addAtleta(athlete);//le agrega el atleta al equipo
                equipos.put(teamName,newTeam);//agrega el equipo al Hash utilizando su nombre como Key
            }
            else{
                //si el equipo ya existe
                equipos.find(teamName).addAtleta(athlete);//agrega el atleta al equipo
            }
        }
        equiposGenerados = true;//boolean utilizado para indicar que ya se genero el Hash
    }

    private void generarHeapEquiposRangoEfectivo(int inicio, int fin){
        if(!equiposGenerados){
            //si todavia no se genero el Hash lo genera
            generarEquipos();
        }
        for(int i=0;i<arrayListEquipos.size();i++){//recorre todos los equipos en el Hash utilizando el arraylist para obtener las keys
            String name = arrayListEquipos.get(i);//obtiene el nombre del equipo (la key para el hash) del arraylist
            Team teamTemp = equipos.find(name);//obtiene el equipo del hash
            HeapEquiposRangoEfectivo.agregar(teamTemp.efectividadRango(inicio,fin),teamTemp);//agrega el el equipo al heap utilizando su efectividad como key
        }
    }

    public void generarHashCompeticiones(){
        for(int i=0;i<lector.Participaciones.size();i++){
            AthleteOlympicParticipation participacion = lector.Participaciones.get(i);
            if(!competiciones.contains(participacion.getEvent())){
                arrayListCompeticiones.add(participacion.getEvent());
                Event competicion = new Event(participacion.getEvent(), participacion.getSport(), participacion.getOlympicGame());
                competicion.addAtleta(participacion.getAthlete());
                competiciones.put(participacion.getEvent(),competicion);
            }
            else{
                Event competicion = competiciones.find(participacion.getEvent());
                competicion.addAtleta(participacion.getAthlete());
            }
            hashCompeticionesGenerado = true;
        }
    }

    private void generarHeapCompeticionesFemenino(){
        if(!hashCompeticionesGenerado){
            generarHashCompeticiones();
        }
        for(int i=0;i<arrayListCompeticiones.size();i++){
            String keyCompeticionHash = arrayListCompeticiones.get(i);
            Event competicion = competiciones.find(keyCompeticionHash);
            int keyCompeticionHeap = competicion.getAtletasFemeninos();
            competicionesFemenino.agregar(keyCompeticionHeap,competicion);
        }
        heapCompeticionesFemGenerado = true;

    }

    private void generarHeapCompeticionesMasculino(){
        if(!hashCompeticionesGenerado){
            generarHashCompeticiones();
        }
        for(int i=0;i<arrayListCompeticiones.size();i++){
            String keyCompeticionHash = arrayListCompeticiones.get(i);
            Event competicion = competiciones.find(keyCompeticionHash);
            int keyCompeticionHeap = competicion.getAtletasMasculinos();
            competicionesMasculino.agregar(keyCompeticionHeap,competicion);
        }
        heapCompeticionesMascGenerado = true;

    }

    private void generarHashOlimpiadasFemeninas(){

        for(int i=0;i<lector.Atletas.size();i++){//recorre todos los atletas
            Athlete atleta = lector.Atletas.get(i);
            if(atleta.getSex().equals(SexType.FEMALE)){//se fija si es femenino
               for(int j=0;j<atleta.getParticipaciones().size();j++){//recorre todas las participaciones
                   AthleteOlympicParticipation participation = atleta.getParticipaciones().get(j);
                   OlympicGame olimpiada = participation.getoGames();
                   if(!olimpiadasFemeninas.contains(olimpiada.getName())){//si la olimpiada no esta en el hash
                       //hay que sumarle uno al contador de atletas femeninos de la olimpiada
                       arrayListOlimpiadasFemeninas.add(olimpiada);//arraylis utilizado para luego recorrer el hash
                      // olimpiadasFemeninas.put(nombreOlimpiada,olimpiada);
                   }
                   else{
                      // OlympicGame olimpiada = olimpiadasFemeninas.find(olimpiada);
                       //hay que agregarle uno a la cantidad  de atletas femeninos
                   }
               }
           }
       }
    }
    //Cargamos el heap
    public void generarHeapAtletasFemeninos(){
        for(int i=0;i<lector.Participaciones.size();i++) {
               HeapAtletasFemeninos.agregar(lector.Participaciones.get(i).getoGames().getCantAtletasFemeninos(), lector.Participaciones.get(i).getoGames());

            }
        }


    }



