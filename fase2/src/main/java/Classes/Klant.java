package Classes;

import javax.persistence.*;
import java.util.Set;

@Entity
@SequenceGenerator(name="klantSeq", initialValue=1, allocationSize=100)
public class Klant {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="klantSeq")
    private int klantnr; // PK, NN, AI

    @Column (name = "artiestnr")
    private int anr; // FK

    @Column (name = "naam")
    private String naam;

    @Column (name = "straat")
    private String straat;

    @Column (name = "huisnr")
    private String huisnummer;

    @Column (name = "postcode")
    private int postcode;

    //relatie levering
    @OneToMany(mappedBy = "klant")
    Set<Levering> levering;

    public Klant(int anr, String naam, String straat, String huisnummer, int postcode, Set<Levering> levering) {
        this.anr = anr;
        this.naam = naam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.levering = levering;
    }

    public Klant(String naam, String straat, String huisnummer, int postcode, Set<Levering> levering) {
        this.naam = naam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.levering = levering;
    }

    public Klant( String straat, String huisnummer, int postcode, Set<Levering> levering) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.levering = levering;
    }
    public Klant( String huisnummer, int postcode, Set<Levering> levering) {
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.levering = levering;
    }
    public Klant(  int postcode, Set<Levering> levering) {
        this.postcode = postcode;
        this.levering = levering;
    }
    public Klant( Set<Levering> levering) {
        this.levering = levering;
    }
    public Klant( String naam, String straat, String huisnummer, int postcode) {
        this.naam = naam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
    }




    public Set<Levering> getLevering() {
        return levering;
    }

    public void setLevering(Set<Levering> levering) {
        this.levering = levering;
    }

    public int getKlantnr() {
        return klantnr;
    }


    public int getAnr() {
        return anr;
    }

    public void setAnr(int anr) {
        this.anr = anr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
