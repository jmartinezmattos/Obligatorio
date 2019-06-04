import java.util.Scanner;

public class Menu {

    private static Repositorio repo = new Repositorio();

    public static void main(String args[]){
        Scanner entero = new Scanner(System.in);
        printHeader();
        int opcion = entero.nextInt();
        evaluarOperacion(opcion);
    }

    private static void printHeader(){
        System.out.println("Bienvendido al gestor oficial de estadisticas de las olimpiadas");
        System.out.println();
        System.out.println("Seleccione la operacion que desea realizar");
        System.out.println("1: Top 10 atletas con mayor cantidad de medallas");
        System.out.println("2: Top 10 regiones con mayor cantidad de medallas");
        System.out.println("3: Top 10 ediciones de juegos olimpicos con mayor participacion de atletas femeninos");
        System.out.println("4: 5 competiciones donde se presentan la mayor cantidad de atletas de cierto sexo");
        System.out.println("5: 10 equipos mas efectivos entre un rango de anios");

    }

    private static void evaluarOperacion(int opcion){

        Scanner sc = new Scanner(System.in);
        String lectura;

        switch (opcion){
            case 1:
                System.out.println("Ingrese una opcion: ");
                System.out.println("Oro (o)");
                System.out.println("Plata (p)");
                System.out.println("Bronze (b)");
                lectura = sc.nextLine();
                repo.imprimirAtletasConMasMedallas(lectura);

            case 2:
                System.out.println("Ingrese una opcion: ");
                System.out.println("Oro (o)");
                System.out.println("Plata (p)");
                System.out.println("Bronze (b)");
                lectura = sc.nextLine();
                repo.imprimirRegionesConMasMedallas(lectura);
            case 3:
                repo.imprimirMayorParticipacionFemenina();
            case 4:
                System.out.println("Seleccione el sexo f (femenino) o m (masculino)");
                lectura = sc.nextLine();
                repo.imprimirCiertoSexo(lectura);
            case 5:
                System.out.println("Ingrese el rango de anios separado por un guion ej: 1990-2005");
                lectura = sc.nextLine();
                repo.imprimirEquiposEfectivosRango(lectura);
        }
    }
}
