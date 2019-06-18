import FormatoTexto.Colores;
import FormatoTexto.Formato;

import java.awt.font.TextAttribute;
import java.util.Scanner;

public class Menu {

    private static Repositorio repo = null;

    public static void main(String args[]){

        String continuar = "n";

        esperaCarga();

        Scanner entero = new Scanner(System.in);
        Scanner letra = new Scanner(System.in);
        String carga;
        //printHeader();
       // carga = letra.nextLine();
       // if(carga.equals("y")){
           // repo.generarEstructuras();
       // }

        do{
            printHeader2();
            int opcion = entero.nextInt();
            evaluarOperacion(opcion);
            System.out.println("Desea realizar otra operacion? y/n");
            continuar = letra.nextLine();
        }
        while(continuar.equals("y"));
    }

    private static void esperaCarga(){
        System.out.println("Presione cualquier tecla y enter para continuar");
        Scanner sc = new Scanner(System.in);
        String cualquierTecla = "cualquierTecla";
        cualquierTecla = sc.nextLine();
        if(cualquierTecla.equals("easter")){
            System.out.println("egg");
        }
        repo = new Repositorio();
    }

    private static void printHeader(){
        System.out.println("Bienvendido al gestor oficial de estadisticas de las olimpiadas");
        System.out.println("");
        System.out.println("¿Desea precargar estructuras? y/n");
        System.out.println("");

    }

    private static void printHeader2(){
        System.out.println(Formato.negrita +"Seleccione la operacion que desea realizar");//cuando puse formato negrita me tiro warning
        System.out.println(Colores.reset +"1: Top 10 atletas con mayor cantidad de medallas");
        System.out.println("2: Top 10 regiones con mayor cantidad de medallas");
        System.out.println("3: Top 10 ediciones de juegos olimpicos con mayor participacion de atletas femeninos");
        System.out.println("4: 5 competiciones donde se presentan la mayor cantidad de atletas de cierto sexo");
        System.out.println("5: 10 equipos mas efectivos entre un rango de anios");
    }

    private static void evaluarOperacion(int opcion){

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        byte num;
        String lectura;

        switch (opcion){
            case 1:
                System.out.println("Ingrese una opcion: ");
                System.out.println("1: Oro");
                System.out.println("2: Plata");
                System.out.println("3: Bronze");
                System.out.println("4: Todas");
                num = sc2.nextByte();
                System.out.println("La cantidad de medallas obtenidas de la region seleccionada es: ");
                repo.imprimirAtletasConMasMedallas(num);
                break;
            case 2:
                System.out.println("Ingrese una opcion: ");
                System.out.println("1: Oro");
                System.out.println("2: Plata");
                System.out.println("3: Bronze");
                System.out.println("4: Todas");
                num = sc2.nextByte();
                if(num<1 || num>4) {
                    System.out.println("Opcion no valida");
                }
                else{
                    repo.imprimirRegionesConMasMedallas(num);
                }
                break;
            case 3:
                    repo.imprimirMayorParticipacionFemenina();
                break;
            case 4:
                System.out.println("Seleccione el sexo: ");
                System.out.println("1: Femenino");
                System.out.println("2: Masculino");
                opcion = sc2.nextInt();
                repo.imprimirCiertoSexo(opcion);
                break;
            case 5:
                System.out.println("Ingrese el rango de anios separado por un guion ej: 1990-2005");
                lectura = sc.nextLine();
                String[] datos = lectura.split("-");
                repo.imprimirEquiposEfectivosRango(Integer.valueOf(datos[0]),Integer.valueOf(datos[1]));
                break;
        }
    }
}
