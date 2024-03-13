package controller;

import service.UserService;
import model.*;
import java.sql.SQLException;
import java.util.List;

public class LoginController {
    private final UserService userService;

    public LoginController() {
        this.userService = new UserService();
    }

    public boolean authenticate(String cpf, String password) {
        try {
            List<UserModel> users = userService.getAllUsers();
            for (UserModel user : users) {
                if (user.getCpf().equals(cpf) && user.getPassword().equals(password)) {
                    return true; // Autenticação bem-sucedida
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Autenticação falhou
    }

    // CRUD Operations
    public void createUser(UserModel user) {
        try {
            userService.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserModel readUser(int id) {
        try {
            return userService.getUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserModel> readAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateUser(UserModel user) {
        try {
            userService.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            userService.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
