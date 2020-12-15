package controller;

import Classes.CSARepoImpl;
import Classes.Leverancier;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class BeheerBoerderijenController {

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnClose;
    @FXML
    private TableView<Leverancier> tblBoerderijen;

    @FXML
    private TableView<Leverancier> tbladdleverancier;
    @FXML
    private Button btn_Close;
    @FXML
    private Button btn_Bewaar;

    boolean init;

    CSARepoImpl repo = setupDB();

    public void initialize() {
        initTable();
        btnAdd.setOnAction(e -> {
            addNewRow();
        });
        btnModify.setOnAction(e -> {
            verifyOneRowSelected();
            modifyCurrentRow();
        });
        btnDelete.setOnAction(e -> {
            verifyOneRowSelected();
            deleteCurrentRow();
        });

        btnClose.setOnAction(e -> {
            var stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        });
    }

    private void initTable() {
        tblBoerderijen.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tblBoerderijen.getColumns().clear();


            //init collums
            TableColumn<Leverancier, String> col1 = new TableColumn<>("levnr");
            col1.setCellValueFactory(f -> new ReadOnlyObjectWrapper(f.getValue().getLevnr()));
            tblBoerderijen.getColumns().add(col1);
            TableColumn<Leverancier, String> col2 = new TableColumn<>("anr");
            col2.setCellValueFactory(f -> new ReadOnlyObjectWrapper(f.getValue().getAnr()));
            tblBoerderijen.getColumns().add(col2);
            TableColumn<Leverancier, String> col3 = new TableColumn<>("naam");
            col3.setCellValueFactory(f -> new ReadOnlyObjectWrapper(f.getValue().getNaam()));
            tblBoerderijen.getColumns().add(col3);
            TableColumn<Leverancier, String> col4 = new TableColumn<>("postcode");
            col4.setCellValueFactory(f -> new ReadOnlyObjectWrapper(f.getValue().getPostcode()));
            tblBoerderijen.getColumns().add(col4);
            TableColumn<Leverancier, String> col5 = new TableColumn<>("straat");
            col5.setCellValueFactory(f -> new ReadOnlyObjectWrapper(f.getValue().getStraat()));
            tblBoerderijen.getColumns().add(col5);
            TableColumn<Leverancier, String> col6 = new TableColumn<>("huisnr");
            col6.setCellValueFactory(f -> new ReadOnlyObjectWrapper(f.getValue().getHuisnummer()));
            tblBoerderijen.getColumns().add(col6);

/*
        int colIndex = 0;
        for(var colName : new String[]{"levnr" , "anr",  "naam", "postcode",  "straat",  "huisnummer"}) {
            TableColumn<Leverancier, String> col = new TableColumn<>(colName);
            final int finalColIndex = colIndex;
            col.setCellValueFactory(f -> new ReadOnlyObjectWrapper(f.getValue().get));
            tblBoerderijen.getColumns().add(col);
            colIndex++;
        }*/


            // create leveranciers en doe in lijst
            Leverancier denBoer = new Leverancier("denBoer", 2400, "oudekatsei", "13b");
            Leverancier BoerVanBijOns = new Leverancier("BoerVanBijOns", 1890, "tiensesteenweg", "255");
            List<Leverancier> leveranciers = new ArrayList<>();
            leveranciers.add(0, denBoer);
            leveranciers.add(0, BoerVanBijOns);

            //sla op in db
            for (Leverancier leverancier : leveranciers) {
                repo.saveNewLeverancier(leverancier);
            }

            for (Leverancier leverancier : leveranciers) {
                tblBoerderijen.getItems().add(leverancier);
            }

    }

    private void addNewRow() {
        try {
            var stage = new Stage();
            var root = (AnchorPane)  FXMLLoader.load(getClass().getClassLoader().getResource("voegleveranciertoe.fxml"));
            var scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("voeg leverancier toe");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();

        } catch (Exception e) {
            throw new RuntimeException("Kan beheerscherm " + "voeg leverancier toe" + " niet vinden", e);
        }


    }

    private void deleteCurrentRow() {
        Leverancier leverancier =  tblBoerderijen.getSelectionModel().getSelectedItem();
        tblBoerderijen.getItems().remove(leverancier);
        repo.deleteLeverancierbyId(leverancier.getLevnr());
    }

    private void modifyCurrentRow() {
        Leverancier leverancier =  tblBoerderijen.getSelectionModel().getSelectedItem();
        //open new window


    }

    public void showAlert(String title, String content) {
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void verifyOneRowSelected() {
        if(tblBoerderijen.getSelectionModel().getSelectedCells().size() == 0) {
            showAlert("Hela!", "Eerst een boer selecteren hé.");
        }
    }

    public static CSARepoImpl setupDB(){
        System.out.println("Bootstrapping JPA/Hibernate...");
        var sessionFactory = Persistence.createEntityManagerFactory("Classes");
        var entityManager = sessionFactory.createEntityManager();
        System.out.println("Bootstrapping JPA/Hibernate done");

        System.out.println("Bootstrapping Repository...");
        var repo = new CSARepoImpl(entityManager);
        System.out.println("Bootstrapping Repository done");
        return repo;
    }
}
