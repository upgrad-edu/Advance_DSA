	
class Node {    
    int value; 
        Node left, right; 
          
        Node(int value){ 
            this.value = value; 
            left = null; 
            right = null; 
        } 
    }
  
class BinaryTree { 
    static int max_level = 0;
       
    public void insert(Node node, int value) {
        if (value < node.value) { if (node.left != null) { insert(node.left, value); } else { System.out.println(" Inserted " + value + " to left of " + node.value); node.left = new Node(value); } } else if (value > node.value) {
          if (node.right != null) {
            insert(node.right, value);
          } else {
            System.out.println("  Inserted " + value + " to right of " + node.value);
            node.right = new Node(value);
          }
        }
      }

    static int findMax(Node node){
        if (node == null)
            return Integer.MIN_VALUE;
 
        int res = node.value;
        int lres = findMax(node.left);
        int rres = findMax(node.right);
 
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }


    static boolean ifNodeExists( Node node, int key)
    {
        if (node == null)
            return false;
     
        if (node.value == key)
            return true;
     
        boolean res1 = ifNodeExists(node.left, key);
       
        if(res1) return true;
        
        boolean res2 = ifNodeExists(node.right, key);
     
        return res2;
    }
    
    Node deleteRec(Node root, int key)
    {
        if (root == null)
            return root;
  
        if (key < root.value)
            root.left = deleteRec(root.left, key);
        else if (key > root.value)
            root.right = deleteRec(root.right, key);
  
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
  
            root.value = minValue(root.right);
  
            root.right = deleteRec(root.right, root.value);
        }

  
        return root;
    } 

    int minValue(Node root)
    {
        int minv = root.value;
        while (root.left != null) 
        {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }


    void leftViewUtil(Node node, int level)
    {
        if (node == null)
            return;
 
        if (max_level < level) {
            System.out.print(node.value + " ");
            max_level = level;
        }
 
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }
 
    void leftView(Node root)
    {
        max_level = 0;
        leftViewUtil(root, 1);
    }


    int diameter(Node root)
    {
        if (root == null)
            return 0;
 
        int lheight = height(root.left);
        int rheight = height(root.right);
 
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
 
        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    static int height(Node node)
    {
        if (node == null)
            return 0;
 
        return (1
                + Math.max(height(node.left), height(node.right)));
    }

    boolean identicalTrees(Node a, Node b)
    {
        if (a == null && b == null)
            return true;
 
        if (a != null && b != null)
            return (a.value == b.value && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));
 
        return false;
    }


     
}
public class Binary_tree_operations{
     public static void main(String args[]) 
    { 
        BinaryTree tree = new BinaryTree();
        Node root = new Node(5);
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);
        
        System.out.println("Maximum element is "+ tree.findMax(root));
        
        int key = 4;
 
        if (tree.ifNodeExists(root, key))
            System.out.println("Element present in tree");
        else
            System.out.println("Element is not present in tree");    
        
        System.out.println("\nDelete 8");
        tree.deleteRec(root,8);

        tree.leftView(root);
        System.out.println("\n");

        System.out.println("The diameter of given binary tree is : " + tree.diameter(root));

        Node root2 = new Node(5);
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root2, 2);
        tree.insert(root2, 4);
        tree.insert(root2, 8);
        tree.insert(root2, 6);
        tree.insert(root2, 7);
        tree.insert(root2, 3);
        tree.insert(root2, 9);

        if (tree.identicalTrees(root, root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");

    }
}