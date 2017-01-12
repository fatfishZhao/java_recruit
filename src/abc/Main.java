package abc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Main {
    public static void main(String args[]) {
        String a=null;
        String b=null;
        //System.out.print(a==b);
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(null);
        //System.out.print(a1.contains(null));
        Deque<Integer> q = new LinkedList<>();
        //Deque<Integer> q = new ArrayDeque<>();
        long begin = System.nanoTime();
        test(q);
        long end = System.nanoTime();
        System.out.println("LinkedList took " + (end - begin) + "ns");

        Deque<Integer> p = new ArrayDeque<>();
        begin = System.nanoTime();
        test(p);
        end = System.nanoTime();
        System.out.println("ArrayDeque took " + (end - begin) + "ns");

    }

    public static <T extends Addable<T>> T add(T o1, T o2) {
        return o1.add(o2);
    }
    public static void test(Deque<Integer> q) {
        long tmp1sum=0,tmp2sum=0;
        long tmp1 = System.nanoTime(),tmp2 = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10_0000; j++) {
                q.addLast(j);
            }
            tmp1 = System.nanoTime();
            tmp1sum = tmp1-tmp2+tmp1sum;

            for (int j = 0; j < 10_0000; j++) {
                q.removeFirst();
            }
            tmp2 = System.nanoTime();
            tmp2sum = tmp2-tmp1+tmp2sum;
        }
        System.out.println("插入耗时"+tmp1sum);
        System.out.println("删除耗时"+tmp2sum);
    }

}

interface Addable<T> {
    T add(T o1);
}
class Test implements Addable<Test>{
    int test;
    Test(int test){
        this.test = test;
    }
    public Test add(Test t){
        return new Test(this.test+t.test);
        //return null;
    }

}
