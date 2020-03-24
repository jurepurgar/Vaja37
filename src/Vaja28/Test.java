package Vaja28;

/*
Avtor: Jure Purgar
Ime datoteke: Test.java
Opis: Program za testiranje razreda Datoteka
*/

public class Test {

    public static void main(String[] args)  {
        
        // Deklariramo in inicjaliziramo nov objekt tipa Datoteka
        Datoteka d = new Datoteka("test.txt");

        // odpremo datoteko in vpišemo vsebino 
        d.odpri();
        d.vpisiVsebino("Pozdravljen");
        
        // izpišemo vsebino in velikost
        String vsebina = d.preberiVsebino();
        System.out.println("Vsebina datoteke je '" + vsebina + "'");
        System.out.println("Velikost datoteke je '" + d.getVelikost() + "'");

        // zapremo datoteko
        d.zapri();

        // poizkušamo dodati besedilo brez da bi odprli datoteko in izpišemo rezultat
        d.dodajVsebino(" svet!");
        d.odpri();
        System.out.println("Vsebina datoteke je še vedno '" + d.preberiVsebino() + "', ker pred pisanjem nismo odprli datoteke!");
        
        // dodamo vsebino s tem da je datoteka že odprta
        d.dodajVsebino(" svet!");
        System.out.println("Nova vsebina datoteke je '" + d.preberiVsebino() + "'");

        // izpišemo ime datoteke in jo poizkušamo preimenovati preimenujemo datoteko
        System.out.println("Ime datoteke je '" + d.getIme() + "'");
        d.preimenuj("novaDatoteka.txt");
        System.out.println("Ime datoteke je še vedno '" + d.getIme() + "', ker pred preimenovanjem nismo zaprli datoteke!");

        // zapremo datoteko in jo poizkušamo ponovno preimenovati
        d.zapri();
        d.preimenuj("novaDatoteka.txt");
        System.out.println("Novo ime datoteke je '" + d.getIme() + "'");


        // kreiramo Mp3 datoteko
        Mp3Datoteka mp3 = new Mp3Datoteka("muzka.mp3", "Dire Straits", "Makeing Movies", "Solid Rock");
        // odpremo in predvajamo datoteko
        mp3.odpri();
        mp3.predvajaj();
        // izpišemo katera skladba se predvaja
        System.out.println("Predvaja se: " + mp3.vrniPrikaz());

        // kreiramo jpg datoteko
        JpegDatoteka jpg = new JpegDatoteka("slika.jpg", "Janko Banko", "Somewhere");
        try {
            jpg.naloziSlikoIzInterneta("http://estudent16.kalvarija.net/spomin/images/zV_hZv4zIGM.jpg");
            System.out.println("Velikost slike je: " + jpg.getSirina() + "x" + jpg.getVisina() + " slikovnih pik.");
        } catch (Exception e) {
            System.out.println("Napaka pri nalaganju: " + e);
        }

        // prikaži sliko v spletnem brskalniku
        System.out.println("Prikazujem sliko: " + jpg.getIme() + "iz " + jpg.preberiVsebino());
        try {
            jpg.prikazi();
        } catch (Exception e) {
            System.out.println("Napaka pri prikazu slike: " + e);
        }

    }
}
