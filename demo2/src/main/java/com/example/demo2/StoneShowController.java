package com.example.demo2;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dbClasses.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Necklace;
import models.StoneForTable;

public class StoneShowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<StoneForTable, Double> caratsColumn;

    @FXML
    private TableColumn<StoneForTable, String> colorColumn;

    @FXML
    private TableColumn<StoneForTable, String> nameColumn;

    @FXML
    private TableColumn<StoneForTable, Double> opacityColumn;
    @FXML
    private TableColumn<StoneForTable, Integer> idColumn;
    @FXML
    private TableColumn<StoneForTable, Double> priceColumn;

    @FXML
    private TableView<StoneForTable> stonesList;

    private Necklace necklace;

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        caratsColumn.setCellValueFactory(new PropertyValueFactory<>("Carats"));
        opacityColumn.setCellValueFactory(new PropertyValueFactory<>("Opacity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("Color"));
        DatabaseHandler dbHandler = new DatabaseHandler();

        necklace = new Necklace(dbHandler.getStones());

        stonesList.setItems(necklace.getStoneForTable());

        backButton.setOnAction(actionEvent -> {
            backButton.getScene().getWindow().hide();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-window.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Necklace assembler");
            stage.setScene(scene);
            stage.show();
        });
    }

}
