package Classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SequenceGenerator(name="weeksamenstellingSeq", initialValue=1, allocationSize=100)
public class Weeksamenstelling  {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="weeksamenstellingSeq")
    int weeksamenstellingnr;

    /*@EmbeddedId
    WeeksamenstellingKey id;*/

    @ManyToOne
    @JoinColumn(name = "aanbodnr")
    Aanbod aanbod;


    @ManyToOne
    @JoinColumn(name = "productNaam")
    Product product;

    int weeknr;

    public Weeksamenstelling(Aanbod aanbod, Product product, int weeknr) {
        this.aanbod = aanbod;
        this.product = product;
        this.weeknr = weeknr;
    }

    public int getWeeksamenstellingnr() {
        return weeksamenstellingnr;
    }

    public void setWeeksamenstellingnr(int weeksamenstellingnr) {
        this.weeksamenstellingnr = weeksamenstellingnr;
    }

    public Aanbod getAanbod() {
        return aanbod;
    }

    public void setAanbod(Aanbod aanbod) {
        this.aanbod = aanbod;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getWeeknr() {
        return weeknr;
    }

    public void setWeeknr(int weeknr) {
        this.weeknr = weeknr;
    }
}
