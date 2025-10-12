//public class Parser{
////    private byte[] input;
////    private int current; // indica qual byte atual que está sendo lido
//
//    private Scanner scan;
//    private Token currentToken;
//
//    public Parser(byte[] input){
//        scan = new Scanner(input);
//        currentToken = scan.nextToken();
//
//    }
//
////    // método para atualizar o token
//    private void nextToken () {
//        currentToken = scan.nextToken();
//    }
//
//    public void parse(){
//        expr();
//    }
//
//    // método que verifica se o atual caracter é igual ao caracter de entrada
//    private void match(char c){
//        if(c == currentToken){
//            nextToken();
//        } else{
//            throw new Error("Syntax error");
//        }
//    }
//
//    void expr() {
//        digit();
//        oper();
//    }
//
//    // Define que são válidos apenas os digitos de 0 a 9
//    void digit () {
//        if (Character.isDigit(currentToken)) {
//            System.out.println("push " + currentToken);
//            match(currentToken);
//        } else {
//            throw new Error("syntax error");
//        }
//    }
//
//    void oper () {
//        if (currentToken == '+') {
//            match('+');
//            digit();
//            System.out.println("add");
//            oper();
//        } else if (currentToken == '-') {
//            match('-');
//            digit();
//            System.out.println("sub");
//            oper();
//        }
//        //add operadores de multiplicacao e divisao
//    }
//
////    private char peek(){
////        if(current<input.length)
////            return(char)input[current];
////
////        return '\0';
////    }
//}