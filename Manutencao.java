public class Manutencao extends Servico {
    public enum TipoManutencao { PREVENTIVA, CORRETIVA }
    private TipoManutencao tipo;

    public Manutencao(String descricao, double valor, TipoManutencao tipo) {
        super(descricao, valor);
        this.tipo = tipo;
    }

    public TipoManutencao getTipo() { return tipo; }

    @Override
    public void realizarServico() {
        System.out.println("Realizando manutenção " + tipo.toString().toLowerCase() + ": " + getDescricao());
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo=" + tipo;
    }
}
