public class Instalacao extends Servico {
    
    // Construtor da classe Instalacao com validação de entrada
    public Instalacao(String descricao, double valor) {
        super(descricao, valor); // Chama o construtor da classe pai
    }

    // Método para realizar o serviço de instalação
    @Override
    public void realizarServico() {
        System.out.printf("Realizando instalação: %s com valor %.2f%n", getDescricao(), getValor());
    }

    // Método para obter a representação em string do serviço
    @Override
    public String toString() {
        return String.format("Instalação [Descrição=%s, Valor=%.2f]", getDescricao(), getValor());
    }

    // Métodos equals e hashCode para comparação e uso em coleções
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj) || getClass() != obj.getClass()) return false;
        Instalacao instalacao = (Instalacao) obj;
        return Double.compare(instalacao.getValor(), getValor()) == 0 
            && getDescricao().equals(instalacao.getDescricao()); // Compara descrição e valor
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long valorBits = Double.doubleToLongBits(getValor());
        result = 31 * result + (int) (valorBits ^ (valorBits >>> 32)); // Usar o hash do valor
        result = 31 * result + getDescricao().hashCode(); // Usar o hash da descrição
        return result;
    }
}
