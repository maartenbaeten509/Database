package Classes;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="leveringSeq", initialValue=1, allocationSize=100)
public class Levering {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="leveringSeq")
    int leveringnr;

    @ManyToOne
    @JoinColumn(name ="aanbodnr")
    Aanbod aanbod;

    @ManyToOne
    @JoinColumn(name ="klantnr")
    Klant klant;

    Boolean afgehaald;
    int weeknr;

    public Levering(Aanbod aanbod, Klant klant, Boolean afgehaald, int weeknr) {
        this.aanbod = aanbod;
        this.klant = klant;
        this.afgehaald = afgehaald;
        this.weeknr = weeknr;
    }


    public int getLeveringnr() {
        return leveringnr;
    }

    public Aanbod getAanbod() {
        return aanbod;
    }

    public void setAanbod(Aanbod aanbod) {
        this.aanbod = aanbod;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Boolean getAfgehaald() {
        return afgehaald;
    }

    public void setAfgehaald(Boolean afgehaald) {
        this.afgehaald = afgehaald;
    }

    public int getWeeknr() {
        return weeknr;
    }

    public void setWeeknr(int weeknr) {
        this.weeknr = weeknr;
    }
}
