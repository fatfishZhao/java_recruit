package abc;

import java.io.BufferedInputStream;
import java.io.IOException;
import static abc.Token.TokenType.*;

/**
 * Created by Administrator on 2017/1/7.
 */
public class ComplexExpression {
    public TokenStream ts;

    public static void main(String args[]) {
        MyComplexExpression e = new MyComplexExpression();
        System.out.println(e.expression());
    }

    public ComplexExpression() {
        ts = new MyTokenStream(new BufferedInputStream(System.in));
    }

    public int expression() {
        int t = term();

        try {
            if (match(PLUS)) {
                return t + expression();
            }
            else if (match(MINUS)) {
                return t - expression();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    private int term() {
        int t = factor();

        try {
            if (match(MULT)) {
                return t * term();
            }
            else if(match(DIV)){
                return t / term();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    private int factor() {
        Token t = null;
        try {
            t = ts.getToken();

            if (t.tokenType == INT) {
                ts.consumeToken();
                return (((Integer) t.value).intValue());
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
