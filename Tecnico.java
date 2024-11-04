public class Tecnico extends Funcionario {
    private String especialidade;

    public Tecnico(String nome, String telefone, String email, double salario, String especialidade) {
        super(nome, telefone, email, salario);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    @Override
    public String toString() {
        return super.toString() + ", Especialidade='" + especialidade + "'";
    }
}
