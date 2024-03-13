package view;

import controller.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criar a instância do LoginController
        LoginController loginController = new LoginController();

        // Configurar a tela de login
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setController(loginController);

        primaryStage.setTitle("Gestão de TCC");
        // Exibir a tela de login
        loginScreen.display(primaryStage);
    }

    public static void main(String[] args) {
        // Iniciar a aplicação JavaFX
        launch(args);
    }
}


