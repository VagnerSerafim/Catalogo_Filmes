import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Filme {

    private String nome;
    private String dataLancamento;
    private BigDecimal orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;

    public Filme(String nome, String dataLancamento, BigDecimal orcamento, String descricao) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.atores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void adicionarAtor(Ator ator) {
        this.atores.add(ator);
    }

    // Método para pesquisa ignorando maiúsculas/minúsculas
    public boolean contemNome(String termo) {
        return nome != null && nome.toLowerCase().contains(termo.toLowerCase());
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de Lançamento: " + dataLancamento);
        System.out.println("Orçamento: R$ " + orcamento);
        System.out.println("Descrição: " + descricao);
        System.out.println("Diretor: " + (diretor != null ? diretor.getNome() : "Não definido"));
        System.out.println("Atores:");
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator associado.");
        } else {
            for (Ator ator : atores) {
                System.out.println("- " + ator.getNome());
            }
        }
    }
}