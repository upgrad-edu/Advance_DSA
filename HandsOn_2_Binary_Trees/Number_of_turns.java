public class Number_of_turns {
 
    static int Count;
 
    static class Node {
        Node left, right;
        int key;
 
        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }
 
    static Node findLCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
 
        if (root.key == n1 || root.key == n2)
            return root;
 
        Node left_lca = findLCA(root.left, n1, n2);
        Node right_lca = findLCA(root.right, n1, n2);
 
        if (left_lca != null && right_lca != null)
            return root;
 
        return (left_lca != null) ? left_lca : right_lca;
    }
 
    static boolean CountTurn(Node root, int key, boolean turn) {
        if (root == null)
            return false;
 
        if (root.key == key)
            return true;
 
        if (turn == true) {
            if (CountTurn(root.left, key, turn))
                return true;
            if (CountTurn(root.right, key, !turn)) {
                Count += 1;
                return true;
            }
        } else
        {
            if (CountTurn(root.right, key, turn))
                return true;
            if (CountTurn(root.left, key, !turn)) {
                Count += 1;
                return true;
            }
        }
        return false;
    }
 
    static int NumberOfTurn(Node root, int first, int second) {
        Node LCA = findLCA(root, first, second);
 
        if (LCA == null)
            return -1;
        Count = 0;
 
        if (LCA.key != first && LCA.key != second) {
 
            if (CountTurn(LCA.right, second, false)
                    || CountTurn(LCA.left, second, true))
                ;
 
            if (CountTurn(LCA.left, first, true)
                    || CountTurn(LCA.right, first, false))
                ;
            return Count + 1;
        }
 
        if (LCA.key == first) {
 
            CountTurn(LCA.right, second, false);
            CountTurn(LCA.left, second, true);
            return Count;
        } else {
 
            CountTurn(LCA.right, first, false);
            CountTurn(LCA.left, first, true);
            return Count;
        }
    }
 
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);
 
        int turn = 0;
        if ((turn = NumberOfTurn(root, 5, 10)) != 0)
            System.out.println(turn);
        else
            System.out.println("Not Possible");
    }
 
}