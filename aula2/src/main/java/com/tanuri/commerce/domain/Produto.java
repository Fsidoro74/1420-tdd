public class Produto {

    private String nome;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(String nome, String descricao, double preco, int estoque) {
        // Validações no Construtor (Garante que o objeto nasce válido)
        validarNome(nome);
        validarDescricao(descricao);
        validarPreco(preco);
        validarEstoque(estoque);

        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    // --- Getters ---

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    // --- Setters com Validação ---

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        validarDescricao(descricao);
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        validarPreco(preco); // Valida antes de alterar
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        validarEstoque(estoque); // Valida antes de alterar
        this.estoque = estoque;
    }

    // --- Métodos de Validação de Invariantes ---

    private void validarNome(String nome) {
    }

    private void validarDescricao(String descricao) {
    }

    private void validarPreco(double preco) {
    }

    private void validarEstoque(int estoque) {
    }
}