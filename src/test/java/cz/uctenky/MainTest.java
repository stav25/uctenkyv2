package cz.uctenky;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void nactePolozkyDoPrazdnehoNazvu() {
        Scanner scanner = new Scanner("Chleb\n1\n30\nMleko\n2\n20,5\n\n");
        List<Polozka> polozky = Main.nactiPolozky(scanner);
        assertEquals(2, polozky.size());
        assertEquals("Mleko", polozky.get(1).getNazev());
        assertEquals(41.0, polozky.get(1).getCelkem(), 0.001);
    }

    @Test
    void spatnaCislaSePreskoci() {
        Scanner scanner = new Scanner("Chleb\nabc\n30\n\n");
        assertEquals(0, Main.nactiPolozky(scanner).size());
    }

    @Test
    void nactiCisloAkceptujeCarku() {
        assertEquals(2.5, Main.nactiCislo("2,5"), 0.001);
        assertEquals(-1, Main.nactiCislo("xyz"), 0.001);
    }

    @Test
    void verzeJeNastavena() {
        assertEquals("1.0.1", Main.VERZE);
    }
}
