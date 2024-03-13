package view;

import controller.LoginController;
import model.UserModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen {

    private LoginController controller;

    public void display(Stage stage) {
        // Pane para os botões do lado esquerdo
        VBox sidePane = new VBox(10);
        sidePane.setPadding(new Insets(15, 12, 15, 12));
        
        Button btnRepositorio = new Button("Repositório");
        Button btnOrientador = new Button("Orientador");
        Button btnIdeias = new Button("Ideias");

        sidePane.getChildren().addAll(btnRepositorio, btnOrientador, btnIdeias);

        // Pane para o login
        GridPane loginPane = new GridPane();
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setHgap(10);
        loginPane.setVgap(10);
        loginPane.setPadding(new Insets(25, 25, 25, 25));

        Label cpfLabel = new Label("CPF:");
        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF");
        
        Label passwordLabel = new Label("Senha:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Senha");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin(cpfField.getText(), passwordField.getText(), loginPane, stage));
        
        Button registerButton = new Button("Registrar-se");
        registerButton.setOnAction(e -> showRegistrationForm(stage));

        loginPane.add(cpfLabel, 0, 0);
        loginPane.add(cpfField, 1, 0);
        loginPane.add(passwordLabel, 0, 1);
        loginPane.add(passwordField, 1, 1);
        loginPane.add(loginButton, 1, 2);
        loginPane.add(registerButton, 2, 2);

        // Layout principal
        GridPane mainLayout = new GridPane();
        mainLayout.add(sidePane, 0, 0);
        mainLayout.add(loginPane, 1, 0);

        Scene scene = new Scene(mainLayout, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    
        private void showRegistrationForm(Stage primaryStage) {
        Stage registerStage = new Stage();

        GridPane registerPane = new GridPane();
        registerPane.setAlignment(Pos.CENTER);
        registerPane.setHgap(10);
        registerPane.setVgap(10);
        registerPane.setPadding(new Insets(25, 25, 25, 25));

        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Senha");

        Button submitButton = new Button("Criar Conta");
        submitButton.setOnAction(e -> handleRegistration(cpfField.getText(), passwordField.getText(), registerStage));

        registerPane.add(new Label("CPF:"), 0, 0);
        registerPane.add(cpfField, 1, 0);
        registerPane.add(new Label("Senha:"), 0, 1);
        registerPane.add(passwordField, 1, 1);
        registerPane.add(submitButton, 1, 2);

        Scene scene = new Scene(registerPane, 300, 200);
        registerStage.setScene(scene);
        registerStage.setTitle("Registrar-se");
        registerStage.show();
    }

    private void handleRegistration(String cpf, String password, Stage registerStage) {
        if (controller != null) {
            UserModel newUser = new UserModel(cpf, password);
            controller.createUser(newUser); // Chamando o método no controller para criar o usuário
            showAlert(Alert.AlertType.CONFIRMATION, null, "Registro", "Usuário registrado com sucesso!");
            registerStage.close();
            
        }
    }

    private void handleLogin(String cpf, String password, GridPane loginPane, Stage primaryStage) {
        if (controller != null && controller.authenticate(cpf, password)) {
            showAlert(Alert.AlertType.CONFIRMATION, (Stage) loginPane.getScene().getWindow(),
                      "Login realizado com sucesso!", "Bem vindo!");
        // Redirecionar para a página inicial
        HomePage homePage = new HomePage();
        homePage.display(primaryStage, this);
        } else {
            showAlert(Alert.AlertType.ERROR, (Stage) loginPane.getScene().getWindow(),
                      "Falha no Login", "CPF ou senha inválidos");
        }
    }

    private void showAlert(Alert.AlertType alertType, Stage owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.showAndWait();
    }

    public void setController(LoginController controller) {
        this.controller = controller;
    }
}
