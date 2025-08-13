public class Diretor extends Pessoa {

    public Diretor(String nome, String dataNascimento, String nacionalidade) {
        super(nome, dataNascimento, nacionalidade);
    }

    @Override
    public String toString() {
        return "Diretor: " + super.toString();
    }
}