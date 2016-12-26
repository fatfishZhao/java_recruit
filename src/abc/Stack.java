package abc;

/**
 * Created by Administrator on 2016/12/25.
 */
import java.io.IOException;
import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> list;

    public Stack(int size) {
        this.list = new ArrayList<T>(size);
    }

    public T getTop() {
        if (isEmpty())
            return null;

        return list.get(list.size() - 1);
    }

    public void push(T t) {
        this.list.add(t);
    }

    public T pop() {
        if (isEmpty())
            return null;

        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }


    public static void main(String args[]) throws IOException {
        byte[] buf = new byte[128];
        int length = System.in.read(buf);

        Stack s = new Stack(128);

        for (int i = 0; i < length; i++) {
            if (buf[i] == '(' || buf[i] == '[' || buf[i] == '{') {
                s.push(buf[i]);
            }
            else if (buf[i] == ')') {
                if ((char)s.getTop() == '(')
                    s.pop();
                else {
                    System.out.println("1 unmatch!");
                    System.exit(1);
                }
            }
            else if (buf[i] == ']') {
                if ((char)s.getTop() == '[')
                    s.pop();
                else {
                    System.out.println("2 unmatch!");
                    System.exit(1);
                }
            }
            else if (buf[i] == '}') {
                if ((char)s.getTop() == '{')
                    s.pop();
                else {
                    System.out.println("3 unmatch!");
                    System.exit(1);
                }
            }
        }

        if (!s.isEmpty())
            System.out.println("4 unmatch!");
        else
            System.out.println("matched~");
    }

}
