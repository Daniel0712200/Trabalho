import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Manutencao extends Servico {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final int TEMPO_ETAPA_MS = 500;  // Tempo de pausa entre etapas em milissegundos
    
    private final TipoManutencao tipoManutencao;
    private final LocalDateTime dataHoraManutencao;

    public Manutencao(String descricao, double valor, TipoManutencao tipoManutencao) {
        super(descricao, validarValor(valor));
        this.tipoManutencao = tipoManutencao != null ? tipoManutencao : TipoManutencao.DESCONHECIDA;
        this.dataHoraManutencao = LocalDateTime.now();
    }

    private static double validarValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor da manutenção não pode ser negativo.");
        }
        return valor;
    }

    public TipoManutencao getTipoManutencao() {
        return tipoManutencao;
    }

    public LocalDateTime getDataHoraManutencao() {
        return dataHoraManutencao;
    }

    @Override
    public void realizarServico() {
        exibirDetalhesServico();
        realizarEtapasManutencao();
        System.out.println("Manutenção finalizada com sucesso às " + LocalDateTime.now().format(DATE_FORMATTER) + ".");
    }

    private void exibirDetalhesServico() {
        System.out.println("Iniciando manutenção: " + getDescricao());
        System.out.println("Tipo de manutenção: " + tipoManutencao.getDescricao());
        System.out.println("Data e Hora: " + dataHoraManutencao.format(DATE_FORMATTER));
        System.out.println("Valor estimado: R$" + getValor());
    }

    private void realizarEtapasManutencao() {
        String[] etapas = {"Verificação de componentes", "Realizando ajustes e correções", "Executando testes finais"};
        
        for (String etapa : etapas) {
            System.out.println(etapa + "...");
            pausarProcesso();
        }
    }

    private void pausarProcesso() {
        try {
            Thread.sleep(TEMPO_ETAPA_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Processo interrompido.");
        }
    }

    public enum TipoManutencao {
        PREVENTIVA("Preventiva"),
        CORRETIVA("Corretiva"),
        PREDITIVA("Preditiva"),
        DESCONHECIDA("Desconhecida");

        private final String descricao;

        TipoManutencao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
