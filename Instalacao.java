public class Instalacao extends Servico {
    public Instalacao(String descricao, double valor) {
        super(descricao, valor);
    }

    @Override
    public void realizarServico() {
        System.out.println("Realizando instalação: " + getDescricao());
    }
}
