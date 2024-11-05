import java.text.NumberFormat;
import java.util.Locale;

public class Servico {
    private String descricao;
    private double valor; // Atributo valor

    // Construtor da classe Servico com validação de entrada
    public Servico(String descricao, double valor) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia.");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo.");
        }
        this.descricao = descricao;
        this.valor = valor; // Atribuição do valor
    }

    // Método para obter a descrição do serviço
    public String getDescricao() {
        return descricao;
    }

    // Método getter para valor
    public double getValor() {
        return valor;
    }

    // Método toString para representação em string do serviço
    @Override
    public String toString() {
        return String.format("Descrição: %s, Valor: %s", descricao, toFormattedString());
    }

    // Método para formatar o valor como moeda
    public String toFormattedString() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")); // Formato brasileiro
        return format.format(valor);
    }

    // Métodos equals e hashCode para comparação e uso em coleções
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Servico servico = (Servico) obj;
        return Double.compare(servico.valor, valor) == 0 && descricao.equals(servico.descricao);
    }

    @Override
    public int hashCode() {
        return 31 * descricao.hashCode() + Double.hashCode(valor);
    }
}
