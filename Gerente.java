import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Gerente, que é um tipo de Funcionário.
 * Um Gerente é responsável por supervisionar um departamento e liderar a equipe.
 */
public class Gerente extends Funcionario {
    private String departamento;
    private List<Funcionario> equipe;

    /**
     * Construtor para a classe Gerente.
     *
     * @param nome        Nome do gerente.
     * @param telefone    Telefone do gerente.
     * @param email       Email do gerente.
     * @param salario     Salário do gerente.
     * @param departamento Departamento do gerente.
     * @throws IllegalArgumentException Se os parâmetros fornecidos forem inválidos.
     */
    public Gerente(String nome, String telefone, String email, double salario, String departamento) {
        super(nome, telefone, email, salario);
        setDepartamento(departamento);
        this.equipe = new ArrayList<>(); // Inicializa a lista de funcionários
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento == null || departamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Departamento não pode ser vazio.");
        }
        this.departamento = departamento;
    }

    public List<Funcionario> getEquipe() {
        return new ArrayList<>(equipe); // Retorna uma cópia da lista de funcionários
    }

    /**
     * Método para adicionar um funcionário à equipe do gerente.
     *
     * @param funcionario O funcionário a ser adicionado.
     * @throws IllegalArgumentException Se o funcionário for nulo ou já estiver na equipe.
     */
    public void adicionarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }
        if (equipe.contains(funcionario)) {
            throw new IllegalArgumentException("Funcionário já está na equipe.");
        }
        equipe.add(funcionario);
        System.out.printf("Funcionário '%s' adicionado à equipe de '%s'.%n", funcionario.getNome(), getNome());
    }

    /**
     * Método para remover um funcionário da equipe do gerente.
     *
     * @param funcionario O funcionário a ser removido.
     * @return true se o funcionário foi removido com sucesso, caso contrário false.
     */
    public boolean removerFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }
        boolean removido = equipe.remove(funcionario);
        if (removido) {
            System.out.printf("Funcionário '%s' removido da equipe de '%s'.%n", funcionario.getNome(), getNome());
        } else {
            System.out.printf("Funcionário '%s' não encontrado na equipe de '%s'.%n", funcionario.getNome(), getNome());
        }
        return removido;
    }

    @Override
    public String toString() {
        return String.format("%s, Departamento='%s', Equipe=%d funcionários", super.toString(), departamento, equipe.size());
    }

    /**
     * Método para realizar uma reunião com a equipe do departamento.
     *
     * @param assunto O assunto da reunião.
     */
    public void realizarReuniao(String assunto) {
        System.out.printf("Reunião agendada no departamento '%s' sobre: '%s'%n", departamento, assunto);
    }

    /**
     * Método para aumentar o salário do gerente.
     *
     * @param percentual O percentual a ser aumentado.
     */
    public void aumentarSalario(double percentual) {
        if (percentual <= 0) {
            throw new IllegalArgumentException("O percentual deve ser positivo.");
        }
        double novoSalario = getSalario() * (1 + percentual / 100);
        setSalario(novoSalario);
        System.out.printf("Salário aumentado para: %.2f%n", novoSalario);
    }
}
