package Classes;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="pakketSeq", initialValue=1, allocationSize=100)
public class Pakket {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pakketSeq")
    private int pakketnr; // PK, AI

    @Column
    private String Naam;

    @Column
    private int aantalVolwassenen; //NN

    @Column
    private int aantalKinderen; //NN


    public Pakket( String naam, int aantalVolwassenen, int aantalKinderen) {
        Naam = naam;
        this.aantalVolwassenen = aantalVolwassenen;
        this.aantalKinderen = aantalKinderen;
    }

    public Pakket(int aantalVolwassenen, int aantalKinderen) {
        this.aantalVolwassenen = aantalVolwassenen;
        this.aantalKinderen = aantalKinderen;
    }

    public int getPakketnr() {
        return pakketnr;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String naam) {
        Naam = naam;
    }

    public int getAantalVolwassenen() {
        return aantalVolwassenen;
    }

    public void setAantalVolwassenen(int aantalVolwassenen) {
        this.aantalVolwassenen = aantalVolwassenen;
    }

    public int getAantalKinderen() {
        return aantalKinderen;
    }

    public void setAantalKinderen(int aantalKinderen) {
        this.aantalKinderen = aantalKinderen;
    }
}
