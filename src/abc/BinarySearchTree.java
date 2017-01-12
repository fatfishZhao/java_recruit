package abc;

/**
 * Created by Administrator on 2017/1/12.
 */
public class BinarySearchTree<T extends Comparable<T>>{
    public Node root;

    public static void main(String args[]) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(0);
        System.out.println(tree.contains(3));
        tree.pre_oder(tree.root);
    }
    public void pre_oder(Node n){
        System.out.println(n.data);
        if(n.left!=null){
            pre_oder(n.left);
        }
        if (n.right!=null){
            pre_oder(n.right);
        }
    }
    public boolean contains(T t){
        if (root == null) {
            return false;
        }
        Node current = root;
        while (true) {
            // 如果 i 比当前结点的值小
            if (t.compareTo((T) current.data) < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    break;
                }
            } else if (t.compareTo((T) current.data) > 0){
                if (current.right != null)
                    current = current.right;
                else {
                    break;
                }
            }else{
                return true;
            }
        }
        return false;
    }
    public boolean insert(T i) {
        if (root == null) {
            root = new Node(i);
            return true;
        }

        Node current = root;
        while (true) {
            // 如果 i 比当前结点的值小
            if (i.compareTo((T) current.data) < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(i);
                    break;
                }
            } else {
                if (current.right != null)
                    current = current.right;
                else {
                    current.right = new Node(i);
                    break;
                }
            }
        }
        return true;
    }
}
