import Enums.SexType;
import org.junit.Test;

public class LectorTest {

    @Test
    public void leerArchivos() {
        Lector test = new Lector();
        test.leerArchivos();
        //System.out.println(test.nationalOlympicCommittees.find("CHN").getCantMedallasOro());
        int f = 0;
        for(int i=0;i<test.Atletas.size();i++){
            if(test.Atletas.get(i).getSex().equals(SexType.FEMALE)){
                f++;
            }
        }
        System.out.println(f);
    }
}