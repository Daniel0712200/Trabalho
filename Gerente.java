public class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, String telefone, String email, double salario, String departamento) {
        super(nome, telefone, email, salario);
        if (departamento == null || departamento.isEmpty()) throw new IllegalArgumentException("Departamento não pode ser vazio");
        this.departamento = departamento;
    }

    // Getter e Setter para departamento
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento == null || departamento.isEmpty()) throw new IllegalArgumentException("Departamento não pode ser vazio");
        this.departamento = departamento;
    }
}
