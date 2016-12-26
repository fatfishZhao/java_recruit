package abc;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/26.
 */

public class StackExpression {
    public static void main(String args[]) throws IOException {
        TokenStream ts = new MyTokenStream(System.in);
        Stack<Integer> numbers = new Stack<>(100);
        Stack<Token> operators = new Stack<>(100);

        while (ts.getToken().tokenType != Token.TokenType.NONE) {
            if (ts.getToken().tokenType == Token.TokenType.INT) {
                numbers.push((Integer)ts.getToken().value);
                ts.consumeToken();
            }
            else {
                if (operators.getTop() == null || preOrder( operators.getTop().tokenType, ts.getToken().tokenType) <= 0) {
                    operators.push(ts.getToken());
                    ts.consumeToken();
                }else if (operators.getTop().tokenType== Token.TokenType.LPAR){
                    if(ts.getToken().tokenType== Token.TokenType.RPAR) {
                        operators.pop();
                        ts.consumeToken();
                    }
                    else {
                        operators.push(ts.getToken());
                        ts.consumeToken();
                    }
                }else {
                    binaryCalc(numbers, operators);
                    if(ts.getToken().tokenType!= Token.TokenType.RPAR) {
                        operators.push(ts.getToken());
                        ts.consumeToken();
                    }
                }
            }
        }
        while (!operators.isEmpty()) {
            binaryCalc(numbers, operators);
        }

        System.out.println("result is " + numbers.getTop());
    }

    private static void binaryCalc(Stack<Integer> numbers, Stack<Token> operators) {
        int a = numbers.pop();
        int b = numbers.pop();

        Token oprt = operators.pop();
        int d = 0;
        if (oprt.tokenType == Token.TokenType.PLUS)
            d = b + a;
        else if (oprt.tokenType == Token.TokenType.MULT)
            d = a * b;
        else if (oprt.tokenType == Token.TokenType.MINUS)
            d = b - a;
        else if (oprt.tokenType == Token.TokenType.DIV)
            d = b / a;

        numbers.push(d);
    }

    private static int preOrder(Token.TokenType left, Token.TokenType right) {
        int lFlag=0,rFlag=0;
        if((left) == Token.TokenType.PLUS || left == Token.TokenType.MINUS) {
            lFlag=1;
        }else if(left == Token.TokenType.MULT || left == Token.TokenType.DIV) {
            lFlag = 2;
        }else if (left == Token.TokenType.RPAR){
            lFlag = 0;
        }else if (left == Token.TokenType.LPAR){
            lFlag = 3;
        }

        if((right) == Token.TokenType.PLUS || right == Token.TokenType.MINUS) {
            rFlag=1;
        }else if(right == Token.TokenType.MULT || right == Token.TokenType.DIV) {
            rFlag = 2;
        }else if (right == Token.TokenType.RPAR){
            rFlag = 0;
        }else if (right == Token.TokenType.LPAR){
            rFlag = 3;
        }
        if(lFlag<rFlag){
            return -1;
        }else if(lFlag==rFlag)
            return 0;
        else
            return 1;
        /*
        if (left == Token.TokenType.PLUS || left == Token.TokenType.MINUS) {
            if (right == Token.TokenType.MULT || right == Token.TokenType.DIV)
                return -1;
            else
                return 1;
        }
        else
            return 1;*/
    }
}



