public abstract class Funcionario {
    private String nome;
    private String telefone;
    private String email;
    private double salario;

    public Funcionario(String nome, String telefone, String email, double salario) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.salario = salario;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                '}';
    }
}
