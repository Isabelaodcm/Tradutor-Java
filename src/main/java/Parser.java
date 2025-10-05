public class Parser{
    private byte[] input;
    private int current; // indica qual byte atual que está sendo lido

    public Parser (byte[] input){
        this.input = input;
    }

    public void parse(){
        expr();
    }

    // método que retorna o token(caracter) atual
    private char peek(){
        if(current<input.length)
            return(char)input[current];

        return '\0';
    }

    // método que verifica se o atual caracter é igual ao caracter de entrada
    private void match(char c){
        if(c == peek()){
            current++;
        } else{
            throw new Error("Syntax error");
        }
    }

    void expr() {
        digit();
        oper();
    }

    // Define que são válidos apenas os digitos de 0 a 9
    void digit () {
        if (Character.isDigit(peek())) {
            System.out.println("push " + peek());
            match(peek());
        } else {
            throw new Error("syntax error");
        }
    }



    void oper () {
        if (peek() == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();
        } else if (peek() == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        }
    }
}