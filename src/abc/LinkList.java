package abc;

/**
 * Created by Administrator on 2017/1/8.
 */
public class LinkList {
    public LinkNode head;
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.initLinkList(new LinkNode("A"));
        linkList.insertToEnd(new LinkNode("B"));
        linkList.insertToEnd(new LinkNode("C"));
        linkList.insertToEnd(new LinkNode("D"));
        linkList.insertToEnd(new LinkNode("E"));
        linkList.queryNode(0).sibling = linkList.queryNode(3);
        linkList.queryNode(1).sibling = linkList.queryNode(2);
        linkList.queryNode(2).sibling = linkList.queryNode(4);
    }
    public void initLinkList(LinkNode linkNode){
        head = linkNode;
    }
    public LinkNode queryNode(int index) {
        LinkNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur;
    }
    public String queryData(int index) {
        LinkNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.data;
    }
    public LinkNode findPrevious(LinkNode temp) {
        LinkNode cur = head;
        while (cur != null) {
            if (cur.next == temp)
                return cur;

            cur = cur.next;
        }

        return null;
    }
    public void insertToEnd(LinkNode linkNode){
        LinkNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = linkNode;
    }
    public void deleteNode(LinkNode toBeDelete){
        LinkNode cur = head,LinkNode,lastCur = head;
        if (toBeDelete==head){//开头就是要删除的节点
            head = head.next;
            return;
        }else if(head.next!=null){//头尾不是同一个节点
            cur = head.next;
        }else//头尾节点是同一个
            return;
        while(true){
            if(cur==toBeDelete){
                lastCur.next = cur.next;
                break;
            }
            if(cur.next==null) {//遍历到结尾还没找到就退出
                System.out.println("没有找到这个节点");
                break;
            }
            lastCur = cur;
            cur = cur.next;
        }
    }

}
