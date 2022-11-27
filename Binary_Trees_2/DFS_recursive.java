
class Node {
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
 
class DFS_recursive {
    
    Node root;
 
    DFS_recursive(){
        root = null;
    }
 
    void printInorder(Node node){
        if (node == null)
            return;
 
        printInorder(node.left);
 
        System.out.print(node.key + " ");
 
        printInorder(node.right);
    }
 
    void printPreorder(Node node) { 
        if (node == null)
            return;
 
        System.out.print(node.key + " ");
 
        printPreorder(node.left);
 
        printPreorder(node.right);
    }

    void printPostorder(Node node){
            if (node == null)
                return;
     
            printPostorder(node.left);
     
            printPostorder(node.right);
     
            System.out.print(node.key + " ");
    }

    void printInorder() { printInorder(root); }
    void printPreorder() { printPreorder(root); }
    void printPostorder() { printPostorder(root); }

 
    public static void main(String[] args)
    {
        DFS_recursive tree = new DFS_recursive();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();
        System.out.println("\nPreOrder traversal of binary tree is ");
        tree.printPreorder();
        System.out.println("\nPostOrder traversal of binary tree is ");
        tree.printPostorder();
        System.out.println();
    }
}