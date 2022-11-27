class TreeNode
{
    int value;
    TreeNode Left;
    TreeNode Right;
 
    TreeNode(int k)
    {
        value = k;
    }
}
 
class AVL_check{
    public static boolean isBST(TreeNode node){
        return (isBSTUtil(node, 0, 100));
    }
 
    public static boolean isBSTUtil(TreeNode node, int min, int max){
 
        if (node == null)
            return true;
 
        if (node.value < min || node.value > max)
            return false;
 
        return (isBSTUtil(node.Left, min, node.value - 1) && isBSTUtil(node.Right, node.value + 1, max));
    }
 
    public static boolean isBalanced(TreeNode root){
        int Left_height; 
        int Right_height;
 
        if (root == null)
            return true;
 
        Left_height = height(root.Left);
        Right_height = height(root.Right);
 
        if (Math.abs(Left_height - Right_height) <= 1 && isBalanced(root.Left)
                && isBalanced(root.Right))
            return true;
 
        return false;
    }
 
    public static int max(int a, int b){
        return (a >= b) ? a : b;
    }
 
    public static int height(TreeNode node){
        if (node == null)
            return 0;
 
        return 1 + max(height(node.Left), height(node.Right));
    }
 
    public static void main(String args[])
    {
        TreeNode tree1 = new TreeNode(1);
        tree1.Left = new TreeNode(2);
        tree1.Right = new TreeNode(3);
        tree1.Right.Left = new TreeNode(4);
        tree1.Right.Right = new TreeNode(5);
 
        TreeNode tree2 = new TreeNode(15);
        tree2.Left = new TreeNode(5);
        tree2.Right = new TreeNode(20);
        tree2.Right.Left = new TreeNode(18);
        tree2.Right.Right = new TreeNode(23);
        tree2.Left.Left = new TreeNode(4);
        tree2.Left.Right = new TreeNode(6);
 
        if (isBST(tree1) && isBalanced(tree1))
            System.out.println("Tree tree1 is AVL tree");
        else
            System.out.println("Tree tree1 is not AVL tree");
 
        if (isBST(tree2) && isBalanced(tree2))
            System.out.println("Tree tree1 is AVL tree");
        else
            System.out.println("Tree tree1 is not AVL tree");
    }
}