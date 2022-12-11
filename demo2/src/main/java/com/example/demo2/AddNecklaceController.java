package com.example.demo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbClasses.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNecklaceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField necklaceNameField;

    @FXML
    void initialize() {
        addButton.setOnAction(actionEvent -> {
            DatabaseHandler db = new DatabaseHandler();
            db.addNecklece(necklaceNameField.getText().trim());

            addButton.getScene().getWindow().hide();

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
