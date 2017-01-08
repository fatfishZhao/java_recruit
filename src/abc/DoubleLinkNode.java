package abc;

/**
 * Created by Administrator on 2017/1/8.
 */
public class DoubleLinkNode {
    public int data;
    public DoubleLinkNode next;
    public DoubleLinkNode prev;

    public DoubleLinkNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}