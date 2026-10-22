package cz.uctenky;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String NAZEV = "Uctenky";
    public static final String VERZE = "1.0.0";

    public static void main(String[] args) {
        System.out.println(NAZEV + " " + VERZE);

        Obchod obchod;
        try {
            obchod = Obchod.nactiZeSouboru();
        } catch (IOException e) {
            System.out.println("Nepodarilo se nacist udaje obchodu: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        List<Polozka> polozky = nactiPolozky(scanner);

        if (polozky.size() == 0) {
            System.out.println("Nebyla zadana zadna polozka.");
            return;
        }

        Uctenka uctenka = new Uctenka(obchod, polozky);
        System.out.println();
        System.out.print(uctenka.vytvorText());
    }

    public static List<Polozka> nactiPolozky(Scanner scanner) {
        List<Polozka> polozky = new ArrayList<>();
        System.out.println("Zadavejte polozky. Prazdny nazev ukonci nakup.");

        while (true) {
            System.out.print("Nazev: ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String nazev = scanner.nextLine().trim();
            if (nazev.equals("")) {
                break;
            }

            System.out.print("Mnozstvi: ");
            double mnozstvi = nactiCislo(scanner.nextLine());
            System.out.print("Cena za kus: ");
            double cena = nactiCislo(scanner.nextLine());

            if (mnozstvi <= 0 || cena < 0) {
                System.out.println("Neplatne cislo, polozka nebyla pridana.");
            } else {
                polozky.add(new Polozka(nazev, mnozstvi, cena));
            }
        }
        return polozky;
    }

    public static double nactiCislo(String text) {
        try {
            return Double.parseDouble(text.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
