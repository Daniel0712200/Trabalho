public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(String nome, String telefone, String email) {
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        if (telefone == null || telefone.isEmpty()) throw new IllegalArgumentException("Telefone não pode ser vazio");
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("Email não pode ser vazio");

        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters com validações
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio");
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) throw new IllegalArgumentException("Telefone não pode ser vazio");
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("Email não pode ser vazio");
        this.email = email;
    }
}
