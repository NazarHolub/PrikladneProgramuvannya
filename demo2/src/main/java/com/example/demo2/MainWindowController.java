package com.example.demo2;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dbClasses.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.*;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addStoneButton;

    @FXML
    private Button seeStonesButton;

    @FXML
    private TextField addStoneByIdField;

    @FXML
    private TableColumn<StoneForTable, Double> caratsColumn;

    @FXML
    private TableColumn<StoneForTable, String> colorColumn;

    @FXML
    private TableColumn<StoneForTable, String> nameColumn;

    @FXML
    private ChoiceBox<String> necklaceChoiceBox;

    @FXML
    private TableColumn<StoneForTable, Double> opacityColumn;
    @FXML
    private TableColumn<StoneForTable, Integer> idColumn;
    @FXML
    private TableColumn<StoneForTable, Double> priceColumn;

    @FXML
    private TableView<StoneForTable> stonesList;
    @FXML
    private Button addNecklaceButton;

    private List<Necklace> necklace = new ArrayList<>();
    @FXML
    private Button deleteNecklaceButton;

    List<Stone> stones;

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        caratsColumn.setCellValueFactory(new PropertyValueFactory<>("Carats"));
        opacityColumn.setCellValueFactory(new PropertyValueFactory<>("Opacity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("Color"));

        GetDataFromDB();
           // stonesList.setItems(necklace.get(0).getStoneForTable());
        List<String> choiceNecklaces = new ArrayList<>();

        for(int i = 0; i< necklace.size(); i++){
            choiceNecklaces.add(necklace.get(i).getName());
        }
        necklaceChoiceBox.getItems().addAll(choiceNecklaces);
        //necklaceChoiceBox.setValue(choiceNecklaces.get(0));
        necklaceChoiceBox.setOnAction(this::ChangeTable);

        addStoneButton.setOnAction(actionEvent -> {
            for (int i = 0; i< stones.size();i++){
                if(stones.get(i).getId() == Integer.parseInt(addStoneByIdField.getText())){
                    System.out.println("FOUND STONE");
                    for(int j = 0; j< necklace.size(); j++){
                        if(necklace.get(j).getName().equals(necklaceChoiceBox.getValue())){
                            necklace.get(j).AddStone(stones.get(i));

                            DatabaseHandler db = new DatabaseHandler();
                            db.addNecklaceStone(j+1,i+1);
                            ChangeTable();
                            break;
                        }
                    }
                }
            }
        });

        seeStonesButton.setOnAction(actionEvent -> {
            seeStonesButton.getScene().getWindow().hide();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stoneshow-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Stones");
            stage.setScene(scene);
            stage.show();
        });

        addNecklaceButton.setOnAction(actionEvent -> {
            addNecklaceButton.getScene().getWindow().hide();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("necklaceadd-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Add necklace");
            stage.setScene(scene);
            stage.show();
        });
        deleteNecklaceButton.setOnAction(actionEvent -> {
            DatabaseHandler db = new DatabaseHandler();
            for(int i = 0; i< necklace.size(); i++){
                if(necklaceChoiceBox.getValue().equals(necklace.get(i).getName())){
                    db.deleteNecklace(necklace.get(i).getId());
                }
            }

            deleteNecklaceButton.getScene().getWindow().hide();

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

    private void ChangeTable(ActionEvent event){
        for(int i = 0; i< necklace.size(); i++){
            if(necklaceChoiceBox.getValue().equals(necklace.get(i).getName()))
                stonesList.setItems(necklace.get(i).getStoneForTable());
        }
    }
    private void ChangeTable(){
        for(int i = 0; i< necklace.size(); i++){
            if(necklaceChoiceBox.getValue().equals(necklace.get(i).getName()))
                stonesList.setItems(necklace.get(i).getStoneForTable());
        }
    }

    void GetDataFromDB(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        List<Necklace> neck = dbHandler.getNecklace();
        List<UserNecklace> userNecklaces = dbHandler.getUserNecklace();
        List<NecklaceStone> necklaceStones = dbHandler.getNecklaceStones();
        stones = dbHandler.getStones();
        int userId = dbHandler.getLoggedUserId();


        for (int i = 0; i < userNecklaces.size(); i++){
            if(userNecklaces.get(i).getUserId() == userId){
                for (int j = 0; j< neck.size(); j++){
                    if(neck.get(j).getId() == userNecklaces.get(i).getNecklaceId()){
                        necklace.add(neck.get(j));
                    }
                }
            }
        }

        for (int i = 0; i < necklace.size(); i++){
            for (int j = 0; j < necklaceStones.size(); j++){
                if(necklace.get(i).getId() == necklaceStones.get(j).getNecklaceId()){
                    for (int k = 0; k < stones.size(); k++){
                        if(stones.get(k).getId() == necklaceStones.get(j).getStoneId()){
                            necklace.get(i).AddStone(stones.get(k));
                        }
                    }
                }
            }
        }
    }

}
