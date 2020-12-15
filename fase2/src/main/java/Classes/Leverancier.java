package Classes;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="leverancierSeg", initialValue=1, allocationSize=100)
public class Leverancier {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="leverancierSeg")
    private int levnr; // PK, NN, AI

    @Column
    private int anr; // FK,

    @Column
    private String naam; //NN

    @Column
    private int postcode;//NN

    @Column
    private String straat;//NN

    @Column
    private String huisnummer;//NN


    public Leverancier(int anr, String naam, int postcode, String straat, String huisnummer) {
        this.anr = anr;
        this.naam = naam;
        this.postcode = postcode;
        this.straat = straat;
        this.huisnummer = huisnummer;
    }

    public Leverancier(String naam, int postcode, String straat, String huisnummer) {

        this.naam = naam;
        this.postcode = postcode;
        this.straat = straat;
        this.huisnummer = huisnummer;
    }

    public int getLevnr() {
        return levnr;
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

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
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
}
