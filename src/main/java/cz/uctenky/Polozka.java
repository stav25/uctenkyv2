package cz.uctenky;

public class Polozka {

    private String nazev;
    private double mnozstvi;
    private double cena;

    public Polozka(String nazev, double mnozstvi, double cena) {
        this.nazev = nazev;
        this.mnozstvi = mnozstvi;
        this.cena = cena;
    }

    public String getNazev() {
        return nazev;
    }

    public double getMnozstvi() {
        return mnozstvi;
    }

    public double getCena() {
        return cena;
    }

    public double getCelkem() {
        return mnozstvi * cena;
    }
}
