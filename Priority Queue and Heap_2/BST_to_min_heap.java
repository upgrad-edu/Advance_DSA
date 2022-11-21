
class Node
{
    int key;
    Node left, right;
 
    Node(int key) {
        this.key = key;
    }
}
 
class BST_to_min_heap
{
    public static Node insert(Node root, int key)
    {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    public static void printLevelOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
 
        while (!q.isEmpty())
        {
            int n = q.size();
            while (n-- > 0)
            {
                Node front = q.poll();
                System.out.print(front.key + " ");
 
                if (front.left != null) {
                    q.add(front.left);
                }
 
                if (front.right != null) {
                    q.add(front.right);
                }
            }
 
            System.out.println();
        }
    }
 
    public static void inorder(Node root, Queue<Integer> keys)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left, keys);
        keys.add(root.key);
        inorder(root.right, keys);
    }
 
    public static void preorder(Node root, Queue<Integer> keys)
    {
        if (root == null) {
            return;
        }
 
        root.key = keys.poll();
        preorder(root.left, keys);
 
        preorder(root.right, keys);
    }
 
    public static void convert(Node root)
    {
        if (root == null) {
            return;
        }
 
        Queue<Integer> keys = new ArrayDeque<>();
 
        inorder(root, keys);
 
        preorder(root, keys);
    }
 
    
}