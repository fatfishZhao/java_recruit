package abc;

/**
 * Created by Administrator on 2017/1/8.
 */
public class DoubleLinkList {
    public DoubleLinkNode head;
    public DoubleLinkNode tail;
    public static void main(String[] args) {

    }
    public void DoubleLinkList(DoubleLinkNode d){
        head = d;
        tail = d;
    }
     // 查询第 index 项的内容
     public DoubleLinkNode queryNode(int index){
         DoubleLinkNode cur = head;
         for (int i=0;i<index;i++){
             cur = cur.next;
             if (cur==null){
                 System.out.println("越界了");
                 break;
             }
         }
         return cur;
     }
    // 将 toBeDelete 从链表中删除
    public void deleteNode(DoubleLinkNode toBeDelete){
        DoubleLinkNode cur = head;

        if (toBeDelete==head){//开头就是要删除的节点
            head.next.prev=null;
            head = head.next;
            return;
        }else if(head!=tail){//头尾不是同一个节点
            cur = head.next;
        }else//头尾节点是同一个
            return;
        while(true){
            if(cur==toBeDelete){
                if(cur!=tail)//如果要删除的不是最后的一个节点
                    cur.next.prev = cur.prev;
                else{
                    tail = cur.prev;//改变tail的节点
                }
                cur.prev.next = cur.next;
                break;
            }
            if(cur==tail) {//遍历到结尾还没找到就退出
                System.out.println("没有找到这个节点");
                break;
            }
            cur = cur.next;
        }
    }
    // 将toBeInsert插入到pos结点后面
    public void insertNode(DoubleLinkNode pos, DoubleLinkNode toBeInsert){
        DoubleLinkNode cur =head;

        while(true){
            if (cur == pos){
                if (cur==tail){//如果当前节点是结尾，只需要改新插入节点左侧的连接线
                    tail = toBeInsert;
                }
                else{
                    cur.next.prev = toBeInsert;
                    toBeInsert.next = cur.next;
                }
                cur.next=toBeInsert;
                toBeInsert.prev = cur;
                break;
            }
            if (cur==tail){
                System.out.println("没有找到这个节点");
                break;
            }
            cur = cur.next;
        }
    }
}

