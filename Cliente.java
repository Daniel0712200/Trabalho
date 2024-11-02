public class Cliente extends Pessoa {
    private String endereco;
    private String email;
    private String nome;
    private String telefone;
    

    public Cliente(String nome, String telefone, String email, String endereco) {
        super(nome, telefone, email);
        if (endereco == null || endereco.isEmpty()) throw new IllegalArgumentException("Endereço não pode ser vazio");
        this.endereco = endereco;
    }

    // Getter e Setter para endereco
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isEmpty()) throw new IllegalArgumentException("Endereço não pode ser vazio");
        this.endereco = endereco;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getNome(){
        return nome;
    }
    public void setNOME(String nome){
        this.nome=nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone=telefone;
    }
}
