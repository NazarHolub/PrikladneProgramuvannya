package com.example.demo2;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbClasses.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label incorrectLabel;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password1Field;

    @FXML
    private PasswordField password2Field;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameField;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        signUpButton.setOnAction(actionEvent -> {
            String username = usernameField.getText().trim();
            String password1 = password1Field.getText().trim();
            String password2 = password2Field.getText().trim();

            if(!username.equals("") && !password1.equals("") && password1.equals(password2)) {
                dbHandler.registerUser(username, password1);
                System.out.println("user has been registered");

                signUpButton.getScene().getWindow().hide();

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();

            }
            else {
                incorrectLabel.setVisible(true);
            }
        });

        loginButton.setOnAction(actionEvent -> {
            loginButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

}
