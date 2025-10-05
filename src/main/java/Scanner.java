// vai tratar os caracteres de entrada

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

    // método que encapsula o avanço dos tokens e verifica se está no final do arquivo
    public void advance()  {
        char ch = peek();
        if (ch != '\0') {
            current++;
        }
    }

    public char nextToken () {
        char ch = peek();

        if (Character.isDigit(ch)) {
            advance();
            return ch;
        }

        // ajustar para multiplicacao e divisao tbm
        switch (ch) {
            case '+':
            case '-':
                advance();
                return ch;
            default:
                break;
        }

        return '\0';
    }
}
