package service;

import model.UserDAO;
import model.UserModel;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void addUser(UserModel user) throws SQLException {
        userDAO.insertUser(user);
    }

    public UserModel getUser(int id) throws SQLException {
        return userDAO.selectUser(id);
    }

    public List<UserModel> getAllUsers() throws SQLException {
        return userDAO.selectAllUsers();
    }

    public void updateUser(UserModel user) throws SQLException {
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) throws SQLException {
        userDAO.deleteUser(id);
    }
}
