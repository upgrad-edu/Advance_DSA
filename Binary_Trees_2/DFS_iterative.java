import java.util.Stack;
class Node {
      
    int data;
    Node left, right;
      
    Node(int item) {
        data = item;
        left = right = null;
    }
}
  
class DFS_iterative {
      
    public static void inorderIterative(Node root)
    {
        Stack<Node> stack = new Stack<>();
    
        Node curr = root;
    
        while (!stack.empty() || curr != null)
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                curr = stack.pop();
                System.out.print(curr.data + " ");
    
                curr = curr.right;
            }
        }
    }
    public static void preorderIterative(Node root)
    {
        if (root == null) {
            return;
        }
    
        Stack<Node> stack = new Stack<>();
        stack.push(root);
    
        while (!stack.empty())
        {
            Node curr = stack.pop();
    
            System.out.print(curr.data + " ");
    
            if (curr.right != null) {
                stack.push(curr.right);
            }
    
            if (curr.left != null) {
                stack.push(curr.left);
            }
    
        }
    }

    public static void postorderIterative(Node root)
    {
        if (root == null) {
            return;
        }
 
        Stack<Node> stack = new Stack<>();
        stack.push(root);
    
        Stack<Integer> out = new Stack<>();
    
        while (!stack.empty())
        {
            Node curr = stack.pop();
            out.push(curr.data);
    
            if (curr.left != null) {
                stack.push(curr.left);
            }
    
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
    
        while (!out.empty()) {
            System.out.print(out.pop() + " ");
        }
    }


      
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        System.out.print("Inorder Traversal: ");
        inorderIterative(root);
        System.out.print("\nPreorder Traversal: ");
        preorderIterative(root);
        System.out.print("\nPostorder Traversal: ");
        postorderIterative(root);
        System.out.print("\n");
          
    }
}