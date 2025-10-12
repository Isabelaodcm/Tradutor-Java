// classe que irá executar o parser - componente responsável por analisar a
// estrutura sintática do código

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "45  + 89   -       876";
        Parser p = new Parser (input.getBytes());
        p.parse();

    }
}