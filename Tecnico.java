public class Tecnico extends Funcionario {
    private String especialidade;

    public Tecnico(String nome, String telefone, String email, double salario, String especialidade) {
        super(nome, telefone, email, salario);
        if (especialidade == null || especialidade.isEmpty()) throw new IllegalArgumentException("Especialidade não pode ser vazia");
        this.especialidade = especialidade;
    }

    // Getter e Setter para especialidade
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.isEmpty()) throw new IllegalArgumentException("Especialidade não pode ser vazia");
        this.especialidade = especialidade;
    }
}
