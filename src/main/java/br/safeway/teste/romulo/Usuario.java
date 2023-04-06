package br.safeway.teste.romulo;

public class Usuario {
    private final String name;
    private final String cpf;
    private final String email;

    public Usuario(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
