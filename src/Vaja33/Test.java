package Vaja33;

import java.io.*;
import java.util.ArrayList;

/*
Avtor: Jure Purgar
Ime datoteke: Test.java
Opis: Program za testiranje razreda Datoteka
*/

public class Test {

    // deklariramo reader
    private static BufferedReader in;

    public static void main(String[] args)  {
        // inicjaliziramo bralnik
        in = new BufferedReader(new InputStreamReader(System.in));

        // ustvarimo nov seznam datotek
        ArrayList<Datoteka> datoteke = new ArrayList<Datoteka>();

        try {
            // deklariramo spremenljivko za branje vsebine ter števec
            String vsebina;
            int c = 0;

            // sprašujemo uporabnika po vsebini za novo datoteko dokler ne vnese prazne vrstice
            do  {
                // povečamo števec
                c++;

                // uporabnika vprašamo po željeni vsebini datoteke in preberemo rezultat
                System.out.println("Vnesite željeno vsebino datoteke " + c + ":");
                vsebina = in.readLine();

                if (!vsebina.isEmpty()) { // če uporabnik ni vnesel prazne vrstice ustvarimo nov element v seznamu
                    // ustvarimo nov objekt razreda Datoteka
                    Datoteka d = new Datoteka("datoteka" + c + ".txt");

                    // vpišemo vsebino v datoteko
                    d.odpri();
                    d.vpisiVsebino(vsebina);
                    d.zapri();

                    // dodamo nov objekt tipa datoteka v seznam
                    datoteke.add(d);
                } else {
                    // uporabnika obvestimo da je našanje končano
                    System.out.println("Vnašanje končano ker ste vnesli prazno vsebino.");
                }
            } while (!vsebina.isEmpty()); // ponavljamo dokler uporabnik ne vnese prazne vrstice

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

        for (Datoteka d : datoteke) {

            // inicjaliziramo spremenljivko
            String vsebina = "Neznana vsebina!";

            // poizkušamo prebrati vsebino preberemo vsebino datoteke
            try {
                d.odpri();
                vsebina = d.preberiVsebino();
                d.zapri();
            } catch (Exception e) {
                // če pride do napake pri branju dvignemo izjemo
                System.out.println("napaka pri branju: " + e);
            }

            // izpišemo vsebino datoteke
            System.out.println("Vsebina datoteke '" + d.getIme() + "' je: " + vsebina);
        }

    }
}
