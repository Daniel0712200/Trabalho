public class SuporteTecnico extends Servico {
    public enum Prioridade { BAIXA, MEDIA, ALTA }
    private Prioridade prioridade;
    private int duracao; // em minutos

    public SuporteTecnico(String descricao, double valor, Prioridade prioridade, int duracao) {
        super(descricao, valor);
        this.prioridade = prioridade;
        this.duracao = duracao;
    }

    public Prioridade getPrioridade() { return prioridade; }
    public int getDuracao() { return duracao; }

    @Override
    public void realizarServico() {
        System.out.println("Realizando suporte técnico com prioridade " + prioridade.toString().toLowerCase());
    }

    @Override
    public String toString() {
        return super.toString() + ", Prioridade=" + prioridade + ", Duração=" + duracao + "min";
    }
}
