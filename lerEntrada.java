import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("unused")
public interface lerEntrada {
    Scanner scanner = new Scanner(System.in); // Scanner para leitura de entradas

    // Método para ler uma linha de texto
    default String lerEntradaString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    // Método para ler um número inteiro
    default int lerEntradaInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. " + mensagem);
            }
        }
    }

    // Método para ler um número decimal
    default double lerEntradaDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. " + mensagem);
            }
        }
    }

    // Método para ler uma confirmação (sim/não)
    default boolean lerEntradaSimNao(String mensagem) {
        while (true) {
            String entrada = lerEntradaString(mensagem).trim().toLowerCase();
            if (entrada.equals("sim") || entrada.equals("s")) {
                return true;
            } else if (entrada.equals("não") || entrada.equals("n")) {
                return false;
            } else {
                System.out.print("Entrada inválida. Responda 'sim' ou 'não': ");
            }
        }
    }

    // Método para ler um inteiro em um intervalo
    default int lerEntradaIntIntervalo(String mensagem, int min, int max) {
        while (true) {
            int valor = lerEntradaInt(mensagem);
            if (valor >= min && valor <= max) {
                return valor;
            } else {
                System.out.printf("Entrada inválida. O valor deve estar entre %d e %d.%n", min, max);
            }
        }
    }

    // Método para ler um double em um intervalo
    default double lerEntradaDoubleIntervalo(String mensagem, double min, double max) {
        while (true) {
            double valor = lerEntradaDouble(mensagem);
            if (valor >= min && valor <= max) {
                return valor;
            } else {
                System.out.printf("Entrada inválida. O valor deve estar entre %.2f e %.2f.%n", min, max);
            }
        }
    }

    // Método para ler uma entrada com validação personalizada
    default String lerEntradaComValidacao(String mensagem, String regex) {
        while (true) {
            String entrada = lerEntradaString(mensagem);
            if (entrada.matches(regex)) {
                return entrada;
            } else {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
    }
}
