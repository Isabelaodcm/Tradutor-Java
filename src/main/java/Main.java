// classe que irá executar o parser - componente responsável por analisar a
// estrutura sintática do código

public class Main {
    public static void main(String[] args) throws Exception {
        String input = """
                let a = 42 + 5 - 8;
                let b = 56 + 8;
                print a + b + 6;        
                """;

        Parser p = new Parser(input.getBytes());
        p.parse();
    }
}