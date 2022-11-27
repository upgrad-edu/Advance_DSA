import java.io.*;
import java.util.ArrayList;
 
class Node {
     
    int data;
    Node left, right;
     
    Node(int d) {
        data = d;
        left = right = null;
    }
}
 
class AVL_merge
{
     
    Node root;
 
    AVL_merge() {
        root = null;
    }
     
    void inorder()
    {
        inorderUtil(this.root);
    }
     
    void inorderUtil(Node node)
    {
        if(node==null)
            return;
             
        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }
     
 
    public ArrayList<Integer> storeInorderUtil(Node node, ArrayList<Integer> list)
    {
        if(node == null)
            return list;
         
        storeInorderUtil(node.left, list);
         
        list.add(node.data);
         
        storeInorderUtil(node.right, list);
         
        return list;
    }
     
    ArrayList<Integer> storeInorder(Node node)
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = storeInorderUtil(node,list1);
        return list2;
    }
 
    ArrayList<Integer> merge(ArrayList<Integer>list1, ArrayList<Integer>list2, int m, int n)
    {
        ArrayList<Integer> list3 = new ArrayList<>();
        int i=0;
        int j=0;
         
        while( i<m && j<n)
        {
            if(list1.get(i)<list2.get(j))
            {
                list3.add(list1.get(i));
                i++;
            }
            else
            {
                list3.add(list2.get(j));
                j++;
            }
        }
         
        while(i<m)
        {
            list3.add(list1.get(i));
            i++;
        }
     
        while(j<n)
        {
            list3.add(list2.get(j));
            j++;
        }
        return list3;
    }
     
    Node ALtoBST(ArrayList<Integer>list, int start, int end)
    {
        if(start > end)
            return null;
     
        int mid = (start+end)/2;
        Node node = new Node(list.get(mid));
 
    
        node.left = ALtoBST(list, start, mid-1);
         
        node.right = ALtoBST(list, mid+1, end);
     
    return node;
    }
     
    Node mergeTrees(Node node1, Node node2)
    {
        ArrayList<Integer>list1 = storeInorder(node1);
         
        ArrayList<Integer>list2 = storeInorder(node2);
         
        ArrayList<Integer>list3 = merge(list1, list2, list1.size(), list2.size());
         
        Node node = ALtoBST(list3, 0, list3.size()-1);
        return node;
    }
 
    public static void main (String[] args)
    {
         
         
        AVL_merge tree1 = new AVL_merge();
        tree1.root = new Node(100);
        tree1.root.left = new Node(50);
        tree1.root.right = new Node(300);
        tree1.root.left.left = new Node(20);
        tree1.root.left.right = new Node(70);
             
        AVL_merge tree2 = new AVL_merge();
        tree2.root = new Node(80);   
        tree2.root.left = new Node(40);
        tree2.root.right = new Node(120);
             
             
        AVL_merge tree = new AVL_merge();   
        tree.root = tree.mergeTrees(tree1.root, tree2.root);
        System.out.println("The Inorder traversal of the merged BST is: ");
        tree.inorder();
    }
}