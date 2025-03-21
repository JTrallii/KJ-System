package system.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PaginaInicialController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}