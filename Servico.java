/**
 * Classe abstrata que representa um serviço a ser realizado.
 * Esta classe serve como base para tipos específicos de serviços, garantindo
 * que todos os serviços tenham uma descrição e um valor válidos.
 */
public abstract class Servico {
    private String descricao;
    private double valor;

    /**
     * Construtor para a classe Servico.
     *
     * @param descricao Descrição do serviço. Não pode ser nula ou vazia.
     * @param valor     Valor do serviço. Não pode ser negativo.
     * @throws IllegalArgumentException Se a descrição estiver vazia ou o valor for negativo.
     */
    public Servico(String descricao, double valor) {
        setDescricao(descricao);
        setValor(valor);
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    /**
     * Método abstrato que deve ser implementado pelas subclasses para realizar o serviço.
     * Cada tipo de serviço deve definir como ele é realizado.
     */
    public abstract void realizarServico();

    /**
     * Define a descrição do serviço.
     *
     * @param descricao A nova descrição do serviço. Não pode ser nula ou vazia.
     * @throws IllegalArgumentException Se a descrição estiver vazia.
     */
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia ou nula.");
        }
        this.descricao = descricao;
    }

    /**
     * Define o valor do serviço.
     *
     * @param valor O novo valor do serviço. Não pode ser negativo.
     * @throws IllegalArgumentException Se o valor for negativo.
     */
    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
        }
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Serviço: '%s', Valor: R$ %.2f", descricao, valor);
    }

    /**
     * Método que fornece informações detalhadas sobre o serviço.
     * Pode ser sobrescrito nas subclasses para fornecer informações adicionais.
     *
     * @return String contendo detalhes do serviço.
     */
    public String detalhesServico() {
        return String.format("Detalhes do Serviço: %s, Valor: R$ %.2f", descricao, valor);
    }
}
