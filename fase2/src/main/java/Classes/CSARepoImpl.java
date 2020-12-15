package Classes;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CSARepoImpl implements CSARepo {

    private final EntityManager entityManager;

    public CSARepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //----------------------------------------------------------------------------
    @Override
    public List<Klant> getKlantById(int klantnr) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Klant.class);
        var root = query.from(Klant.class);
        query.where(criteriaBuilder.equal(root.get("klantnr"), klantnr ));
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void saveNewKlant(Klant klant) {
        entityManager.getTransaction().begin();
        entityManager.persist(klant);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updateKlant(Klant klant) {
        entityManager.getTransaction().begin();
        entityManager.merge(klant);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteKlantbyId(int klantnr) {
        entityManager.getTransaction().begin();
        List<Klant> list1 =  getKlantById(klantnr);
        for(int i=0;i<list1.size();i++){
            entityManager.remove(list1.get(i));
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Klant> haalAlleKlantenOp() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Klant.class);
        Root<Klant> rootEntry = query.from(Klant.class);
        CriteriaQuery<Klant> all = query.select(rootEntry);
        TypedQuery<Klant> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    @Override
    public void deleteAlleKlanten() {
        entityManager.getTransaction().begin();
        List<Klant> klantenLijst =  haalAlleKlantenOp();
        for(Klant klant: klantenLijst){
            entityManager.remove(klant);
        }
        entityManager.getTransaction().commit();
    }
    //------------------------------------------------------------------------
    @Override
    public List<Leverancier> getLeverancierById(int levnr) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Leverancier.class);
        var root = query.from(Leverancier.class);
        query.where(criteriaBuilder.equal(root.get("levnr"), levnr ));
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void saveNewLeverancier(Leverancier leverancier) {
        entityManager.getTransaction().begin();
        entityManager.persist(leverancier);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updateLeverancier(Leverancier leverancier) {
        entityManager.getTransaction().begin();
        entityManager.merge(leverancier);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteLeverancierbyId(int levnr) {
        entityManager.getTransaction().begin();
        List<Leverancier> list2 =  getLeverancierById(levnr);
        for(int i=0;i<list2.size();i++){
            entityManager.remove(list2.get(i));
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Leverancier> haalAlleLeveranciersOp() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Leverancier.class);
        Root<Leverancier> rootEntry = query.from(Leverancier.class);
        CriteriaQuery<Leverancier> all = query.select(rootEntry);
        TypedQuery<Leverancier> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    @Override
    public void deleteAlleLeveranciers() {
        entityManager.getTransaction().begin();
        List<Leverancier> leveranciersLijst =  haalAlleLeveranciersOp();
        for(Leverancier leverancier: leveranciersLijst){
            entityManager.remove(leverancier);
        }
        entityManager.getTransaction().commit();
    }
    //----------------------------------------------------------------------------
    @Override
        public List<Aanbod> getAanbodById(int aanbodnr){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Aanbod.class);
        var root = query.from(Aanbod.class);
        query.where(criteriaBuilder.equal(root.get("aanbodnr"), aanbodnr ));
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void saveNewAanbod(Aanbod aanbod) {
        entityManager.getTransaction().begin();
        entityManager.persist(aanbod);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updateAanbod(Aanbod aanbod) {
        entityManager.getTransaction().begin();
        entityManager.merge(aanbod);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteAanbodbyId(int aanbodnr) {
        entityManager.getTransaction().begin();
        List<Leverancier> list2 =  getLeverancierById(aanbodnr);
        for(int i=0;i<list2.size();i++){
            entityManager.remove(list2.get(i));
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Aanbod> haalAlleAanbiedingenOp() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Aanbod.class);
        Root<Aanbod> rootEntry = query.from(Aanbod.class);
        CriteriaQuery<Aanbod> all = query.select(rootEntry);
        TypedQuery<Aanbod> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    @Override
    public void deleteAlleAanbiedingen() {
        entityManager.getTransaction().begin();
        List<Aanbod> aanbiedingenLijst =  haalAlleAanbiedingenOp();
        for(Aanbod aanbod: aanbiedingenLijst){
            entityManager.remove(aanbod);
        }
        entityManager.getTransaction().commit();
    }
    //------------------------------------------------------------------
    @Override
    public  List<Pakket> getPakketById(int pakketnr){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Pakket.class);
        var root = query.from(Pakket.class);
        query.where(criteriaBuilder.equal(root.get("pakketnr"), pakketnr ));
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void saveNewPakket(Pakket pakket){
        entityManager.getTransaction().begin();
        entityManager.persist(pakket);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updatePakket(Pakket pakket) {
        entityManager.getTransaction().begin();
        entityManager.merge(pakket);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deletePakketbyId(int pakketnr) {
        entityManager.getTransaction().begin();
        List<Leverancier> list2 =  getLeverancierById(pakketnr);
        for(int i=0;i<list2.size();i++){
            entityManager.remove(list2.get(i));
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Pakket> haalAllePakkettenOp() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Pakket.class);
        Root<Pakket> rootEntry = query.from(Pakket.class);
        CriteriaQuery<Pakket> all = query.select(rootEntry);
        TypedQuery<Pakket> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    @Override
    public void deleteAllePakketten() {
        entityManager.getTransaction().begin();
        List<Pakket> pakkettenLijst =  haalAllePakkettenOp();
        for(Pakket pakket: pakkettenLijst){
            entityManager.remove(pakket);
        }
        entityManager.getTransaction().commit();
    }
    //---------------------------------------------------------------------
    @Override
    public  List<Auteur> getAuteurById(int anr){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Auteur.class);
        var root = query.from(Auteur.class);
        query.where(criteriaBuilder.equal(root.get("anr"), anr ));
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void saveNewAuteur(Auteur auteur){
        entityManager.getTransaction().begin();
        entityManager.persist(auteur);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updateAuteur(Auteur auteur) {
        entityManager.getTransaction().begin();
        entityManager.merge(auteur);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteAuteursbyId(int anr) {
        entityManager.getTransaction().begin();
        List<Leverancier> list2 =  getLeverancierById(anr);
        for(int i=0;i<list2.size();i++){
            entityManager.remove(list2.get(i));
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Auteur> haalAlleAuteursOp() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Auteur.class);
        Root<Auteur> rootEntry = query.from(Auteur.class);
        CriteriaQuery<Auteur> all = query.select(rootEntry);
        TypedQuery<Auteur> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    @Override
    public void deleteAlleAuteurs() {
        entityManager.getTransaction().begin();
        List<Auteur> auteursLijst =  haalAlleAuteursOp();
        for(Auteur auteur: auteursLijst){
            entityManager.remove(auteur);
        }
        entityManager.getTransaction().commit();
    }
    //-------------------------------------------------------------
    @Override
    public void saveNewProduct(Product product){
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteAlleProducten(){
        entityManager.getTransaction().begin();
        List<Product> productenLijst =  haalAlleProductenOp();
        for(Product product: productenLijst){
            entityManager.remove(product);
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Product> haalAlleProductenOp(){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Product.class);
        Root<Product> rootEntry = query.from(Product.class);
        CriteriaQuery<Product> all = query.select(rootEntry);
        TypedQuery<Product> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    //-----------------------------------------------------------------------
    @Override
    public List<Weeksamenstelling> getWeeksamenstellingById(int weeksamenstellingnr) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Weeksamenstelling.class);
        var root = query.from(Weeksamenstelling.class);
        query.where(criteriaBuilder.equal(root.get("weeksamenstellingnr"), weeksamenstellingnr ));
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void saveNewWeeksamenstelling(Weeksamenstelling weeksamenstelling){
        entityManager.getTransaction().begin();
        entityManager.persist(weeksamenstelling);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updateWeeksamenstelling(Weeksamenstelling weeksamenstelling){
        entityManager.getTransaction().begin();
        entityManager.persist(weeksamenstelling);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteWeeksamenstellingbyId(int weeksamenstellingnr) {
        entityManager.getTransaction().begin();
        List<Weeksamenstelling> list2 =  getWeeksamenstellingById(weeksamenstellingnr);
        for(int i=0;i<list2.size();i++){
            entityManager.remove(list2.get(i));
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteAlleWeeksamenstellingen(){
        entityManager.getTransaction().begin();
        List<Weeksamenstelling> weeksamenstellingenLijst =  haalAlleWeeksamenstellingenOp();
        for(Weeksamenstelling weeksamenstelling: weeksamenstellingenLijst){
            entityManager.remove(weeksamenstelling);
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Weeksamenstelling> haalAlleWeeksamenstellingenOp(){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Weeksamenstelling.class);
        Root<Weeksamenstelling> rootEntry = query.from(Weeksamenstelling.class);
        CriteriaQuery<Weeksamenstelling> all = query.select(rootEntry);
        TypedQuery<Weeksamenstelling> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    //-------------------------------------------------
    @Override
    public List<Levering> getLeveringById(int leveringnr) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Levering.class);
        var root = query.from(Weeksamenstelling.class);
        query.where(criteriaBuilder.equal(root.get("leveringnr"), leveringnr ));
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void saveNewLevering(Levering levering){
        entityManager.getTransaction().begin();
        entityManager.persist(levering);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updateLevering(Levering levering){
        entityManager.getTransaction().begin();
        entityManager.persist(levering);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteLeveringbyId(int leveringnr) {
        entityManager.getTransaction().begin();
        List<Levering> list2 =  getLeveringById(leveringnr);
        for(int i=0;i<list2.size();i++){
            entityManager.remove(list2.get(i));
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteAlleLeveringen(){
        entityManager.getTransaction().begin();
        List<Levering> leveringenLijst =  haalAlleLeveringenOp();
        for(Levering levering: leveringenLijst){
            entityManager.remove(levering);
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public List<Levering> haalAlleLeveringenOp(){
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Levering.class);
        Root<Levering> rootEntry = query.from(Levering.class);
        CriteriaQuery<Levering> all = query.select(rootEntry);
        TypedQuery<Levering> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    //----------------------------------------------------

}
