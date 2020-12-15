package Classes;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="auteurSeq", initialValue=1, allocationSize=100)
public class Auteur {

    @Column(name = "anr")
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="auteurSeq")
    private int anr; // PK, NN, AI
    @Column
    private String naam;


    public Auteur(String naam) {
        this.naam = naam;
    }

    public int getAnr() {
        return anr;
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
