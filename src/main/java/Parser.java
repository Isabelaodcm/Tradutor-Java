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
        statements();
    }

    void statements () {
        while (currentToken.type != TokenType.EOF) {
            statement();
        }
    }
    void printStatement () {
        match(TokenType.PRINT);
        expr();
        System.out.println("print");
        match(TokenType.SEMICOLON);
    }

    void letStatement () {
        match(TokenType.LET);
        var id = currentToken.lexeme;
        match(TokenType.IDENT);
        match(TokenType.EQ);
        expr();
        System.out.println("pop "+id);
        match(TokenType.SEMICOLON);
    }

    void statement () {
        if (currentToken.type == TokenType.PRINT) {
            printStatement();
        } else if (currentToken.type == TokenType.LET) {
            letStatement();
        } else {
            throw new Error("syntax error");
        }
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
        term();
        oper();
    }

    void term () {
        if (currentToken.type == TokenType.NUMBER)
            number();
        else if (currentToken.type == TokenType.IDENT) {
            System.out.println("push "+currentToken.lexeme);
            match(TokenType.IDENT);
        }
        else
            throw new Error("syntax error");
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
            term();
            System.out.println("add");
            oper();
        } else if (currentToken.type == TokenType.MINUS) {
            match(TokenType.MINUS);
            term();
            System.out.println("sub");
            oper();
        } else if(currentToken.type == TokenType.MULTIPLY){
            match(TokenType.MULTIPLY);
            term();
            System.out.println("mult");
            oper();
        } else if (currentToken.type == TokenType.DIVIDE) {
            match(TokenType.DIVIDE);
            term();
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