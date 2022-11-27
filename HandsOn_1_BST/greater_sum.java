class Node {
 
    int data;
    Node left, right;
 
    Node(int d) {
        data = d;
        left = right = null;
    }
}
 
class Sum {
 
    int sum = 0;
}
 
class greater_sum {
 
    static Node root;
    Sum summ = new Sum();
 
    void addGreaterUtil(Node node, Sum sum_ptr) {
 
        if (node == null) {
            return;
        }
 
        addGreaterUtil(node.right, sum_ptr);
 
        sum_ptr.sum = sum_ptr.sum + node.data;
 
        node.data = sum_ptr.sum;
 
        addGreaterUtil(node.left, sum_ptr);
    }
 
    Node addGreater(Node node) {
        addGreaterUtil(node, summ);
        return node;
    }
 
    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
 
    public static void main(String[] args) {
        greater_sum tree = new greater_sum();
        tree.root = new Node(5);
        tree.root.left = new Node(2);
        tree.root.right = new Node(13);
 
        System.out.println("Inorder traversal of given tree ");
        tree.printInorder(root);
        Node node = tree.addGreater(root);
        System.out.println("");
        System.out.println("Inorder traversal of modified tree ");
        tree.printInorder(node);
        System.out.println("");
    }
}