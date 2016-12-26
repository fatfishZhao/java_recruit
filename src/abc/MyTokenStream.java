package abc;

/**
 * Created by Administrator on 2016/12/24.
 */
import java.io.IOException;
import java.io.InputStream;

public class MyTokenStream implements TokenStream{
    private int position=0;
    private InputStream in;
    private int length=0;
    private Token currentToken;
    private byte[] buffer;

    public static void main(String[] args) {

        TokenStream ts = new MyTokenStream(System.in); // 标准输入的适配器
        try {
            while (ts.getToken().tokenType != Token.TokenType.NONE) {
                ts.consumeToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyTokenStream(InputStream in){
        this.in = in;
        buffer = new byte[1024];
        try {
            length = in.read(buffer);
            currentToken = getNextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Token getToken() throws IOException {

        return currentToken;
    }

    @Override
    public void consumeToken() {
            //System.out.println(currentToken.value+"");
        try {
            currentToken = getNextToken();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private Token getNextToken() throws IOException{
        if(length==0)
            return null;
        while(position<length){
            while(buffer[position]==' '||buffer[position]=='\t'){
                position++;
            }
            if(buffer[position]=='\n')
                return new Token(Token.TokenType.NONE,"");
            if (buffer[position] == '(') {
                position++;
                return new Token(Token.TokenType.LPAR, "(");
            }

            if (buffer[position] == ')') {
                position++;
                return new Token(Token.TokenType.RPAR, ")");
            }

            if (buffer[position] == '+') {
                position++;
                return new Token(Token.TokenType.PLUS, "+");
            }

            if (buffer[position] == '-') {
                position++;
                return new Token(Token.TokenType.MINUS, "-");
            }

            if (buffer[position] == '*') {
                position++;
                return new Token(Token.TokenType.MULT, "*");
            }

            if (buffer[position] == '/') {
                position++;
                return new Token(Token.TokenType.DIV, "/");
            }
            if(buffer[position]<'9'&&buffer[position]>'0'){
                int temp=0;
                while(buffer[position]<='9'&&buffer[position]>='0'){
                    temp = temp*10 + (buffer[position]-'0');
                    position++;
                }
                return new Token(Token.TokenType.INT,temp);
            }
            position++;
        }
        return null;
    }
    /**public int showStatus(Token t){
     switch(t.tokenType){
     case To
     }
     }*/


}
