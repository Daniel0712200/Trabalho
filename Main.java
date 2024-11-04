import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal
public class Main {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static final List<Servico> servicos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    private static void realizarServico() {
        if (servicos.isEmpty()) {
            System.out.println("Não há serviços disponíveis para realizar.");
            return;
        }
    
        int opcaoServico = escolherServico();
    
        if (opcaoServico == -1) {
            return; // O usuário cancelou ou houve erro na escolha
        }
    
        Servico servicoSelecionado = servicos.get(opcaoServico - 1);
        exibirDetalhesServico(servicoSelecionado);
    
        if (confirmarServico()) {
            executarServico(servicoSelecionado);
        } else {
            System.out.println("Serviço não realizado.");
        }
    }

    private static int escolherServico() {
        System.out.println("Selecione um serviço a ser realizado:");
        for (int i = 0; i < servicos.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, servicos.get(i));
        }
    
        int opcaoServico = lerEntradaInt("Digite o número do serviço: ");
                if (opcaoServico < 1 || opcaoServico > servicos.size()) {
                    System.out.println("Opção inválida! Tente novamente.");
                    return -1; // Indica que houve erro
                }
                return opcaoServico;
            }
            
            private static int lerEntradaInt(String mensagem) {
                int tentativas = 0; // Contador de tentativas
                final int maxTentativas = 5; // Limite de tentativas
            
                while (true) {
                    System.out.print(mensagem);
                    String entrada = scanner.nextLine().trim(); // Remove espaços em branco
            
                    if (entrada.isEmpty()) {
                        System.out.println("Entrada não pode ser vazia. Tente novamente.");
                        continue;
                    }
            
                    try {
                        // Tenta converter a entrada para um inteiro
                        return Integer.parseInt(entrada);
                    } catch (NumberFormatException e) {
                        tentativas++;
                        System.out.printf("Entrada inválida! '%s' não é um número inteiro.%n", entrada);
            
                        if (tentativas >= maxTentativas) {
                            System.out.println("Número máximo de tentativas excedido. Encerrando a solicitação.");
                            break; // Ou você pode lançar uma exceção aqui
                        }
                    }
                }
                // Se atingir o limite de tentativas, você pode retornar um valor padrão ou lançar uma exceção
                return -1; // Valor indicando que não foi possível ler um número válido
            }


        
    
    private static void exibirDetalhesServico(Servico servico) {
        System.out.printf("Você selecionou o serviço: %s, Valor: %.2f%n", 
        servico.getDescricao(), servico.getValor());
    }
    
    
    private static boolean confirmarServico() {
        return lerEntradaSimNao("Deseja confirmar a realização deste serviço? (sim/não): ");
            }
            
            private static boolean lerEntradaSimNao(String mensagem) {
                while (true) {
                    System.out.print(mensagem);
                    String entrada = scanner.nextLine().trim().toLowerCase(); // Remove espaços e converte para minúsculas
            
                    if (entrada.equals("sim") || entrada.equals("s")) {
                        return true;
                    } else if (entrada.equals("não") || entrada.equals("n")) {
                        return false;
                    } else {
                        System.out.print("Entrada inválida. Responda 'sim' ou 'não': ");
                    }
                }
            }
            
            
        
        
    private static void executarServico(Servico servico) {
        try {
            servico.realizarServico();
            System.out.printf("Serviço '%s' realizado com sucesso em %s.%n", 
            servico.getDescricao(), 
            java.time.LocalDateTime.now());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao realizar o serviço: " + e.getMessage());
        }
    }
    
    
    
    private static void removerFuncionario() {
        // Implementação da remoção de funcionário
        System.out.println("Funcionário removido com sucesso!");
    }
    
    private static void atualizarFuncionario() {
        // Implementação da atualização de funcionário
        System.out.println("Funcionário atualizado com sucesso!");
    }
    
    private static void exibirHistoricoServicos() {
        // Implementação da exibição do histórico de serviços
        System.out.println("Exibindo histórico de serviços...");
    }
    

    public static void main(String[] args) {
        inicializarDadosExemplo();
        exibirMenu();
    }

    private static void inicializarDadosExemplo() {
        // Adicionando clientes
        clientes.add(new Cliente("Ana Silva", "99999-8888", "ana@exemplo.com", "Rua A, 123"));
        clientes.add(new Cliente("Bruno Martins", "98888-7777", "bruno@exemplo.com", "Rua B, 456"));
        clientes.add(new Cliente("Maria Oliveira", "97777-6666", "maria@exemplo.com", "Avenida C, 789"));
        clientes.add(new Cliente("José Santos", "96666-5555", "jose@exemplo.com", "Rua D, 321"));
        clientes.add(new Cliente("Fernanda Lima", "95555-4444", "fernanda@exemplo.com", "Praça E, 654"));
    
        // Adicionando funcionários
        funcionarios.add(new Gerente("Carlos Souza", "99999-7777", "carlos@exemplo.com", 5000.0, "Operações"));
        funcionarios.add(new Tecnico("João Pereira", "99999-6666", "joao@exemplo.com", 3000.0, "Instalação"));
        funcionarios.add(new Tecnico("Mariana Costa", "94444-3333", "mariana@exemplo.com", 2800.0, "Manutenção"));
        funcionarios.add(new Tecnico("Lucas Mendes", "93333-2222", "lucas@exemplo.com", 3200.0, "Suporte Técnico"));
        funcionarios.add(new Gerente("Roberta Almeida", "92222-1111", "roberta@exemplo.com", 5500.0, "Vendas"));
    
        // Adicionando serviços
        servicos.add(new Instalacao("Instalação de ar-condicionado", 600.0));
        servicos.add(new Manutencao("Manutenção preventiva", 300.0, Manutencao.TipoManutencao.PREVENTIVA));
        servicos.add(new SuporteTecnico("Suporte técnico remoto", 150.0, SuporteTecnico.Prioridade.MEDIA, 30));
        servicos.add(new Manutencao("Manutenção corretiva", 500.0, Manutencao.TipoManutencao.CORRETIVA));
        servicos.add(new Instalacao("Instalação de ventilador", 200.0));
        servicos.add(new SuporteTecnico("Suporte técnico presencial", 250.0, SuporteTecnico.Prioridade.ALTA, 60));
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
            System.out.print("Escolha uma opção: ");

            int opcao = lerEntradaInt();
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
    
    private static void encerrarSistema() {
        System.out.println("Encerrando o sistema.");
        System.exit(0);
    }

    private static int lerEntradaInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número: ");
            }
        }
    }

    private static void exibirLista(String titulo, List<?> lista) {
        System.out.println("\n--- " + titulo + " ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }
    }

    private static void adicionarCliente() {
        System.out.println("Digite os dados do cliente:");
        Cliente cliente = lerDadosCliente();
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void removerCliente() {
        System.out.println("\n--- Remoção de Clientes ---");
        exibirLista("Clientes", clientes);
        System.out.print("Digite o índice do cliente que deseja remover: ");
        int indice = lerEntradaInt();
        if (indice >= 0 && indice < clientes.size()) {
            clientes.remove(indice);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Índice de cliente inválido!");
        }
    }

    private static void atualizarCliente() {
        System.out.println("\n--- Atualização de Clientes ---");
        exibirLista("Clientes", clientes);
        System.out.print("Digite o índice do Cliente que deseja atualizar: ");
        
        int indice = lerEntradaInt();
        if (indice >= 0 && indice < clientes.size()) {
            Cliente cliente = clientes.get(indice);
            System.out.println("Digite os novos dados do cliente (deixe em branco para manter o atual):");
            atualizarDadosCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Índice de cliente inválido!");
        }
    }

    private static Cliente lerDadosCliente() {
        String nome = lerEntradaString("Nome: ");
        String telefone = lerEntradaString("Telefone: ");
        String email = lerEntradaString("Email: ");
        String endereco = lerEntradaString("Endereço: ");
        return new Cliente(nome, telefone, email, endereco);
    }

    private static void atualizarDadosCliente(Cliente cliente) {
        String novoNome = lerEntradaString("Novo nome (" + cliente.getNome() + "): ");
        String novoTelefone = lerEntradaString("Novo telefone (" + cliente.getTelefone() + "): ");
        String novoEmail = lerEntradaString("Novo email (" + cliente.getEmail() + "): ");
        String novoEndereco = lerEntradaString("Novo endereço (" + cliente.getEndereco() + "): ");

        if (!novoNome.isEmpty()) {
            cliente.setNome(novoNome);
        }
        if (!novoTelefone.isEmpty()) {
            cliente.setTelefone(novoTelefone);
        }
        if (!novoEmail.isEmpty() && validarEmail(novoEmail)) {
            cliente.setEmail(novoEmail);
        } else if (!novoEmail.isEmpty()) {
            System.out.println("Email inválido. O email não foi atualizado.");
        }
        if (!novoEndereco.isEmpty()) {
            cliente.setEndereco(novoEndereco);
        }
    }

    private static boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        return email.matches(emailRegex);
    }

    private static void adicionarFuncionario() {
        System.out.println("--- Cadastro de Funcionário  ---");
        String nome = lerEntradaString("Nome: ");
        String telefone = lerEntradaString("Telefone: ");
        String email = lerEntradaString("Email: ");
        double salario = lerEntradaDouble("Salário: ");
        System.out.println("Cargo:\n1. Gerente\n2. Técnico");
        int cargo = lerEntradaInt();

        Funcionario funcionario;
        switch (cargo) {
            case 1 -> {
                String departamento = lerEntradaString("Departamento: ");
                funcionario = new Gerente(nome, telefone, email, salario, departamento);
            }
            case 2 -> {
                String especialidade = lerEntradaString("Especialidade: ");
                funcionario = new Tecnico(nome, telefone, email, salario, especialidade);
            }
            default -> {
                System.out.println("Cargo inválido.");
                return; // Saia do método caso o cargo seja inválido
            }
        }
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    private static String lerEntradaString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static double lerEntradaDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número válido: ");
            }
        }
    }
}

