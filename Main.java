import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static final List<Servico> servicos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDadosExemplo();
        exibirMenu();
    }

    private static void exibirMenu() {
        boolean executando = true;
        while (executando) {
            System.out.println("\n*** Menu Principal ***");
            System.out.println("1. Exibir Clientes");
            System.out.println("2. Exibir Funcionários");
            System.out.println("3. Realizar Serviço");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> exibirClientes();
                    case 2 -> exibirFuncionarios();
                    case 3 -> realizarServico();
                    case 4 -> {
                        executando = false;
                        System.out.println("Encerrando o sistema.");
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }
    }

    private static void inicializarDadosExemplo() {
        clientes.add(new Cliente("Ana Silva", "99999-8888", "ana@exemplo.com", "Rua A, 123"));
        clientes.add(new Cliente("Bruno Martins", "98888-7777", "bruno@exemplo.com", "Rua B, 456"));

        funcionarios.add(new Gerente("Carlos Souza", "99999-7777", "carlos@exemplo.com", 5000.0, "Operações"));
        funcionarios.add(new Tecnico("João Pereira", "99999-6666", "joao@exemplo.com", 3000.0, "Instalação"));

        servicos.add(new Instalacao("Instalação de ar-condicionado", 600.0));
        servicos.add(new Manutencao("Manutenção preventiva", 300.0, Manutencao.TipoManutencao.PREVENTIVA));
        servicos.add(new SuporteTecnico("Suporte técnico remoto", 150.0, 2, 30)); 
    }

    private static void exibirClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        clientes.forEach(cliente -> System.out.println("Nome: " + cliente.getNome() +
                ", Endereço: " + cliente.getEndereco() +
                ", Telefone: " + cliente.getTelefone()));
        if (clientes.isEmpty()) System.out.println("Nenhum cliente cadastrado.");
    }

    private static void exibirFuncionarios() {
        System.out.println("\n--- Lista de Funcionários ---");
        funcionarios.forEach(funcionario -> {
            System.out.print("Nome: " + funcionario.getNome() + ", Cargo: ");
            if (funcionario instanceof Gerente gerente) {
                System.out.println("Gerente, Departamento: " + gerente.getDepartamento());
            } else if (funcionario instanceof Tecnico tecnico) {
                System.out.println("Técnico, Especialidade: " + tecnico.getEspecialidade());
            }
        });
        if (funcionarios.isEmpty()) System.out.println("Nenhum funcionário cadastrado.");
    }

    private static void realizarServico() {
        System.out.println("\n--- Escolha um Serviço para Realizar ---");
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço disponível.");
            return;
        }

        for (int i = 0; i < servicos.size(); i++) {
            Servico servico = servicos.get(i);
            System.out.println((i + 1) + ". " + servico.getDescricao() + " - Valor: R$" + servico.getValor());
        }

        System.out.print("Escolha o número do serviço: ");
        try {
            int opcaoServico = Integer.parseInt(scanner.nextLine());
            Optional<Servico> servicoEscolhido = (opcaoServico > 0 && opcaoServico <= servicos.size()) ?
                    Optional.of(servicos.get(opcaoServico - 1)) : Optional.empty();

            servicoEscolhido.ifPresentOrElse(
                    Servico::realizarServico,
                    () -> System.out.println("Serviço inválido! Tente novamente.")
            );
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Por favor, insira um número.");
        }
    }
}
