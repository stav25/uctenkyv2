package cz.uctenky;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class ObchodTest {

    @Test
    void nactePodlePropertiesObjektu() {
        Properties p = new Properties();
        p.setProperty("name", "Obchod");
        p.setProperty("ico", "123");
        p.setProperty("vatRate", "15");

        Obchod obchod = new Obchod(p);

        assertEquals("Obchod", obchod.getNazev());
        assertEquals("123", obchod.getIco());
        assertEquals(15, obchod.getDph(), 0.001);
        assertEquals("Kc", obchod.getMena());
    }

    @Test
    void nactePropertiesZeSouboru() throws IOException {
        Obchod obchod = Obchod.nactiZeSouboru();
        assertNotNull(obchod.getNazev());
    }
}
