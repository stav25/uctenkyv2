package cz.uctenky;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PolozkaTest {

    @Test
    void celkemJeMnozstviKratCena() {
        Polozka p = new Polozka("Rohlik", 5, 2.5);
        assertEquals(12.5, p.getCelkem(), 0.001);
    }

    @Test
    void gettery() {
        Polozka p = new Polozka("Mleko", 2, 24.9);
        assertEquals("Mleko", p.getNazev());
        assertEquals(2, p.getMnozstvi(), 0.001);
        assertEquals(24.9, p.getCena(), 0.001);
    }
}
