package cz.uctenky;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Uctenka {

    private static final int SIRKA = 40;

    private Obchod obchod;
    private List<Polozka> polozky;

    public Uctenka(Obchod obchod, List<Polozka> polozky) {
        this.obchod = obchod;
        this.polozky = polozky;
    }

    public double getCelkem() {
        double soucet = 0;
        for (Polozka p : polozky) {
            soucet = soucet + p.getCelkem();
        }
        return soucet;
    }

    public double getDph() {
        double celkem = getCelkem();
        return celkem * obchod.getDph() / (100 + obchod.getDph());
    }

    public String vytvorText() {
        String text = "";
        text = text + naStred(obchod.getNazev()) + "\n";
        text = text + naStred(obchod.getAdresa()) + "\n";
        text = text + naStred("ICO: " + obchod.getIco()) + "\n";
        text = text + naStred("DIC: " + obchod.getDic()) + "\n";
        text = text + cara('=') + "\n";

        for (Polozka p : polozky) {
            text = text + p.getNazev() + "\n";
            String vlevo = "  " + p.getMnozstvi() + " x " + penize(p.getCena());
            text = text + radek(vlevo, penize(p.getCelkem())) + "\n";
        }

        text = text + cara('-') + "\n";
        text = text + radek("CELKEM (" + obchod.getMena() + ")", penize(getCelkem())) + "\n";
        text = text + radek("z toho DPH " + obchod.getDph() + " %", penize(getDph())) + "\n";
        text = text + cara('=') + "\n";

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        text = text + "Datum: " + LocalDateTime.now().format(format) + "\n";
        text = text + "Obsluhoval: " + obchod.getObsluha() + "\n\n";
        text = text + naStred(obchod.getPaticka()) + "\n";
        return text;
    }

    private String penize(double castka) {
        return String.format("%.2f", castka).replace(',', '.');
    }

    private String cara(char znak) {
        String vysledek = "";
        for (int i = 0; i < SIRKA; i++) {
            vysledek = vysledek + znak;
        }
        return vysledek;
    }

    private String naStred(String text) {
        int mezery = (SIRKA - text.length()) / 2;
        String vysledek = "";
        for (int i = 0; i < mezery; i++) {
            vysledek = vysledek + " ";
        }
        return vysledek + text;
    }

    private String radek(String vlevo, String vpravo) {
        int mezery = SIRKA - vlevo.length() - vpravo.length();
        if (mezery < 1) {
            mezery = 1;
        }
        String vysledek = vlevo;
        for (int i = 0; i < mezery; i++) {
            vysledek = vysledek + " ";
        }
        return vysledek + vpravo;
    }
}
