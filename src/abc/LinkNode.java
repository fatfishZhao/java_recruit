package abc;

/**
 * Created by Administrator on 2017/1/8.
 */
class LinkNode {
    public String data;
    public LinkNode next;
    public LinkNode sibling;

    public LinkNode(String data) {
        this.data = data;
        this.next = null;
        this.sibling = null;
    }
}
