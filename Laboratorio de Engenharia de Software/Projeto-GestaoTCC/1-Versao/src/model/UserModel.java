package model;

public class UserModel {
    private int id;
    private String cpf;
    private String password;

    // Construtor padrão
    public UserModel() {
    }

    // Construtor com CPF e senha
    public UserModel(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
    }

    // Construtor com ID, CPF e senha
    public UserModel(int id, String cpf, String password) {
        this.id = id;
        this.cpf = cpf;
        this.password = password;
    }

    // Métodos de acesso - Getters
    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

    // Métodos de acesso - Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método para autenticação
    public boolean authenticate(String cpf, String password) {
        return this.cpf.equals(cpf) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

