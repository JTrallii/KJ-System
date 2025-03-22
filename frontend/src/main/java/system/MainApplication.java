package system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private static Stage paginaInicial;
    @Override
    public void start(Stage stage) throws IOException {
        paginaInicial = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("pagina-inicial.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 800);
        stage.setTitle("KJSystem");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    // Método para acessar o Stage principal em outras classes
    public static Stage getPaginaInicial() {
        return paginaInicial;
    }


}