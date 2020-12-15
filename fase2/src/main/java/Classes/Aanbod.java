package Classes;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@SequenceGenerator(name="aanbodSeq", initialValue=1, allocationSize=100)
public class Aanbod {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aanbodSeq")
    private int aanbodnr; // PK, NN, AI

    @Column
    private int levnr; // FK, NN

    @Column
    private int pakketnr; // FK, NN

    @Column
    private int prijs; // NN

    //relatie weeksamenstelling
    @OneToMany(mappedBy = "aanbod")
    List<Weeksamenstelling> samenstelling;

    //relatie levering
    @OneToMany(mappedBy = "aanbod")
    List<Levering> levering;

    public Aanbod(int levnr, int pakketnr, int prijs, List<Weeksamenstelling> samenstelling, List<Levering> levering) {
        this.levnr = levnr;
        this.pakketnr = pakketnr;
        this.prijs = prijs;
        this.samenstelling = samenstelling;
        this.levering = levering;
    }
/*
    public Aanbod(int levnr, int pakketnr, int prijs) {
        this.levnr = levnr;
        this.pakketnr = pakketnr;
        this.prijs = prijs;

    }*/

    public int getAanbodnr() {
        return aanbodnr;
    }

    public List<Weeksamenstelling> getSamenstelling() {
        return samenstelling;
    }

    public void setSamenstelling(List<Weeksamenstelling> samenstelling) {
        this.samenstelling = samenstelling;
    }

    public List<Levering> getLevering() {
        return levering;
    }

    public void setLevering(List<Levering> levering) {
        this.levering = levering;
    }

    public int getLevnr() {
        return levnr;
    }

    public void setLevnr(int levnr) {
        this.levnr = levnr;
    }

    public int getPakketnr() {
        return pakketnr;
    }

    public void setPakketnr(int pakketnr) {
        this.pakketnr = pakketnr;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }
}
