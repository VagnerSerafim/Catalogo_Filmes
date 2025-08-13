import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private String dataNascimento;
    private String nacionalidade;

    public Pessoa(String nome, String dataNascimento, String nacionalidade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public String toString() {
        return nome + " (" + nacionalidade + ", nasc.: " + dataNascimento + ")";
    }
}