package abc;

import java.io.BufferedInputStream;
import java.io.IOException;
import static abc.Token.TokenType.*;

/**
 * Created by Administrator on 2017/1/7.
 */
public class MyComplexExpression {
    public TokenStream ts;

    public static void main(String args[]) {
        MyComplexExpression e = new MyComplexExpression();
        System.out.println(e.expression());
    }

    public MyComplexExpression() {
        ts = new MyTokenStream(new BufferedInputStream(System.in));
    }

    public int expression() {
        int answer = 0;
        try {
            if (match(MINUS)){
                answer -= term();
            }else
                answer += term();
        }catch (IOException e){
            e.printStackTrace();
        }

        while(true){
            try {
                if (match(PLUS)){
                    int t = term();
                    answer += t;
                }else if(match(MINUS)){
                    int t = term();
                    answer -= t;
                }else
                    break;
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return answer;
    }

    private int term() {
        int answer=1;
        answer *= factor();

        while(true){
            try {
                if (match(MULT)){
                    int t = factor();
                    answer *= t;
                }else if(match(DIV)){
                    int t = factor();
                    answer = answer/t;
                }else
                    break;
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return answer;
    }

    private int factor() {
        int signFlag=1;
        Token t = null;

        try {
            t = ts.getToken();

            while (t.tokenType==MINUS){
                signFlag *= -1;
                ts.consumeToken();
                t = ts.getToken();
            }

            if (t.tokenType == INT) {
                ts.consumeToken();
                return signFlag*(((Integer) t.value).intValue());
            }
            else if (match(LPAR)) {
                int v = expression();
                if (!match(RPAR))
                    assert false;
                return v;
            }
            else {
                throw new IOException("Illegal Expression!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // should not reach here
        return 0;
    }

    private boolean match(Token.TokenType tt) throws IOException {
        if (ts.getToken().tokenType == tt) {
            ts.consumeToken();
            return true;
        }
        return false;
    }
}
