package abc;

/**
 * Created by Administrator on 2016/12/26.
 */
import java.io.IOException;

public class HouzhuiExpression {
    public static void main(String[] args) {

        TokenStream ts = new MyTokenStream(System.in); // 标准输入的适配器
        Stack s = new Stack(20);
        try {
            while (ts.getToken().tokenType != Token.TokenType.NONE) {
                if(ts.getToken().tokenType == Token.TokenType.INT)
                    s.push((int)ts.getToken().value);
                else{
                    int[] nums = new int[2];
                    if(ts.getToken().tokenType == Token.TokenType.PLUS){
                        nums = pop2num(s);
                        int temp = nums[0]+nums[1];
                        s.push(temp);
                    }else if(ts.getToken().tokenType == Token.TokenType.MINUS){
                        nums = pop2num(s);
                        int temp = nums[0]-nums[1];
                        s.push(temp);
                    }else if(ts.getToken().tokenType == Token.TokenType.MULT){
                        nums = pop2num(s);
                        int temp = nums[0]*nums[1];
                        s.push(temp);
                    }else if(ts.getToken().tokenType == Token.TokenType.DIV){
                        nums = pop2num(s);
                        int temp = nums[0]/nums[1];
                        s.push(temp);
                    }
                }
                ts.consumeToken();

            }
            System.out.print(s.pop());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[] pop2num(Stack s){
        int[] nums = new int[2];
        nums[1] = (int)s.pop();
        nums[0] = (int)s.pop();
        return  nums;
    }
}
