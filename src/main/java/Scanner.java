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


    private String number() {
        int start = current ;
        while (Character.isDigit(peek())) {
            advance();
        }

        String n = new String(input, start, current-start)  ;
        return n;
    }

    // método que encapsula o avanço dos tokens e verifica se está no final do arquivo
    public void advance()  {
        char ch = peek();
        if (ch != '\0') {
            current++;
        }
    }

    public String nextToken () {
        char ch = peek();
        if(ch == '0'){
            advance();
            return Character.toString(ch);
        } else if (Character.isDigit(ch)){
            return number();
        }

        switch (ch){
            case '+':
            case '-':
                advance();
                return Character.toString(ch);

            default:
                break;
        }

        throw new Error("lexical error");
//
//        if (Character.isDigit(ch)) {
//            advance();
//            return ch;
//        }
//
//        // ajustar para multiplicacao e divisao tbm
//        switch (ch) {
//            case '+':
//            case '-':
//                advance();
//                return ch;
//            default:
//                break;
//        }
//
//        return '\0';
    }
}
