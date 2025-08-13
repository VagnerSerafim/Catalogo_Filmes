public class Ator extends Pessoa {

    public Ator(String nome, String dataNascimento, String nacionalidade) {
        super(nome, dataNascimento, nacionalidade);
    }

    @Override
    public String toString() {
        return "Ator: " + super.toString();
    }
}