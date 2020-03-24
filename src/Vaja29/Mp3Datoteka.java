package Vaja29;

/*
Avtor: Jure Purgar
Ime datoteke: Mp3Datoteka.java
Opis: Implementacija razreda Mp3Datoteka ki razširi razred Datotek in implementira lastnosti specifične za Mp3 datoteke
*/

public class Mp3Datoteka extends Datoteka {
    
    // Deklariramo lastnosti
    private String izvajalec;
    private String album;
    private String naslov;

    // Konstruktor s katerim ustvarimo nov objekt razreda Mp3Datoteka
    public Mp3Datoteka(String imeDatoteke, String izvajalec, String album, String naslov) {
        // pokličemo konstruktor nadrazreda
        super(imeDatoteke);
        this.izvajalec = izvajalec;
        this.album = album;
        this.naslov = naslov;
    }

    // vrne izvajalca
    public String getIzvajalec() {
        return izvajalec;
    }

    // vrne album
    public String getAlbum() {
        return album;
    }

    // vrne naslov
    public String getNaslov() {
        return naslov;
    }

    // metoda ki vrne izvajalca in naslov
    public String vrniPrikaz() {
        return izvajalec + " - " + naslov;
    }

    // metoda za predvajanje vsebine
    public void predvajaj() {

        if (this.jeOdprta) {
            // predvajaj vsebino 
        }
    }
}