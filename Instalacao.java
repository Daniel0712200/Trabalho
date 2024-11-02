import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Instalacao extends Servico {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final int TEMPO_ETAPA_MS = 500; // Tempo de pausa entre etapas

    private final LocalDateTime dataHoraInstalacao;

    public Instalacao(String descricao, double valor) {
        super(descricao, validarValor(valor));
        this.dataHoraInstalacao = LocalDateTime.now();
    }

    private static double validarValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor da instalação não pode ser negativo.");
        }
        return valor;
    }

    public LocalDateTime getDataHoraInstalacao() {
        return dataHoraInstalacao;
    }

    @Override
    public void realizarServico() {
        exibirDetalhesInstalacao();
        realizarEtapasInstalacao(new String[]{
            "Preparando o ambiente",
            "Instalando componentes",
            "Configurando sistema",
            "Realizando testes de funcionamento"
        });
        System.out.println("Instalação concluída com sucesso às " + LocalDateTime.now().format(DATE_FORMATTER) + ".");
    }

    private void exibirDetalhesInstalacao() {
        System.out.printf("Iniciando instalação: %s\nData e Hora: %s\nValor estimado: R$%.2f\n",
                getDescricao(), dataHoraInstalacao.format(DATE_FORMATTER), getValor());
    }

    private void realizarEtapasInstalacao(String[] etapas) {
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
}
