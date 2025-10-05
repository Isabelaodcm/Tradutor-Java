// classe que irá executar o parser - componente responsável por analisar a
// estrutura sintática do código

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "8+5-7+9";
        Parser p = new Parser (input.getBytes());
        p.parse();
//        String input = "4-8+6";
//        Scanner scan = new Scanner (input.getBytes());
//        System.out.println(scan.nextToken());
//        System.out.println(scan.nextToken());
//        System.out.println(scan.nextToken());
//        System.out.println(scan.nextToken());
//        System.out.println(scan.nextToken());
    }
}