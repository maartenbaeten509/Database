package Classes;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Column(name = "prodcutNaam")
    @Id
    private String Naam; // PK, NN

    //relatie weeksamenstelling
    @OneToMany(mappedBy = "product")
    Set<Weeksamenstelling> samenstelling;

    public Product(String naam) {
        Naam = naam;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String naam) {
        Naam = naam;
    }
}
