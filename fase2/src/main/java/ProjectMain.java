import Classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class  ProjectMain extends Application {

    private static Stage rootStage;

    public static Stage getRootStage() {
        return rootStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        rootStage = stage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("csamain.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("CSA Administratie hoofdscherm");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void voegZakenToeAanDB(CSARepoImpl repo ) {
        // doe klanten in db
        Klant maarten = new Klant( "maarten",  "mettekovenstraat",  "12",  3870);
        Klant joske = new Klant(  "joske",  "luikersteenweg",  "58",  3800);
        Klant danny = new Klant(  "danny",  "steenweg",  "1",  2000);
        repo.saveNewKlant(maarten);
        repo.saveNewKlant(joske);
        repo.saveNewKlant(danny);

        // doe leveranciers in db
        Leverancier denBoer = new Leverancier( "denBoer",  2400,  "oudekatsei",  "13b");
        Leverancier BoerVanBijOns = new Leverancier( "BoerVanBijOns",  1890,  "tiensesteenweg",  "255");
        repo.saveNewLeverancier(denBoer);
        repo.saveNewLeverancier(BoerVanBijOns);

        // doe pakketten in db
        Pakket pakket1 = new Pakket("vegetarisch",2,0);
        Pakket pakket2 = new Pakket( "bourgondisch",  1,  0);
        repo.saveNewPakket(pakket1);
        repo.saveNewPakket(pakket2);

        //doe producten in db
        Product product1 = new Product("appel");
        Product product2 = new Product("biefstuk");
        Product product3 = new Product("tarwe");
        Product product4 = new Product("tomaat");
        repo.saveNewProduct(product1);
        repo.saveNewProduct(product2);
        repo.saveNewProduct(product3);
        repo.saveNewProduct(product4);

        //doe auteurs in db
        Auteur auteur1 = new Auteur("lady GAGA");
        Auteur auteur2 = new Auteur("Queen");
        Auteur auteur3 = new Auteur("Martin garrix");
        repo.saveNewAuteur(auteur1);
        repo.saveNewAuteur(auteur2);
        repo.saveNewAuteur(auteur3);

        //temp empty list
        List<Weeksamenstelling> empty1 = new ArrayList<>();
        List<Levering> empty2 = new ArrayList<>();

        // doe aanbiedingen in db
        Aanbod aanbod1 = new Aanbod(1,1,500,empty1,empty2);
        Aanbod aanbod2 = new Aanbod( 2,  1,  400,empty1,empty2);
        repo.saveNewAanbod(aanbod1);
        repo.saveNewAanbod(aanbod2);

        //maak en voeg weeksamenstelling toe aan db
        Weeksamenstelling weeksamenstelling1 = new Weeksamenstelling(aanbod1,product1,1);
        repo.saveNewWeeksamenstelling(weeksamenstelling1);

        // voeg weeksamenstelling te aan het aanbod
        List<Weeksamenstelling> samenstellingLijst = new ArrayList<>();
        samenstellingLijst.add(weeksamenstelling1);
        aanbod1.setSamenstelling(samenstellingLijst);
        repo.updateAanbod(aanbod1);

        //maak en voeg levering toe aan db
        Levering levering1 = new Levering(aanbod1,maarten,false,1);
        repo.saveNewLevering(levering1);

        //voeg levering te aan het aanbod
        List<Levering> leveringLijst = new ArrayList<>();
        leveringLijst.add(levering1);
        aanbod1.setLevering(leveringLijst);
        repo.updateAanbod(aanbod1);
    }


    public static void clearWholeDB(CSARepoImpl repo){
        repo.deleteAlleLeveringen();
        repo.deleteAlleWeeksamenstellingen();
        repo.deleteAlleKlanten();
        repo.deleteAlleLeveranciers();
        repo.deleteAlleAanbiedingen();
        repo.deleteAllePakketten();
        repo.deleteAlleProducten();
        repo.deleteAlleAuteurs();
    }
}
