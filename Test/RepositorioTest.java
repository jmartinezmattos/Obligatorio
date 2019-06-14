import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioTest {

    @Test
    void generarHeapPlata() {
    Repositorio repo = new Repositorio();
    repo.generarHeapPlata();
    }

    @Test
    public void generarEstructuras() {
        Repositorio repo = new Repositorio();
        repo.generarEstructuras();
        System.out.println(repo.MedallasONOC("URU"));
    }

    @Test
    public void generarEstructuras2() {
        Repositorio repo = new Repositorio();

    }
}