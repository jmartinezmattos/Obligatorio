import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //https://es.stackoverflow.com/questions/38085/leer-fichero-formato-csv-en-java

    public void leerArchivos(ArrayList arrayListLineas){
        String csvFile = "../athlete_events.csv";
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        String cvsSplitBy = ",";

        String linea[] = new String[15];

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                arrayListLineas.add(datos);
                crearAtleta(datos);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Athlete crearAtleta(String[] dato){//tomando el string de datos retorna un atleta
        Athlete athlete = new Athlete(dato[0],dato[1],dato[2],dato[4],dato[5]);//La edad no se agrega porque varia
        return athlete;
    }
    public AthleteOlympicParticipation crearParticipacion(String[] dato,Athlete athlete){
        AthleteOlympicParticipation participacion = new AthleteOlympicParticipation(dato[14],athlete,dato[3]);
        return participacion;
    }

}
