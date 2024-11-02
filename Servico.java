public abstract class Servico {
    private String descricao;
    private double valor;

    public Servico(String descricao, double valor) {
        if (descricao == null || descricao.isEmpty()) throw new IllegalArgumentException("Descrição não pode ser vazia");
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo");
        this.descricao = descricao;
        this.valor = valor;
    }

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) throw new IllegalArgumentException("Descrição não pode ser vazia");
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo");
        this.valor = valor;
    }

    // Método abstrato
    public abstract void realizarServico();
}
