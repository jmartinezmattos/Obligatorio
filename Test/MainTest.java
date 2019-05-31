import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void leerArchivos() {
        Main test = new Main();
        ArrayList<String[]> arrayList = new ArrayList<>(250000);
        test.leerArchivos();

        //System.out.println(arrayList.get(1)[1]);
    }
}