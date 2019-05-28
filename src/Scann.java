import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scann {

    public ArrayList cargarAthleteEvents(){
        File athlete_events = new File("athlete_events.csv");
        ArrayList<String> atheleteArray = new ArrayList(2200000);

        {
            try {
                Scanner scannAthleteEv = new Scanner(athlete_events);
                int i = 0;
                while (scannAthleteEv.hasNext()) {
                    String data = scannAthleteEv.next();
                    String[] values = data.split(",");//convierte cada linea en un array de strings separados por la coma
                    //atheleteArray.set(i,data);
                    i++;
                    System.out.println(values[1]);
                }
                System.out.println(i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return atheleteArray;
    }



}
