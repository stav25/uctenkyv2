# Uctenky

Jednoduchy konzolovy program pro tisk uctenky (jako v samoobsluze). Cviceni c. 5, tym 2.

## Autori

- Vaclav Stary
- Simon Husar
- Marek Bartos
- Matus Gondas

## Verze

Aktualni verze: **1.0.0** (semanticke verzovani `MAJOR.MINOR.PATCH`).

## Pozadavky

- Java 17 nebo novejsi
- Maven 3.8 nebo novejsi (pro sestaveni)

## Sestaveni a spusteni

```bash
mvn clean package
java -jar target/uctenky.jar
```

`mvn clean package` program zkompiluje, spusti testy a vytvori spustitelny soubor `target/uctenky.jar`.

## Jak program funguje

- **Opakujici se udaje** (nazev obchodu, adresa, ICO, DIC, obsluha, paticka, mena, sazba DPH) se nacitaji
  ze souboru `src/main/resources/obchod.properties`. Po zmene tohoto souboru je potreba znovu spustit
  `mvn clean package`.
- **Polozky nakupu** se zadavaji z prikazove radky. Program se postupne pta na nazev, mnozstvi a cenu za kus
  (kazdy udaj potvrdte klavesou Enter, desetinna carka i tecka jsou povoleny). Prazdny nazev ukonci zadavani
  a program vytiskne uctenku.

Ukazka vstupu bez rucniho psani:

```bash
printf 'Rohlik\n5\n2,50\nMleko\n2\n24.90\n\n' | java -jar target/uctenky.jar
```

## Jak vytvorit dalsi verzi

1. Zvolte cislo nove verze podle pravidel semantickeho verzovani: oprava chyby zvysuje PATCH (`1.0.0` -> `1.0.1`),
   nova funkce MINOR (`1.0.0` -> `1.1.0`), nekompatibilni zmena MAJOR (`1.0.0` -> `2.0.0`).
2. Zmente cislo verze na **dvou mistech**:
   - v `pom.xml` v elementu `<version>` projektu,
   - v `src/main/java/cz/uctenky/Main.java` v konstante `VERZE` (a v testu `MainTest`, ktery ji kontroluje).
3. Spustte `mvn clean package`. Vsechny testy musi projit a vznikne `target/uctenky.jar`.
4. Zmeny commitnete a pushnete, pak vytvorte tag: `git tag v1.1.0 && git push --tags`.
5. Na GitHubu vytvorte Release k tomuto tagu a pripojte soubor `target/uctenky.jar`.

## Testy

```bash
mvn test
```

Testy (JUnit 5) pokryvaji tridy `Polozka`, `Obchod`, `Uctenka` a nacitani polozek v `Main`.
