package system.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import system.MainApplication;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class PaginaInicialController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void cadastroRemedios() throws IOException {
//        // Obtém o Stage atual
//        Stage stage = MainApplication.getPaginaInicial();
//
//        // Carrega o novo FXML
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/system/pagina-cadastro-remedio.fxml")));
//
//
//
//        // Define a nova cena no Stage atual
//        stage.setScene(new Scene(root));
        URL fxmlURL = getClass().getResource("/system/pagina-cadastro-remedio.fxml");

        System.out.println(fxmlURL);  // Isso irá imprimir o caminho do arquivo FXML no console

        // Se o fxmlURL for null, significa que o arquivo não foi encontrado, e o problema está no caminho.
        if (fxmlURL == null) {
            System.out.println("O arquivo FXML não foi encontrado.");
            return;
        }

        // Obtém o Stage atual
        Stage stage = MainApplication.getPaginaInicial();

        // Carrega o novo FXML
        Parent root = FXMLLoader.load(fxmlURL);

        // Define a nova cena no Stage atual
        stage.setScene(new Scene(root));
    }
}