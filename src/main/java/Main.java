// classe que irá executar o parser - componente responsável por analisar a
// estrutura sintática do código

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "89 +508 -7+99";
        Parser p = new Parser (input.getBytes());
        p.parse();

    }
}