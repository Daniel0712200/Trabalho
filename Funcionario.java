public abstract class Funcionario extends Pessoa {
    private double salario;
    private String telefone;
    private String email;
    

    public Funcionario(String nome, String telefone, String email, double salario) {
        super(nome, telefone, email);
        if (salario <= 0) throw new IllegalArgumentException("Salário deve ser positivo");
        this.salario = salario;
    }

    // Getter e Setter para salario
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) throw new IllegalArgumentException("Salário deve ser positivo");
        this.salario = salario;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone=telefone;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
