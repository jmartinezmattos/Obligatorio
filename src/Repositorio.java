import Entidades.Athlete;
import Entidades.AthleteOlympicParticipation;
import Entidades.NationalOlympicCommittee;
import Entidades.Team;
import Enums.MedalType;
import TADS.Hash.HashImpl;
import TADS.Heap.HeapMax;
import TADS.LinkedList.src.*;
import TADS.QuickSort.QuickSort;
import javafx.scene.control.TabPane;


import java.util.ArrayList;


public class Repositorio {

    //clase encargada de contener y manejar datos

    private Lector lector = new Lector();
    private QuickSort sorter = new QuickSort();
    private HeapMax<Integer, Athlete> MedallasOro = new HeapMax<>(14000);
    private HeapMax<Integer, Athlete> MedallasBronce = new HeapMax<>(14000);
    private HeapMax<Integer, Athlete> MedallasPlata = new HeapMax<>(14000);
    private Athlete[] obtenidos = new Athlete[10];

    private HeapMax<Integer,NationalOlympicCommittee> MedallasOroNOC = new HeapMax<>(500);
    private HeapMax<Integer,NationalOlympicCommittee> MedallasPlataNOC = new HeapMax<>(500);
    private HeapMax<Integer,NationalOlympicCommittee> MedallasBronceNOC = new HeapMax<>(500);

    private HashImpl<String,Team> equipos = new HashImpl<>(500);
    private ArrayList<String> arrayListEquipos = new ArrayList<>(250);
    private HeapMax<Integer,Team> HeapEquiposRangoEfectivo = new HeapMax<>(300);

    private boolean medallasOroExiste = false;
    private boolean medallasPlataExiste = false;
    private boolean medallasBronceExiste = false;

    private boolean medallasOroRegionesExiste = false;
    private boolean medallasPlataRegionesExiste = false;
    private boolean medallasBronceRegionesExiste = false;

    private boolean hashRegionesExiste = false;

    private boolean equiposGenerados = false;

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
                System.out.println("Cantidad De Medallas: " + aux.getMedallasOro());
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
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
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
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
                System.out.println("Año Maximo: ");
                System.out.println("Año Minimo: ");
                System.out.println("");
            }
            for (int i = 0; i < 10; i++) {
                MedallasOro.agregar(obtenidos[i].getMedallasBronze(), obtenidos[i]);//vuelve a agregar los atletas al heap para uso posterior
            }
        }

        if (num < 1 || num > 3) {
            System.out.println("Opcion no valida");
        }

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
                MedallasOroNOC.agregar(temp[i].getCantMedallasBronce(),temp[i]);
            }
        }


    }

    public void imprimirMayorParticipacionFemenina() {

    }

    public void imprimirCiertoSexo(String sexo) {
    }

    public void imprimirEquiposEfectivosRango(int inicio, int fin) {
        generarHeapEquiposRangoEfectivo(inicio,fin);
        for(int i=0;i<10;i++){
            Team equipo = HeapEquiposRangoEfectivo.obtenerYEliminar();
            int[] datos = equipo.efectivivadRangoDetalle(inicio, fin);
            System.out.println("Equipo: "+equipo.getName());
            System.out.println("Cantidad de competidores: " +datos[0]);
            System.out.println("Cantidad de Medallas: " +datos[1]);
            System.out.println("");
        }
    }

    public void generarEstructuras() {
        //genera arboles ordenados para cada consulta
        generarHeapPlata();
        generarHeapOro();
        generarHeapBronce();
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

    public ArrayList<NationalOlympicCommittee> nationalOlympicCommittees() {
        //genera un arraylist con los commites olimpicos
        ArrayList<NationalOlympicCommittee> nationalOlympicCommittees = new ArrayList<>(231);


        return nationalOlympicCommittees;
    }


    public int obtenerAñoMaximo() {
        int maximo = 0;
        int max = 0;
        ArrayList<AthleteOlympicParticipation> medal;

        for (int i = 0; i < 10; i++) {
            Athlete at = obtenidos[i];
            for (int j = 0; j < at.getMedallas().size(); j++) {
                medal = at.getMedallas();

                if (medal.get(j).getMedal().equals(MedalType.GOLD)) {
                    max = medal.get(j).getOlympicGame().getYear();
                }

                if (medal.get(j).getMedal().equals(MedalType.SILVER)) {
                    max = medal.get(j).getOlympicGame().getYear();
                }

                if (medal.get(j).getMedal().equals(MedalType.BRONZE)) {
                    max = medal.get(j).getOlympicGame().getYear();
                }

                if (max > maximo) {
                    maximo = max;
                }
            }
        }
        return maximo;
    }

    private void generarEquipos(){
        for(int i=0;i<lector.Atletas.size();i++){
            Athlete athlete = lector.Atletas.get(i);
            String teamName = athlete.getTeam();
            if(!equipos.contains(teamName)){
                //si el equipo todavia no existe
                arrayListEquipos.add(teamName);
                Team newTeam = new Team(teamName.replaceAll("-2","").replaceAll("-1",""));
                newTeam.addAtleta(athlete);
                equipos.put(teamName,newTeam);
            }
            else{
                //si el equipo ya existe
                equipos.find(teamName).addAtleta(athlete);
            }
        }
        equiposGenerados = true;
    }

    private void generarHeapEquiposRangoEfectivo(int inicio, int fin){
        if(!equiposGenerados){
            generarEquipos();
        }
        for(int i=0;i<arrayListEquipos.size();i++){
            String name = arrayListEquipos.get(i);
            Team teamTemp = equipos.find(name);
            HeapEquiposRangoEfectivo.agregar(teamTemp.efectividadRango(inicio,fin),teamTemp);
        }
    }


}

