import Entidades.*;
import Entidades.Event;
import Enums.SexType;
import FormatoTexto.Colores;
import FormatoTexto.Formato;
import TADS.Hash.HashImpl;
import TADS.Heap.HeapMax;


import java.awt.*;
import java.text.Normalizer;
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
    private ArrayList<String> arrayListOlimpiadasFemeninas = new ArrayList<String>(5000);

    private boolean medallasOroRegionesExiste = false;
    private boolean medallasPlataRegionesExiste = false;
    private boolean medallasBronceRegionesExiste = false;
    private boolean medallasTotalesRegionesExiste = false;

    private boolean hashRegionesExiste = false;
    private boolean equiposGenerados = false;
    private boolean hashAtletasFemeninos = false;
    private boolean hashCompeticionesGenerado = false;
    private boolean hashOlimpiadasFemeninasExiste = false;

    public Repositorio() {
        lector.leerArchivos();
    }

    public void imprimirAtletasConMasMedallas(String num) {

        if (num.equals("1")) {
            Athlete[] obtenidos = new Athlete[10];
            if (MedallasOro.getSize()==0) {
                generarHeapOro();
            }
            System.out.println(Colores.yellow +Formato.negrita+"Atletas con mas medallas de Oro: ");
            System.out.println("");
            for (byte i = 0; i < 10; i++) {
                Athlete aux = MedallasOro.obtenerYEliminar();
                obtenidos[i] = aux;
                System.out.println(Formato.negrita+Colores.blue +"#" +Colores.reset +Formato.reset+(i+1));
                System.out.println(Colores.blue+Formato.negrita+"Nombre: "+Colores.reset +Formato.reset+ aux.getName());
                System.out.println(Colores.blue+Formato.negrita+"Sexo: " +Colores.reset +Formato.reset+ aux.getSex());
                System.out.println(Colores.blue+Formato.negrita+"Cantidad De  Medallas: "  +Colores.reset +Formato.reset+aux.getMedallasOro());
                System.out.println(Colores.blue+Formato.negrita+"Año Maximo: " +Colores.reset +Formato.reset+aux.getMaxYear());
                System.out.println(Colores.blue+Formato.negrita+"Año Minimo: " +Colores.reset +Formato.reset+aux.getMinYear());
                System.out.println("");
            }
            for (byte i = 0; i < 10; i++) {
                MedallasOro.agregar(obtenidos[i].getMedallasOro(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }

        if (num.equals("2")) {
            Athlete[] obtenidos = new Athlete[10];
            if (MedallasPlata.getSize()==0) {
                generarHeapPlata();
            }
            System.out.println(Colores.white +Formato.negrita+"Atletas con mas medallas de Plata: ");
            System.out.println("");
            for (int i = 0; i < 10; i++) {
                Athlete aux = MedallasPlata.obtenerYEliminar();
                obtenidos[i] = aux;
                System.out.println(Colores.blue+Formato.negrita +"#" +Colores.reset +Formato.reset+(i+1));
                System.out.println(Colores.blue+Formato.negrita+"Nombre: " +Colores.reset +Formato.reset+ aux.getName());
                System.out.println(Colores.blue +Formato.negrita+"Sexo: " +Colores.reset +Formato.reset+ aux.getSex());
                System.out.println(Colores.blue +Formato.negrita+"Cantidad De Medallas: " +Colores.reset +Formato.reset+ aux.getMedallasPlata());
                System.out.println(Colores.blue +Formato.negrita+"Año Maximo: " +Colores.reset +Formato.reset+aux.getMaxYear());
                System.out.println(Colores.blue +Formato.negrita+"Año Minimo: " +Colores.reset +Formato.reset+aux.getMinYear());
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasOro.agregar(obtenidos[i].getMedallasPlata(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }

        if (num.equals("3")) {
            Athlete[] obtenidos = new Athlete[10];
            if (MedallasBronce.getSize()==0) {
                generarHeapBronce();
            }
            System.out.println(Colores.red +Formato.negrita+"Atletas con mas medallas de Bronce: ");
            System.out.println("");
            for (int i = 0; i < 10; i++) {
                Athlete aux = MedallasBronce.obtenerYEliminar();
                obtenidos[i] = aux;
                System.out.println(Colores.blue+Formato.negrita +"#" +Colores.reset+Formato.reset +(i+1));
                System.out.println(Colores.blue +Formato.negrita+"Nombre: "+Colores.reset +Formato.reset + aux.getName());
                System.out.println(Colores.blue +Formato.negrita+"Sexo: " +Colores.reset +Formato.reset+ aux.getSex());
                System.out.println(Colores.blue +Formato.negrita+"Cantidad De Medallas: " +Colores.reset +Formato.reset+ aux.getMedallasBronze());
                System.out.println(Colores.blue +Formato.negrita+"Año Maximo: " +Colores.reset +Formato.reset+aux.getMaxYear());
                System.out.println(Colores.blue +Formato.negrita+"Año Minimo: " +Colores.reset +Formato.reset+aux.getMinYear());
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasOro.agregar(obtenidos[i].getMedallasBronze(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }
        if (num.equals("4")) {
            Athlete[] obtenidos = new Athlete[10];
            if (MedallasTotales.getSize()==0) {
                generarHeapTotales();
            }
            System.out.println(Formato.negrita+Colores.purple+"Atletas con mas medallas en General: ");
            System.out.println("");
            for (int i = 0; i < 10; i++) {
                Athlete aux = MedallasTotales.obtenerYEliminar();
                obtenidos[i] = aux;
                System.out.println(Colores.blue+Formato.negrita +"#" +Colores.reset+Formato.reset +(i+1));
                System.out.println(Colores.blue +Formato.negrita+"Nombre: " +Colores.reset +Formato.reset+ aux.getName());
                System.out.println(Colores.blue +Formato.negrita+"Sexo: "+Colores.reset +Formato.reset + aux.getSex());
                System.out.println(Colores.blue +Formato.negrita+"Cantidad De Medallas: " +Colores.reset +Formato.reset+ aux.getMedallasTotales());
                System.out.println(Colores.blue +Formato.negrita+"Año Maximo: " +Colores.reset +Formato.reset+aux.getMaxYear());
                System.out.println(Colores.blue +Formato.negrita+"Año Minimo: " +Colores.reset +Formato.reset+aux.getMinYear());
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasTotales.agregar(obtenidos[i].getMedallasTotales(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }

    }

    private void generarHeapTotales() {

        for (int i = 0; i < lector.Atletas.size(); i++) {
            if (lector.Atletas.get(i).getMedallasTotales() > 0) {
                MedallasTotales.agregar(lector.Atletas.get(i).getMedallasTotales(), lector.Atletas.get(i));
            }
        }
    }

    public void imprimirRegionesConMasMedallas(String opcion) {
        generarHeapMedallasRegiones(opcion);
        NationalOlympicCommittee[] temp = new NationalOlympicCommittee[10];

        if(opcion.equals("1")){
            System.out.println(Colores.yellow +Formato.negrita+"Paises con mas medallas de Oro: ");
            System.out.println("");
            for(byte i=0;i<10;i++) {
                System.out.println(Colores.blue+Formato.negrita +"#" +Colores.reset +Formato.reset+(i+1));
               temp[i] = MedallasOroNOC.obtenerYEliminar();
               System.out.println(Colores.blue +Formato.negrita+"Nombre de la region: " +Colores.reset +Formato.reset+temp[i].getName());
               System.out.println(Colores.blue +Formato.negrita+"Cantidad de medallas: " +Colores.reset +Formato.reset+temp[i].getCantMedallasOro());
               System.out.println("");
            }
            for(byte i = 0;i<10;i++){
                MedallasOroNOC.agregar(temp[i].getCantMedallasOro(),temp[i]);
            }
        }

        if(opcion.equals("2")){
            System.out.println(Colores.white +Formato.negrita+"Paises con mas medallas de Plata: ");
            System.out.println("");
            for(byte i=0;i<10;i++) {
               temp[i] = MedallasPlataNOC.obtenerYEliminar();
                System.out.println(Colores.blue+Formato.negrita +"#" +Colores.reset +Formato.reset+(i+1));
               System.out.println(Colores.blue +Formato.negrita+"Nombre de la region: " +Colores.reset +Formato.reset+temp[i].getName());
               System.out.println(Colores.blue +Formato.negrita+"Cantidad de medallas: " +Colores.reset +Formato.reset+temp[i].getCantMedllasPlata());
               System.out.println("");
            }
            for(byte i = 0;i<10;i++){
                MedallasPlataNOC.agregar(temp[i].getCantMedllasPlata(),temp[i]);
            }
        }

        if(opcion.equals("3")){
            System.out.println(Colores.red +Formato.negrita+"Paises con mas medallas de Bronce: ");
            System.out.println("");
            for(byte i=0;i<10;i++) {
               temp[i] = MedallasBronceNOC.obtenerYEliminar();
                System.out.println(Colores.blue +Formato.negrita+"#" +Colores.reset+ Formato.reset +(i+1));
               System.out.println(Colores.blue +Formato.negrita+"Nombre de la region: "+Colores.reset +Formato.reset +temp[i].getName());
               System.out.println(Colores.blue +Formato.negrita+"Cantidad de medallas: "+Colores.reset +Formato.reset +temp[i].getCantMedallasBronce());
               System.out.println("");
            }
            for(byte i = 0;i<10;i++){
                MedallasBronceNOC.agregar(temp[i].getCantMedallasBronce(),temp[i]);
            }
        }
        if(opcion.equals("4")) {
            System.out.println(Formato.negrita+Colores.purple+"Paises con mas medallas en General: ");
            System.out.println("");
            for (byte i = 0; i < 10; i++) {
                temp[i] = MedallasTotalesNOC.obtenerYEliminar();
                System.out.println(Colores.blue+Formato.negrita +"#" +Formato.reset+Colores.reset +(i+1));
                System.out.println(Formato.negrita+Colores.blue+"Nombre de la region: " +Colores.reset+ temp[i].getName());
                System.out.println(Formato.negrita+Colores.blue+"Cantidad de medallas: " + Colores.reset+temp[i].getCantMedallasTotales());
                System.out.println("");
            }
            for (byte i = 0; i < 10; i++) {
                MedallasTotalesNOC.agregar(temp[i].getCantMedallasTotales(), temp[i]);
            }
        }


    }

    public void imprimirMayorParticipacionFemenina() {
        if(HeapAtletasFemeninos.getSize()==0){
            generarHeapOlimpiadasFemeninas();
        }
       OlympicGame[] resultantes = new OlympicGame[10];
        System.out.println("");
        System.out.println(Formato.negrita +Colores.purple +"Top 10 ediciones de juegos olimpicos con mayor participacion de atletas femeninos" +Formato.reset); //"\033[0;1m" para negrita
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            /*
            OlympicGame og=HeapAtletasFemeninos.obtenerYEliminar();
            resultantes[i]=olimpiadasFemeninas.find(og.getName());
             */
            resultantes[i]=HeapAtletasFemeninos.obtenerYEliminar();

            System.out.println(Colores.blue +"#" +Colores.reset +(i+1));
            System.out.println(Formato.negrita+Colores.blue +"Nombre de la edición: " +Formato.reset+Colores.reset +resultantes[i].getName());
            System.out.println(Formato.negrita+Colores.blue+"Año: "+Formato.reset +Colores.reset+resultantes[i].getYear());
            System.out.println(Formato.negrita+Colores.blue +"Cantidad de participantes femeninos: "+Colores.reset +Formato.reset + resultantes[i].getCantAtletasFemeninos());
            System.out.println("");

        }
    }

    public void imprimirCiertoSexo(String opcion) {
        if(opcion.equals("1")){
            //femenino
            if(competicionesFemenino.getSize()==0){
                generarHeapCompeticionesFemenino();
            }
            Event[] eventos = new Event[10];
            for(byte i=0;i<5;i++){
                Event evento = competicionesFemenino.obtenerYEliminar();
                eventos[i] = evento;
                System.out.println(Colores.blue+Formato.negrita +"#" +Colores.reset + Formato.reset+(i+1));
                System.out.println(Colores.blue +Formato.negrita+"Nombre de la competicion: " +Colores.reset +Formato.reset+evento.getName());
                System.out.println(Colores.blue +Formato.negrita+"Deporte: "+Colores.reset +Formato.reset +evento.getSport());
                System.out.println(Colores.blue +Formato.negrita+"Sexo:" +Colores.reset +Formato.reset+"Femenino");
                System.out.println(Colores.blue +Formato.negrita+"Cantidad: "+Colores.reset +Formato.reset +evento.getAtletasFemeninos());
                System.out.println("");
            }
            for(byte i=0;i<5;i++){
                competicionesFemenino.agregar(eventos[i].getAtletasFemeninos(),eventos[i]);
            }
        }
        if(opcion.equals("2")){
            //masculino
            if(competicionesMasculino.getSize()==0){
                generarHeapCompeticionesMasculino();
            }
            Event[] eventos = new Event[10];
            for(byte i=0;i<5;i++){
                Event evento = competicionesMasculino.obtenerYEliminar();
                eventos[i] = evento;
                System.out.println(Colores.blue+Formato.negrita +"#" +Colores.reset +(i+1));
                System.out.println(Colores.blue +Formato.negrita+"Nombre de la competicion: "+Colores.reset +Formato.reset +evento.getName());
                System.out.println(Colores.blue +Formato.negrita+"Deporte: "+Colores.reset +Formato.reset +evento.getSport());
                System.out.println(Colores.blue +Formato.negrita+"Sexo:" +Colores.reset +Formato.reset+"Masculino");
                System.out.println(Colores.blue +Formato.negrita+"Cantidad: " +Colores.reset +Formato.reset+evento.getAtletasMasculinos());
                System.out.println("");
            }
            for(int i=0;i<5;i++){
                competicionesMasculino.agregar(eventos[i].getAtletasFemeninos(),eventos[i]);
            }
        }
    }

    public void imprimirEquiposEfectivosRango(int inicio, int fin) {
        generarHeapEquiposRangoEfectivo(inicio,fin);
            System.out.println("");
            System.out.println(Formato.negrita+Colores.purple +"Los equipos mas efectivos entre " +Colores.reset +Formato.reset+inicio +Colores.blue +Formato.negrita+" y " +Colores.reset +Formato.reset+fin +Colores.blue +Formato.negrita+" son:");
            System.out.println("");
        for(byte i=0;i<10;i++){
            Team equipo = HeapEquiposRangoEfectivo.obtenerYEliminar();
            int[] datos = equipo.efectivivadRangoDetalle(inicio, fin);
            System.out.println(Colores.blue+Formato.negrita +"#" +Colores.reset+Colores.reset +(i+1));
            System.out.println(Colores.blue +Formato.negrita+"Equipo: "+Colores.reset +Formato.reset+equipo.getName());
            System.out.println(Colores.blue +Formato.negrita+"Cantidad de competidores: "+Colores.reset +Formato.reset +datos[0]);
            System.out.println(Colores.blue +Formato.negrita+"Cantidad de Medallas: "+Colores.reset +Formato.reset +datos[1]);
            System.out.println(Colores.blue +Formato.negrita+"Cantidad de atletas totales: "+Colores.reset +Formato.reset +equipo.getCantidadAtletas());
            System.out.println(Colores.blue +Formato.negrita+"Ratio medalla/competidor " +Colores.reset +Formato.reset+equipo.efectividadRango(inicio,fin));
            System.out.println("");
        }
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

    private void generarHeapMedallasRegiones(String opcion){
        generarHashRegiones();
        if(opcion.equals("1")){
            if(!medallasOroRegionesExiste){
                for (int i = 0; i < lector.arrayComittees.size(); i++) {
                    String NOC = lector.arrayComittees.get(i);
                    NationalOlympicCommittee committee = lector.nationalOlympicCommittees.find(NOC);
                    this.MedallasOroNOC.agregar(committee.getCantMedallasOro(), committee);
                }
                medallasOroRegionesExiste = true;
            }
        }

        if(opcion.equals("2")){
            if(!medallasPlataRegionesExiste){
                for (int i = 0; i < lector.arrayComittees.size(); i++) {
                    String NOC = lector.arrayComittees.get(i);
                    NationalOlympicCommittee committee = lector.nationalOlympicCommittees.find(NOC);
                    this.MedallasPlataNOC.agregar(committee.getCantMedllasPlata(), committee);
                }
                medallasPlataRegionesExiste = true;
            }
        }
        if(opcion.equals("3")) {
            if (!medallasBronceRegionesExiste) {
                for (int i = 0; i < lector.arrayComittees.size(); i++) {
                    String NOC = lector.arrayComittees.get(i);
                    NationalOlympicCommittee committee = lector.nationalOlympicCommittees.find(NOC);
                    this.MedallasBronceNOC.agregar(committee.getCantMedallasOro(), committee);
                }
                medallasBronceRegionesExiste = true;
            }
        }
        if(opcion.equals("4")) {
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
    }

    public void generarHeapPlata() {
        for (int i = 0; i < lector.Atletas.size(); i++) {
            if (lector.Atletas.get(i).getMedallasPlata() > 0) {
                MedallasPlata.agregar(lector.Atletas.get(i).getMedallasPlata(), lector.Atletas.get(i));
            }
        }
    }

    private void generarHeapBronce() {
        for (int i = 0; i < lector.Atletas.size(); i++) {
            if (lector.Atletas.get(i).getMedallasBronze() > 0) {
                MedallasBronce.agregar(lector.Atletas.get(i).getMedallasBronze(), lector.Atletas.get(i));
            }
        }
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
            HeapEquiposRangoEfectivo.agregar(teamTemp.efectividadRango(inicio,fin),teamTemp);//agrega  el equipo al heap utilizando su efectividad como key
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
    }

    public void generarHashAtletasOlimpiadasFemeninas() {

        //inicializa el atributo atletas femeninos

        for (int i = 0; i < lector.Atletas.size(); i++) {//recorre todos los atletas
            Athlete athlete = lector.Atletas.get(i);
            if (athlete.getSex().equals(SexType.FEMALE)) {//se fija si es femenino
                String anterior = "";
                for (int a = 0; a < athlete.getMedallas().size(); a++) {//recorre todas las participaciones del atleta (pueden o no tener medalla)

                    AthleteOlympicParticipation participation = athlete.getMedallas().get(a);
                    if (!participation.getOlympicGame().equals(anterior)) {//si el atleta no esta contado se agrega una participacion
                        if(!olimpiadasFemeninas.contains(participation.getOlympicGame())){//si el juego olimpico todavia no esta en el hash
                            String aux = athlete.getMedallas().get(a).getOlympicGame();
                            OlympicGame olympicGame = new OlympicGame(participation);
                            olympicGame.addFemAthlete();
                            olimpiadasFemeninas.put(participation.getOlympicGame(),olympicGame);
                            arrayListOlimpiadasFemeninas.add(participation.getOlympicGame());
                        }else{
                            olimpiadasFemeninas.find(participation.getOlympicGame()).addFemAthlete();//agrega uno a la cantidad de atletas femeninos
                        }
                        anterior = participation.getOlympicGame();
                    }
                }
            }
        }
        hashOlimpiadasFemeninasExiste = true;
    }

    public void generarHeapOlimpiadasFemeninas(){

        if(!hashAtletasFemeninos){
        generarHashAtletasOlimpiadasFemeninas();
    }

        for(int i=0;i<arrayListOlimpiadasFemeninas.size();i++){//recorre todas las olimpiadas
        String keyCompeticionHash = arrayListOlimpiadasFemeninas.get(i);
        OlympicGame olimpiada = olimpiadasFemeninas.find(keyCompeticionHash);
        int keyCompeticionHeap = olimpiada.getCantAtletasFemeninos();
        HeapAtletasFemeninos.agregar(keyCompeticionHeap,olimpiada);
    }

}
}