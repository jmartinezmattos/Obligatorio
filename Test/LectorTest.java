import org.junit.Test;

public class LectorTest {

    @Test
    public void leerArchivos() {
        Lector test = new Lector();
        test.leerArchivos();
        System.out.println(test.nationalOlympicCommittees.find("URU").getRegion());

    }
}