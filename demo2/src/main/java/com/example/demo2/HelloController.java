package com.example.demo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dbClasses.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label incorrectText;
    @FXML
    private Button loginButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {

        loginButton.setOnAction(actionEvent -> {
            String username = loginField.getText().trim();
            String password = passwordField.getText().trim();

            if(!username.equals("") && !password.equals(""))
                loginUser(username,password);
            else
                incorrectText.setVisible(true);
        });

        signUpButton.setOnAction(actionEvent -> {
            signUpButton.getScene().getWindow().hide();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        });
    }

    private void loginUser(String username, String password) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(dbHandler.getUser(user) != 0){

            System.out.println("Logged in!");

            loginButton.getScene().getWindow().hide();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-window.fxml"));
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
        else{
            incorrectText.setVisible(true);
        }

    }

}
