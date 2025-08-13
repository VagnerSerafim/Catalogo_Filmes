import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static CatalogoFilmes catalogo = new CatalogoFilmes();
    private static List<Ator> atores = new ArrayList<>();
    private static List<Diretor> diretores = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== Catálogo de Filmes ===");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Cadastrar ator");
            System.out.println("3. Cadastrar diretor");
            System.out.println("4. Associar filme a diretor e atores");
            System.out.println("5. Pesquisar filme por nome");
            System.out.println("6. Listar todos os filmes");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> cadastrarFilme();
                case 2 -> cadastrarAtor();
                case 3 -> cadastrarDiretor();
                case 4 -> associarFilme();
                case 5 -> pesquisarFilme();
                case 6 -> listarFilmes();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarFilme() {
        System.out.print("Nome do filme: ");
        String nome = sc.nextLine();
        System.out.print("Data de lançamento (AAAA-MM-DD): ");
        String data = sc.nextLine();
        System.out.print("Orçamento: ");
        BigDecimal orcamento = new BigDecimal(sc.nextLine());
        System.out.print("Descrição: ");
        String desc = sc.nextLine();

        Filme filme = new Filme(nome, data, orcamento, desc);
        catalogo.adicionarFilme(filme);
        System.out.println("Filme cadastrado com sucesso!");
    }

    private static void cadastrarAtor() {
        System.out.print("Nome do ator: ");
        String nome = sc.nextLine();
        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        String data = sc.nextLine();
        System.out.print("Nacionalidade: ");
        String nac = sc.nextLine();

        atores.add(new Ator(nome, data, nac));
        System.out.println("Ator cadastrado com sucesso!");
    }

    private static void cadastrarDiretor() {
        System.out.print("Nome do diretor: ");
        String nome = sc.nextLine();
        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        String data = sc.nextLine();
        System.out.print("Nacionalidade: ");
        String nac = sc.nextLine();

        diretores.add(new Diretor(nome, data, nac));
        System.out.println("Diretor cadastrado com sucesso!");
    }

    private static void associarFilme() {
        listarFilmes();
        if (catalogo.getFilmes().isEmpty()) return;

        System.out.print("Escolha o índice do filme: ");
        int idxFilme = Integer.parseInt(sc.nextLine());
        Filme filme = catalogo.getFilmes().get(idxFilme);

        listarDiretores();
        if (!diretores.isEmpty()) {
            System.out.print("Escolha o índice do diretor: ");
            int idxDir = Integer.parseInt(sc.nextLine());
            filme.setDiretor(diretores.get(idxDir));
        }

        listarAtores();
        if (!atores.isEmpty()) {
            System.out.print("Quantos atores deseja adicionar? ");
            int qtd = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < qtd; i++) {
                System.out.print("Índice do ator: ");
                int idxAtor = Integer.parseInt(sc.nextLine());
                filme.adicionarAtor(atores.get(idxAtor));
            }
        }

        System.out.println("Associação concluída!");
    }

    private static void pesquisarFilme() {
        System.out.print("Digite o nome do filme: ");
        String nome = sc.nextLine();
        List<Filme> resultados = catalogo.pesquisarFilme(nome);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
        } else {
            for (Filme f : resultados) {
                f.exibirInformacoes();
                System.out.println("----------------------------");
            }
        }
    }

    private static void listarFilmes() {
        List<Filme> filmes = catalogo.getFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println(i + " - " + filmes.get(i).getNome());
        }
    }

    private static void listarAtores() {
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
            return;
        }
        for (int i = 0; i < atores.size(); i++) {
            System.out.println(i + " - " + atores.get(i).getNome());
        }
    }

    private static void listarDiretores() {
        if (diretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
            return;
        }
        for (int i = 0; i < diretores.size(); i++) {
            System.out.println(i + " - " + diretores.get(i).getNome());
        }
    }
}