public class Manutencao extends Servico {
    public enum TipoManutencao {
        PREVENTIVA, CORRETIVA
    }

    private TipoManutencao tipo;

    // Construtor da classe Manutencao com validação de entrada
    public Manutencao(String descricao, double valor, TipoManutencao tipo) {
        super(descricao, valor); // Chama o construtor da classe pai (Servico)
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de manutenção não pode ser nulo.");
        }
        this.tipo = tipo;
    }

    // Método para obter o tipo de manutenção
    public TipoManutencao getTipo() {
        return tipo;
    }

    // Método para realizar o serviço de manutenção
    @Override
    public void realizarServico() {
        // Aqui, chamamos o método getValor() da classe pai para obter o valor formatado
        System.out.printf("Realizando manutenção %s: %s com valor %.2f%n", 
                          tipo.name().toLowerCase(), 
                          getDescricao(), 
                          getValor());
    }

    // Método para obter a representação em string do serviço
    @Override
    public String toString() {
        return String.format("Manutenção [Descrição=%s, Valor=%.2f, Tipo=%s]", 
                             getDescricao(), 
                             getValor(), 
                             tipo.name().toLowerCase());
    }

    // Métodos equals e hashCode para comparação e uso em coleções
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj) || getClass() != obj.getClass()) return false;
        Manutencao manutencao = (Manutencao) obj;
        return tipo == manutencao.tipo; // Compara o tipo de manutenção
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + tipo.hashCode(); // Usa o hash da superclasse e do tipo
    }
}
