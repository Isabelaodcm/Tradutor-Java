// vai tratar os caracteres de entrada

import java.awt.*;

public class Scanner {
    private byte[] input;
    private int current;

    public Scanner (byte[] input) {
        this.input = input;
    }

    // método que retorna o token(caracter) atual
    public char peek(){
        if(current<input.length)
            return(char)input[current];

        return '\0';
    }

    // método para remover caracteres em branco
    private void skipWhitespace() {
        char ch = peek();
        while (ch == ' ' || ch == '\r' || ch == '\t' || ch == '\n') {
            advance();
            ch = peek();
        }
    }
    // função para concatenar a sequencia de caracteres de entrada e verificar
//    o tipo do token
    private Token number() {
        int start = current ;
        while (Character.isDigit(peek())) {
            advance();
        }

        String n = new String(input, start, current-start)  ;
        return new Token(TokenType.NUMBER, n);
    }

    // método que encapsula o avanço dos tokens e verifica se está no final do arquivo
    public void advance()  {
        char ch = peek();
        if (ch != '\0') {
            current++;
        }
    }

    public Token nextToken () {
        skipWhitespace();
        char ch = peek();
        if(ch == '0'){
            advance();
            return new Token (TokenType.NUMBER, Character.toString(ch));
        } else if (Character.isDigit(ch)){
            return number();
        }

        // ajustar para multiplicacao e divisao tbm
        switch (ch){
            case '+':
                advance();
                return new Token (TokenType.PLUS,"+");
            case '-':
                advance();
                return new Token (TokenType.MINUS,"-");

            case '*':
                advance();
                return new Token(TokenType.MULTIPLY, "*");

            case '/':
                advance();
                return new Token(TokenType.DIVIDE, "/");

            case '\0':
                return new Token (TokenType.EOF,"EOF");

            default:
                throw new Error("lexical error at " + ch);
        }
    }
}
