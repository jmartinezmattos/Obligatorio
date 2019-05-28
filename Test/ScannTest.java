import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ScannTest {

    @Test
    public void name() {

        Scann scann = new Scann();

        ArrayList atheleteArray = new ArrayList(1000);

        atheleteArray = scann.cargarAthleteEvents();


    }
}