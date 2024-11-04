import java.time.LocalDate;
import java.util.regex.Pattern;

public class Clientes {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private LocalDate dataCriacao;
    private boolean ativo; // true se o cliente está ativo, false se inativo
    private String tipoServico; // Tipo de serviço: Ar Condicionado, Ventilação, Manutenção

    // Regex para validar email
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Construtor
    public Clientes(String nome, String telefone, String email, String endereco, String tipoServico) {
        this.nome = nome;
        this.telefone = telefone;
        setEmail(email); // Chama o setter que valida o email
        this.endereco = endereco;
        this.dataCriacao = LocalDate.now();
        this.ativo = true; // Novo cliente é ativo por padrão
        this.tipoServico = tipoServico;
    }

    // Getters e Setters
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
        if (isEmailValido(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    // Método para verificar se o email é válido
    private boolean isEmailValido(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // Método para exibir informações do cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", ativo=" + ativo +
                ", tipoServico='" + tipoServico + '\'' +
                '}';
    }

    // Método para ativar ou desativar cliente
    public void atualizarStatus(boolean status) {
        this.ativo = status;
    }
}
