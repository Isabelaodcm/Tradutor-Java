public class Parser{
    private byte[] input;
    private int current; // indica qual byte atual que está sendo lido

    public Parser (byte[] input){
        this.input = input;
    }

    public void parse(){
        // ainda vai ser implementado
    }

    // método que retorna o token(caracter) atual
    private char peek(){
        if(current<input.length)
            return(char)input[current];

        return '\0';
    }
}