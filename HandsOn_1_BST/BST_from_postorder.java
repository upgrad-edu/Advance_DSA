class Node{
    int data;
    Node left, right;
 
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}
 
class Index{
    int postindex = 0;
}
 
class BST_from_postorder{
    Node constructTreeUtil(int post[], Index postIndex, int key, int min, int max, int size){
        if (postIndex.postindex < 0)
            return null;
 
        Node root = null;
 
        if (key > min && key < max)
        {
            root = new Node(key);
            postIndex.postindex = postIndex.postindex - 1;
 
            if (postIndex.postindex >= 0)
            {
                root.right = constructTreeUtil(post, postIndex, post[postIndex.postindex],key, max, size);
 
                root.left = constructTreeUtil(post, postIndex, post[postIndex.postindex],min, key, size);
            }
        }
        return root;
    }
 
    Node constructTree(int post[], int size){
        Index index = new Index();
        index.postindex = size - 1;
        return constructTreeUtil(post, index, post[index.postindex], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }
 
    void printInorder(Node node){
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
 
    public static void main(String[] args){
        BST_from_postorder tree = new BST_from_postorder();
        int post[] = new int[]{1, 7, 5, 50, 40, 10};
        int size = post.length;
 
        Node root = tree.constructTree(post, size);
 
        System.out.println("Inorder traversal of the constructed tree:");
        tree.printInorder(root);
    }
}