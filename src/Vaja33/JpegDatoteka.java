package Vaja33;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/*
Avtor: Jure Purgar
Ime datoteke: Mp3Datoteka.java
Opis: Implementacija razreda JepgDatoteka ki razširi razred Datotek in implementira lastnosti specifične za Jpeg datoteke
*/

public class JpegDatoteka extends Datoteka {

    // Deklariramo lastnosti
    private String avtor;
    private String lokacija;
    private int visina;
    private int sirina;

    // Konstruktor s katerim ustvarimo nov objekt razreda Mp3Datoteka
    public JpegDatoteka(String imeDatoteke, String avtor, String lokacija) {
        // pokličemo konstruktor nadrazreda
        super(imeDatoteke);
        this.avtor = avtor;
        this.lokacija = lokacija;
    }

    // vrne avtorja fotografije
    public String getAvtor() {
        return avtor;
    }

    // vrne lokacijo fotografije
    public String getLokacija() {
        return lokacija;
    }

    // vrne širino slike v px
    public int getSirina() {
        return sirina;
    }

    // vrne višino slike v px
    public int getVisina() {
        return visina;
    }

    // naloži sliko iz interneta prebere višino in širino, ter shrani url kot vsebino
    public void naloziSlikoIzInterneta(String url) throws Exception {
        // naložimo sliko iz interneta
        BufferedImage image = ImageIO.read(new URL(url));
        // shranimo višino in širino v lastnosti
        visina = image.getHeight();
        sirina = image.getWidth();
        // url vpišemo kot vsebino datoteke
        odpri();
        vpisiVsebino(url);
        zapri();
    }

    public void prikazi() throws Exception {
        // prikažemo slioko v spletnem brskalniku s tem da url preberemo iz vsebine
        odpri();
        if (preberiVsebino() != null) {
            Runtime.getRuntime().exec("cmd /c start " + preberiVsebino());
        }
        zapri();
    }
}