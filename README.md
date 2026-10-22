Uctenky
Jednoduchy konzolovy nastroj pro tisk uctenky (jako v samoobsluze). Cviceni c. 5, tym 2.

Autori: Vaclav Stary, Simon Husar, Marek Bartos, Matus Gondas

Aktualni verze: 1.0.0 (semanticke verzovani)

Pozadavky
Java 17+
Maven 3.8+ (pro sestaveni)
Sestaveni a spusteni
mvn clean package          # zkompiluje, spusti testy, vytvori target/uctenky.jar
java -jar target/uctenky.jar
Volby: -c soubor.properties (vlastni konfigurace obchodu), -v verze, -h napoveda.

Jak to funguje
Opakujici se udaje (nazev, adresa, ICO, DIC, obsluha, paticka, mena, sazba DPH) se nacitaji ze souboru obchod.properties (vzor: src/main/resources/obchod.properties; bez nej se pouzije kopie vestavena v jaru, vlastni soubor lze zadat pres -c).
Polozky nakupu se zadavaji z prikazove radky, jedna na radek ve tvaru nazev;mnozstvi;cena (desetinna carka i tecka). Prazdny radek ukonci zadavani a vytiskne se uctenka.
Priklad:

printf 'Rohlik;5;2,50\nMleko;2;24.90\n\n' | java -jar target/uctenky.jar
Vytvoreni dalsi verze
V pom.xml zmente <version> (napr. 1.0.0 -> 1.1.0; patch = oprava, minor = nova funkce, major = nekompatibilni zmena).
mvn clean package - testy musi projit.
Commit, tag a push: git tag v1.1.0 && git push --tags.
Na GitHubu vytvorte Release a pripojte target/uctenky.jar.
Testy
mvn test