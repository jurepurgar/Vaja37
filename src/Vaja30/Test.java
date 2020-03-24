package Vaja30;

/*
Avtor: Jure Purgar
Ime datoteke: Test.java
Opis: Program za testiranje razreda Datoteka
*/

public class Test {

    public static void main(String[] args)  {
        
        // Deklariramo in inicjaliziramo nov objekt tipa Datoteka
        Datoteka d = new Datoteka("test.txt");

        // poizkušamo pprebrati vsebino in velikost
        try {
            // odpremo datoteko in vpišemo vsebino 
            d.odpri();
            d.vpisiVsebino("Pozdravljen");

            String vsebina = d.preberiVsebino();
            System.out.println("Vsebina datoteke je '" + vsebina + "'");
            System.out.println("Velikost datoteke je '" + d.getVelikost() + "'");
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

        // zapremo datoteko
        d.zapri();

        try
        {
            // poizkušamo dodati besedilo brez da bi odprli datoteko in izpišemo rezultat
            d.dodajVsebino(" svet!");
            System.out.println("Vsebina datoteke je še vedno '" + d.preberiVsebino() + "', ker pred pisanjem nismo odprli datoteke!");
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

    }
}
