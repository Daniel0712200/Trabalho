// Classe para registrar o serviço realizado
static class RegistroServico {
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;
    private String data;

    public RegistroServico(Cliente cliente, Funcionario funcionario, Servico servico, String data) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("Registro de Serviço[Cliente=%s, Funcionário=%s, Serviço=%s, Data=%s]",
                cliente.getNome(), funcionario.getNome(), servico.getDescricao(), data);
    }
}
