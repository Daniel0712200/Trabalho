import java.time.LocalDateTime;

public class SuporteTecnico extends Servico {
    private Prioridade prioridade;
    private LocalDateTime horarioAtendimento;
    private int duracaoEstimadaMinutos;

    public SuporteTecnico(String descricao, double valor, Prioridade prioridade, int duracaoEstimadaMinutos) {
        super(descricao, valor);
        setPrioridade(prioridade);
        setDuracaoEstimadaMinutos(duracaoEstimadaMinutos);
        this.horarioAtendimento = LocalDateTime.now();
    }

    
    public SuporteTecnico(String descricao, double valor, int prioridadeInt, int duracaoEstimadaMinutos) {
        super(descricao, valor);
        this.prioridade = Prioridade.values()[Math.min(Math.max(prioridadeInt - 1, 0), Prioridade.values().length - 1)];
        setDuracaoEstimadaMinutos(duracaoEstimadaMinutos);
        this.horarioAtendimento = LocalDateTime.now();
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade != null ? prioridade : Prioridade.DESCONHECIDA;
    }

    public LocalDateTime getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public int getDuracaoEstimadaMinutos() {
        return duracaoEstimadaMinutos;
    }

    public void setDuracaoEstimadaMinutos(int duracaoEstimadaMinutos) {
        if (duracaoEstimadaMinutos <= 0) {
            throw new IllegalArgumentException("A duração estimada deve ser um valor positivo.");
        }
        this.duracaoEstimadaMinutos = duracaoEstimadaMinutos;
    }

    @Override
    public void realizarServico() {
        System.out.println("Iniciando suporte técnico: " + getDescricao());
        System.out.println("Prioridade: " + prioridade.getDescricao());
        System.out.println("Horário de atendimento: " + horarioAtendimento);
        System.out.println("Duração estimada: " + duracaoEstimadaMinutos + " minutos.");

        // Simula a realização do serviço
        System.out.println("Suporte técnico em andamento...");
        System.out.println("Suporte técnico concluído com sucesso.");
    }

    public enum Prioridade {
        ALTA("Alta"),
        MEDIA("Média"),
        BAIXA("Baixa"),
        DESCONHECIDA("Desconhecida");

        private final String descricao;

        Prioridade(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
