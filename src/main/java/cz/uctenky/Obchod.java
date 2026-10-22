package cz.uctenky;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Obchod {

    private String nazev;
    private String adresa;
    private String ico;
    private String dic;
    private String obsluha;
    private String paticka;
    private String mena;
    private double dph;

    public Obchod(Properties p) {
        nazev = p.getProperty("name", "");
        adresa = p.getProperty("address", "");
        ico = p.getProperty("ico", "");
        dic = p.getProperty("dic", "");
        obsluha = p.getProperty("cashier", "");
        paticka = p.getProperty("footer", "");
        mena = p.getProperty("currency", "Kc");
        dph = Double.parseDouble(p.getProperty("vatRate", "21"));
    }

    public static Obchod nactiZeSouboru() throws IOException {
        Properties p = new Properties();
        InputStream vstup = Obchod.class.getResourceAsStream("/obchod.properties");
        if (vstup == null) {
            throw new IOException("Soubor obchod.properties nebyl nalezen.");
        }
        p.load(vstup);
        vstup.close();
        return new Obchod(p);
    }

    public String getNazev() {
        return nazev;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getIco() {
        return ico;
    }

    public String getDic() {
        return dic;
    }

    public String getObsluha() {
        return obsluha;
    }

    public String getPaticka() {
        return paticka;
    }

    public String getMena() {
        return mena;
    }

    public double getDph() {
        return dph;
    }
}
