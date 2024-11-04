import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ClienteDAO {
    // Lista estática para armazenar os clientes
    private static final List<Cliente> clientes = new ArrayList<>();

    /**
     * Lista todos os clientes armazenados.
     *
     * @return Uma lista imutável de clientes.
     */
    public static List<Cliente> listarClientes() {
        return Collections.unmodifiableList(new ArrayList<>(clientes)); // Retorna uma cópia imutável da lista de clientes
    }

    /**
     * Adiciona um cliente à lista.
     *
     * @param cliente O cliente a ser adicionado.
     * @throws IllegalArgumentException se o cliente for nulo.
     */
    public static void adicionarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido. Não foi possível adicionar.");
        }
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso: " + cliente.getNome());
    }

    /**
     * Remove um cliente da lista.
     *
     * @param cliente O cliente a ser removido.
     * @return true se o cliente foi removido com sucesso; false caso contrário.
     */
    public static boolean removerCliente(Cliente cliente) {
        boolean removido = clientes.remove(cliente);
        if (removido) {
            System.out.println("Cliente removido com sucesso: " + cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado: " + cliente.getNome());
        }
        return removido;
    }

    /**
     * Busca um cliente pelo nome.
     *
     * @param nome O nome do cliente a ser buscado.
     * @return Um Optional contendo o cliente encontrado, ou vazio se não encontrado.
     */
    public static Optional<Cliente> buscarClientePorNome(String nome) {
        return clientes.stream()
                .filter(cliente -> cliente.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
