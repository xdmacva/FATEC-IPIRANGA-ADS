package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage {

    public void display(Stage stage, LoginScreen loginScreen) {
        Label welcomeLabel = new Label("Bem-vindo à Página Inicial!");

        // Pane para os botões do lado esquerdo
        VBox sidePane = new VBox(10);
        sidePane.setPadding(new Insets(15, 12, 15, 12));
        
        Button btnSair = new Button("Sair");
        btnSair.setOnAction(e -> loginScreen.display(stage)); // Ação para voltar à tela de login

        Button btnRepositorio = new Button("Repositório");
        Button btnOrientador = new Button("Orientador");
        Button btnIdeias = new Button("Ideias");

        sidePane.getChildren().addAll(btnRepositorio, btnOrientador, btnIdeias, btnSair);
        sidePane.setAlignment(Pos.BOTTOM_LEFT);

        // Layout para a mensagem de boas-vindas
        GridPane welcomePane = new GridPane();
        welcomePane.setAlignment(Pos.CENTER);
        welcomePane.add(welcomeLabel, 0, 0); // Adicionando a label ao painel central

        // Layout principal
        GridPane mainLayout = new GridPane();
        mainLayout.add(sidePane, 0, 0);
        mainLayout.add(welcomePane, 1, 0);

        Scene scene = new Scene(mainLayout, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Página Inicial");
        stage.show();
    }
}
