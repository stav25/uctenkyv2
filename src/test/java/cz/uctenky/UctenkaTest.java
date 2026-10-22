package cz.uctenky;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class UctenkaTest {

    private Uctenka vytvor() {
        Properties p = new Properties();
        p.setProperty("name", "Test Shop");
        p.setProperty("cashier", "Jana");
        p.setProperty("footer", "Diky!");
        p.setProperty("vatRate", "21");

        List<Polozka> polozky = new ArrayList<>();
        polozky.add(new Polozka("Rohlik", 5, 2.5));
        polozky.add(new Polozka("Mleko", 2, 24.9));
        return new Uctenka(new Obchod(p), polozky);
    }

    @Test
    void celkemSecteVsechnyPolozky() {
        assertEquals(62.3, vytvor().getCelkem(), 0.001);
    }

    @Test
    void dphJeObsazenoVCene() {
        assertEquals(10.81, vytvor().getDph(), 0.01);
    }

    @Test
    void textObsahujeHlavniUdaje() {
        String text = vytvor().vytvorText();
        assertTrue(text.contains("Test Shop"));
        assertTrue(text.contains("Rohlik"));
        assertTrue(text.contains("Mleko"));
        assertTrue(text.contains("62.30"));
        assertTrue(text.contains("Obsluhoval: Jana"));
        assertTrue(text.contains("Diky!"));
    }
}
