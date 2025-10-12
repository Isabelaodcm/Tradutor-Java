public class Parser{
    private Scanner scan;
    private Token currentToken;

    public Parser(byte[] input){
        scan = new Scanner(input);
        currentToken = scan.nextToken();

    }

//    // método para atualizar o token
    private void nextToken () {
        currentToken = scan.nextToken();
    }

    public void parse(){
        expr();
    }

    // método que verifica se o atual caracter é igual ao caracter de entrada
    private void match(TokenType t){
        if(currentToken.type == t){
            nextToken();
        } else{
            throw new Error("Syntax error");
        }
    }

    void expr() {
        number();
        oper();
    }

    // Substitui o metodo digit
    void number () {
        System.out.println("push " + currentToken.lexeme);
        match(TokenType.NUMBER);
    }
//    // Define que são válidos apenas os digitos de 0 a 9
//    void digit () {
//        if (Character.isDigit(currentToken)) {
//            System.out.println("push " + currentToken);
//            match(currentToken);
//        } else {
//            throw new Error("syntax error");
//        }
//    }

    void oper () {
        if (currentToken.type == TokenType.PLUS) {
            match(TokenType.PLUS);
            number();
            System.out.println("add");
            oper();
        } else if (currentToken.type == TokenType.MINUS) {
            match(TokenType.MINUS);
            number();
            System.out.println("sub");
            oper();
        } else if(currentToken.type == TokenType.MULTIPLY){
            match(TokenType.MULTIPLY);
            number();
            System.out.println("mult");
            oper();
        } else if (currentToken.type == TokenType.DIVIDE) {
            match(TokenType.DIVIDE);
            number();
            System.out.println("div");
            oper();
        }
    }

//    private char peek(){
//        if(current<input.length)
//            return(char)input[current];
//
//        return '\0';
//    }
}