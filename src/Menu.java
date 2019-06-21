import FormatoTexto.Colores;
import FormatoTexto.Formato;
import java.util.Scanner;

public class Menu {

    private static Repositorio repo = null;

    public static void main(String args[]){

        String continuar = "n";

        esperaCarga();

        Scanner entero = new Scanner(System.in);
        Scanner letra = new Scanner(System.in);

        do{
            printHeader2();
            String opcion = entero.nextLine();
            evaluarOperacion(opcion);
            System.out.println(Formato.negrita+Colores.cyan+"Desea realizar otra operacion? y/n");
            continuar = letra.nextLine();
            if(continuar.equals("easter")){
                System.out.println("egg");
                continuar = letra.nextLine();
            }
        }
        while(continuar.equals("y"));
    }

    private static void esperaCarga(){
        System.out.println(Colores.cyan+Formato.negrita+"Presione una tecla y enter para continuar");
        Scanner sc = new Scanner(System.in);
        String cualquierTecla = "cualquierTecla";
        cualquierTecla = sc.nextLine();
        if(cualquierTecla.equals("easter")){
            System.out.println("egg");
        }
        repo = new Repositorio();
    }

    private static void printHeader2(){
        System.out.println(Formato.negrita +Colores.purple+"Seleccione la operacion que desea realizar");//cuando puse formato negrita me tiro warning
        System.out.println(Colores.reset +"1: Top 10 atletas con mayor cantidad de medallas");
        System.out.println("2: Top 10 regiones con mayor cantidad de medallas");
        System.out.println("3: Top 10 ediciones de juegos olimpicos con mayor participacion de atletas femeninos");
        System.out.println("4: 5 competiciones donde se presentan la mayor cantidad de atletas de cierto sexo");
        System.out.println("5: 10 equipos mas efectivos entre un rango de años");
    }

    private static void evaluarOperacion(String opcion){

        Scanner sc = new Scanner(System.in);
        String num;
        String lectura;

        switch (opcion){
            case "1":
                System.out.println(Formato.negrita+"Ingrese una opcion: ");
                System.out.println(Colores.yellow+"1: Oro");
                System.out.println(Colores.white+"2: Plata");
                System.out.println(Colores.red+"3: Bronze");
                System.out.println(Colores.blue+"4: Todas");
                num = sc.nextLine();
                repo.imprimirAtletasConMasMedallas(num);
                break;
            case "2":
                System.out.println(Formato.negrita+"Ingrese una opcion: ");
                System.out.println(Colores.yellow+"1: Oro");
                System.out.println(Colores.white+"2: Plata");
                System.out.println(Colores.red+"3: Bronze");
                System.out.println(Colores.blue+"4: Todas");
                num = sc.nextLine();

                repo.imprimirRegionesConMasMedallas(num);
                break;
            case "3":
                    repo.imprimirMayorParticipacionFemenina();
                break;
            case "4":
                System.out.println(Formato.negrita+"Seleccione el sexo: ");
                System.out.println(Colores.purple+"1: Femenino");
                System.out.println(Colores.blue+"2: Masculino");
                opcion = sc.nextLine();
                repo.imprimirCiertoSexo(opcion);
                break;
            case "5":
                System.out.println(Formato.negrita+ "Ingrese el rango de años separado por un guion ej: 1990-2005");
                lectura = sc.nextLine();
                String[] datos = lectura.split("-");
                repo.imprimirEquiposEfectivosRango(Integer.valueOf(datos[0]),Integer.valueOf(datos[1]));
                break;
        }
    }
}
