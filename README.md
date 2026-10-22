# Uctenky

Jednoduchy konzolovy program pro tisk uctenky (jako v samoobsluze). Cviceni c. 5, tym 2.

## Autori

- Vaclav Stary
- Simon Husar
- Marek Bartos
- Matus Gondas

## Verze

Aktualni verze: **1.0.0** (semanticke verzovani `MAJOR.MINOR.PATCH`).

## Navod krok za krokem

### 1. Instalace potrebnych nastroju

Potrebujete **Git**, **Javu 17 nebo novejsi** a **Maven 3.8 nebo novejsi**.

macOS (pres [Homebrew](https://brew.sh)):

```bash
brew install git
brew install openjdk@17
brew install maven
```

Windows: nainstalujte [Git](https://git-scm.com/downloads), [JDK 17+](https://adoptium.net) a
[Maven](https://maven.apache.org/download.cgi) (rozbalte a pridejte slozku `bin` do promenne `PATH`).

Overeni, ze vse funguje (kazdy prikaz musi vypsat verzi):

```bash
git --version
java -version
mvn -version
```

### 2. Stazeni projektu

Poprve (naklonovani repozitare):

```bash
git clone https://github.com/stav25/uctenkyv2.git
cd uctenkyv2
```

Pokud uz projekt mate stazeny a chcete jen nejnovejsi zmeny:

```bash
cd uctenkyv2
git pull
```

Kdyz `git pull` napise, ze se vetve rozesly (divergent branches), pouzijte `git pull --rebase`.

### 3. Sestaveni

```bash
mvn clean package
```

Prikaz smaze stary vystup, zkompiluje program, spusti testy a vytvori spustitelny soubor
`target/uctenky.jar`. Musi skoncit hlaskou `BUILD SUCCESS`. Pri prvnim spusteni se stahuji knihovny,
takze to trva o neco dele.

### 4. Spusteni

```bash
java -jar target/uctenky.jar
```

Program se postupne pta na nazev, mnozstvi a cenu za kus. Kazdy udaj potvrdte klavesou Enter
(desetinna carka i tecka jsou povoleny). **Prazdny nazev** (jen Enter) ukonci zadavani a vytiskne se uctenka.

Priklad bez rucniho psani:

```bash
printf 'Rohlik\n5\n2,50\nMleko\n2\n24.90\n\n' | java -jar target/uctenky.jar
```

Program lze spustit i z IntelliJ IDEA: otevrete `src/main/java/cz/uctenky/Main.java`
a kliknete na zelenou sipku vedle metody `main`.

### 5. Zmena udaju na uctence

Opakujici se udaje (nazev obchodu, adresa, ICO, DIC, obsluha, paticka, mena, sazba DPH) jsou v souboru
`src/main/resources/obchod.properties`. Po jeho upraveni je potreba znovu spustit `mvn clean package`,
aby se zmena dostala do jaru.

### 6. Testy

```bash
mvn test
```

Testy (JUnit 5) pokryvaji tridy `Polozka`, `Obchod`, `Uctenka` a nacitani polozek v `Main`.

## Struktura projektu

| Cesta | Obsah |
|---|---|
| `src/main/java/cz/uctenky/Main.java` | spusteni programu, nacitani polozek od uzivatele |
| `src/main/java/cz/uctenky/Polozka.java` | jedna polozka nakupu |
| `src/main/java/cz/uctenky/Obchod.java` | udaje obchodu nactene ze souboru |
| `src/main/java/cz/uctenky/Uctenka.java` | sestaveni textu uctenky |
| `src/main/resources/obchod.properties` | opakujici se udaje na uctence |
| `src/test/java/cz/uctenky/` | unit testy |
| `target/` | vystup sestaveni (vznika automaticky, necommituje se) |

## Jak vytvorit dalsi verzi

1. Zvolte cislo nove verze podle pravidel semantickeho verzovani: oprava chyby zvysuje PATCH (`1.0.0` -> `1.0.1`),
   nova funkce MINOR (`1.0.0` -> `1.1.0`), nekompatibilni zmena MAJOR (`1.0.0` -> `2.0.0`).
2. Zmente cislo verze na **dvou mistech**:
   - v `pom.xml` v elementu `<version>` projektu,
   - v `src/main/java/cz/uctenky/Main.java` v konstante `VERZE` (a v testu `MainTest`, ktery ji kontroluje).
3. Spustte `mvn clean package`. Vsechny testy musi projit a vznikne `target/uctenky.jar`.
4. Zmeny commitnete a pushnete, pak vytvorte tag: `git tag v1.1.0 && git push --tags`.
5. Na GitHubu vytvorte Release k tomuto tagu a pripojte soubor `target/uctenky.jar`.

## Caste problemy

- **`mvn: command not found`**: Maven neni nainstalovany nebo neni v `PATH` (viz krok 1). Po instalaci
  otevrete novy terminal.
- **`Unable to access jarfile`**: jeste jste nespustili `mvn clean package`, nebo jste ve spatne slozce
  (musite byt ve slozce `uctenkyv2`).
- **`no POM in this directory`**: Maven spoustite mimo slozku projektu, pouzijte `cd uctenkyv2`.
- **`git push` odmitnut (403)**: nemate pravo zapisu do repozitare, pozadejte majitele o pridani
  mezi spolupracovniky (Settings -> Collaborators).
- **Chyba `Neplatne cislo, polozka nebyla pridana`**: mnozstvi musi byt kladne a cena nezaporna. Pri rucnim
  psani nezadavejte `\n`, novy radek je klavesa Enter.
