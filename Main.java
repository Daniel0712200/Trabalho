import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal
public class Main {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static final List<Servico> servicos = new ArrayList<>();
    private static final List<RegistroServico> historicoServicos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDadosExemplo();
        exibirMenu();
    }

    private static void exibirMenu() {
        boolean executando = true;
        while (executando) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Exibir Clientes");
            System.out.println("2. Exibir Funcionários");
            System.out.println("3. Realizar Serviço");
            System.out.println("4. Adicionar Cliente");
            System.out.println("5. Adicionar Funcionário");
            System.out.println("6. Remover Cliente");
            System.out.println("7. Remover Funcionário");
            System.out.println("8. Atualizar Cliente");
            System.out.println("9. Atualizar Funcionário");
            System.out.println("10. Exibir Histórico de Serviços");
            System.out.println("11. Sair");

            int opcao = lerEntradaInt("Escolha uma opção: ");
            processarOpcao(opcao);
        }
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> exibirLista("Clientes", clientes);
            case 2 -> exibirLista("Funcionários", funcionarios);
            case 3 -> realizarServico();
            case 4 -> adicionarCliente();
            case 5 -> adicionarFuncionario();
            case 6 -> removerCliente();
            case 7 -> removerFuncionario();
            case 8 -> atualizarCliente();
            case 9 -> atualizarFuncionario();
            case 10 -> exibirHistoricoServicos();
            case 11 -> encerrarSistema();
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static int lerEntradaInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
            }
        }
    }

    private static void exibirLista(String titulo, List<?> lista) {
        System.out.println("\n--- " + titulo + " ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }
    }

    private static void inicializarDadosExemplo() {
        clientes.add(new Cliente("Ana Silva", "99999-8888", "ana@exemplo.com", "Rua A, 123"));
        funcionarios.add(new Funcionario("Carlos Souza", "99999-7777", "carlos@exemplo.com"));
        servicos.add(new Servico("Instalação de ar-condicionado", 600.0));
    }

    private static void encerrarSistema() {
        System.out.println("Encerrando o sistema.");
        System.exit(0);
    }

    private static void realizarServico() {
        // Exibir a lista de clientes
        exibirLista("Clientes", clientes);
        int clienteIndex = lerEntradaInt("Escolha o índice do cliente: ");
        
        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Índice de cliente inválido!");
            return;
        }
    
        Cliente cliente = clientes.get(clienteIndex);
        System.out.println("Você escolheu: " + cliente);
    
        // Exibir a lista de funcionários
        exibirLista("Funcionários", funcionarios);
        int funcionarioIndex = lerEntradaInt("Escolha o índice do funcionário: ");
        
        if (funcionarioIndex < 0 || funcionarioIndex >= funcionarios.size()) {
            System.out.println("Índice de funcionário inválido!");
            return;
        }
    
        Funcionario funcionario = funcionarios.get(funcionarioIndex);
        System.out.println("Você escolheu: " + funcionario);
    
        // Exibir a lista de serviços
        exibirLista("Serviços", servicos);
        int servicoIndex = lerEntradaInt("Escolha o índice do serviço: ");
        
        if (servicoIndex < 0 || servicoIndex >= servicos.size()) {
            System.out.println("Índice de serviço inválido!");
            return;
        }
    
        Servico servico = servicos.get(servicoIndex);
        System.out.println("Você escolheu: " + servico);
    
        // Registrar a data do serviço
        String dataServico = lerEntradaString("Digite a data do serviço (dd/MM/yyyy): ");
        
        // Aqui você pode criar um objeto para armazenar a realização do serviço
        RegistroServico registro = new RegistroServico(cliente, funcionario, servico, dataServico);
        System.out.println("Serviço realizado com sucesso!");
        System.out.println(registro);
    }
    
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
    

    private static void adicionarCliente() {
        System.out.println("Digite os dados do cliente:");
        Cliente cliente = lerDadosCliente();
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void adicionarFuncionario() {
        System.out.println("Digite os dados do funcionário:");
        Funcionario funcionario = lerDadosFuncionario();
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    private static void removerCliente() {
        exibirLista("Clientes", clientes);
        int indice = lerEntradaInt("Digite o índice do cliente que deseja remover: ");
        if (indice >= 0 && indice < clientes.size()) {
            clientes.remove(indice);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Índice de cliente inválido!");
        }
    }

    private static void removerFuncionario() {
        exibirLista("Funcionários", funcionarios);
        int indice = lerEntradaInt("Digite o índice do funcionário que deseja remover: ");
        if (indice >= 0 && indice < funcionarios.size()) {
            funcionarios.remove(indice);
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Índice de funcionário inválido!");
        }
    }

    private static void atualizarCliente() {
        System.out.println("\n--- Atualização de Clientes ---");
        exibirLista("Clientes", clientes);
        int indice = lerEntradaInt("Digite o índice do Cliente que deseja atualizar: ");
        if (indice >= 0 && indice < clientes.size()) {
            Cliente cliente = clientes.get(indice);
            System.out.println("Digite os novos dados do cliente (deixe em branco para manter o atual):");
            atualizarDadosCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Índice de cliente inválido!");
        }
    }

    private static void atualizarFuncionario() {
        System.out.println("\n--- Atualização de Funcionários ---");
        exibirLista("Funcionários", funcionarios);
        int indice = lerEntradaInt("Digite o índice do Funcionário que deseja atualizar: ");
        if (indice >= 0 && indice < funcionarios.size()) {
            Funcionario funcionario = funcionarios.get(indice);
            System.out.println("Digite os novos dados do funcionário (deixe em branco para manter o atual):");
            atualizarDadosFuncionario(funcionario);
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Índice de funcionário inválido!");
        }
    }

    private static void atualizarDadosCliente(Cliente cliente) {
        String nome = lerEntradaString("Novo Nome (atual: " + cliente.getNome() + "): ");
        if (!nome.isEmpty()) {
            cliente.setNome(nome);
        }
        String telefone = lerEntradaString("Novo Telefone (atual: " + cliente.getTelefone() + "): ");
        if (!telefone.isEmpty()) {
            cliente.setTelefone(telefone);
        }
        String email = lerEntradaString("Novo Email (atual: " + cliente.getEmail() + "): ");
        if (!email.isEmpty()) {
            cliente.setEmail(email);
        }
        String endereco = lerEntradaString("Novo Endereço (atual: " + cliente.getEndereco() + "): ");
        if (!endereco.isEmpty()) {
            cliente.setEndereco(endereco);
        }
    }

    private static void atualizarDadosFuncionario(Funcionario funcionario) {
        String nome = lerEntradaString("Novo Nome (atual: " + funcionario.getNome() + "): ");
        if (!nome.isEmpty()) {
            funcionario.setNome(nome);
        }
        String telefone = lerEntradaString("Novo Telefone (atual: " + funcionario.getTelefone() + "): ");
        if (!telefone.isEmpty()) {
            funcionario.setTelefone(telefone);
        }
        String email = lerEntradaString("Novo Email (atual: " + funcionario.getEmail() + "): ");
        if (!email.isEmpty()) {
            funcionario.setEmail(email);
        }
    }

    private static String lerEntradaString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    // Métodos para ler dados do cliente e funcionário
    private static Cliente lerDadosCliente() {
        String nome = lerEntradaString("Nome: ");
        String telefone = lerEntradaString("Telefone: ");
        String email = lerEntradaString("Email: ");
        String endereco = lerEntradaString("Endereço: ");
        return new Cliente(nome, telefone, email, endereco);
    }

    private static Funcionario lerDadosFuncionario() {
        String nome = lerEntradaString("Nome: ");
        String telefone = lerEntradaString("Telefone: ");
        String email = lerEntradaString("Email: ");
        return new Funcionario(nome, telefone, email);
    }

    // Classes base Cliente e Funcionario
    static class Cliente {
        private String nome;
        private String telefone;
        private String email;
        private String endereco;

        public Cliente(String nome, String telefone, String email, String endereco) {
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
            this.endereco = endereco;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        @Override
        public String toString() {
            return String.format("Cliente[nome=%s, telefone=%s, email=%s, endereco=%s]", nome, telefone, email, endereco);
        }
    }

    static class Funcionario {
        private String nome;
        private String telefone;
        private String email;

        public Funcionario(String nome, String telefone, String email) {
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return String.format("Funcionário[nome=%s, telefone=%s, email=%s]", nome, telefone, email);
        }
    }

    static class Servico {
        private String descricao;
        private double preco;

        public Servico(String descricao, double preco) {
            this.descricao = descricao;
            this.preco = preco;
        }

        public String getDescricao() {
            return descricao;
        }

        public double getPreco() {
            return preco;
        }

        @Override
        public String toString() {
            return String.format("Serviço[descricao=%s, preco=%.2f]", descricao, preco);
        }
    }

    private static void exibirHistoricoServicos() {
        System.out.println("\n--- Exibindo Histórico de Serviços ---");
        if (historicoServicos.isEmpty()) {
            System.out.println("Nenhum serviço realizado até o momento.");
        } else {
            for (RegistroServico registro : historicoServicos) {
                System.out.println(registro);
            }
        }
    }
}    