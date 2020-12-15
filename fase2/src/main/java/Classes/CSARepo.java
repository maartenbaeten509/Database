package Classes;

import java.util.List;

public interface CSARepo {

    List<Klant> getKlantById(int klantnr);
    void saveNewKlant(Klant klant);
    void updateKlant(Klant klant);
    void deleteKlantbyId(int klantnr);
    void deleteAlleKlanten();
    List<Klant> haalAlleKlantenOp();

    List<Leverancier> getLeverancierById(int levnr);
    void saveNewLeverancier(Leverancier leverancier);
    void updateLeverancier(Leverancier leverancier);
    void deleteLeverancierbyId(int levnr);
    void deleteAlleLeveranciers();
    List<Leverancier> haalAlleLeveranciersOp();

    List<Aanbod> getAanbodById(int aanbodnr);
    void saveNewAanbod(Aanbod aanbod);
    void updateAanbod(Aanbod aanbod);
    void deleteAanbodbyId(int aanbodnr);
    void deleteAlleAanbiedingen();
    List<Aanbod> haalAlleAanbiedingenOp();

    List<Pakket> getPakketById(int pakketnr);
    void saveNewPakket(Pakket pakket);
    void updatePakket(Pakket pakket);
    void deletePakketbyId(int pakketnr);
    void deleteAllePakketten();
    List<Pakket> haalAllePakkettenOp();

    List<Auteur> getAuteurById(int anr);
    void saveNewAuteur(Auteur auteur);
    void updateAuteur(Auteur auteur);
    void deleteAuteursbyId(int anr);
    void deleteAlleAuteurs();
    List<Auteur> haalAlleAuteursOp();

    void saveNewProduct(Product product);
    void deleteAlleProducten();
    List<Product> haalAlleProductenOp();

    List<Weeksamenstelling> getWeeksamenstellingById(int weeksamenstellingnr);
    void saveNewWeeksamenstelling(Weeksamenstelling weeksamenstelling);
    void updateWeeksamenstelling(Weeksamenstelling weeksamenstelling);
    void deleteWeeksamenstellingbyId(int weeksamenstellingnr);
    void deleteAlleWeeksamenstellingen();
    List<Weeksamenstelling> haalAlleWeeksamenstellingenOp();

    List<Levering> getLeveringById(int levnr);
    void saveNewLevering(Levering levering);
    void updateLevering(Levering levering);
    void deleteLeveringbyId(int levnr);
    List<Levering> haalAlleLeveringenOp();
    void deleteAlleLeveringen();


}
