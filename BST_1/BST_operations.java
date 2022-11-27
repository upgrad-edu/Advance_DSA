public class BST_operations {  

    public static class Node{  
        int data;  
        Node left;  
        Node right;  

        public Node(){

        }

        public Node(int data){  
            this.data = data;  
            this.left = null;  
            this.right = null;  
        }  
    }  

    public Node root;  
    static Node pre = new Node();
    static Node suc = new Node();
 
    public BST_operations(){  
        root = null;  
    }  

    public void insert(int data) {  
        Node newNode = new Node(data);  

        if(root == null){  
            root = newNode;  
            return;  
        }  
        else {  
            Node current = root, parent = null;  

            while(true) {  
                parent = current;  

                if(data < current.data) {  
                    current = current.left;  
                    if(current == null) {  
                        parent.left = newNode;  
                        return;  
                    }  
                }  
                else {  
                    current = current.right;  
                    if(current == null) {  
                        parent.right = newNode;  
                        return;  
                    }  
                }  
            }  
        }  
    }  

    public Node minNode(Node root) {  
        if (root.left != null)  
            return minNode(root.left);  
        else  
            return root;  
    }  

    public Node deleteNode(Node node, int value) {  
        if(node == null){  
            return null;  
        }  
        else {  
            if(value < node.data)  
                node.left = deleteNode(node.left, value);  

            else if(value > node.data)  
                node.right = deleteNode(node.right, value);  

            else {  
                if(node.left == null && node.right == null)  
                    node = null;  

                else if(node.left == null) {  
                    node = node.right;  
                }  

                else if(node.right == null) {  
                    node = node.left;  
                }  

                else {  
                    Node temp = minNode(node.right);  
                    node.data = temp.data;  
                    node.right = deleteNode(node.right, temp.data);  
                }  
            }  
            return node;  
        }  
    }  

    public int smallestElement(Node temp){  
        if(root == null) {  
            System.out.println("Tree is empty");  
            return 0;  
        }  
        else {  
            int leftMin, rightMin;  
            int min = temp.data;  

            if(temp.left != null){  
                leftMin = smallestElement(temp.left);  
                min = Math.min(min, leftMin);  
            }  

            if(temp.right != null){  
                rightMin = smallestElement(temp.right);  
                min = Math.min(min, rightMin);  
            }  
            return min;  
        }  
    }  


    public int largestElement(Node temp){  
        if(root == null) {  
            System.out.println("Tree is empty");  
            return 0;  
        }  
        else{  
            int leftMax, rightMax;  
            int max = temp.data;  

            if(temp.left != null){  
                leftMax = largestElement(temp.left);  
                max = Math.max(max, leftMax);  
            }  

            if(temp.right != null){  
                rightMax = largestElement(temp.right);  
                max = Math.max(max, rightMax);  
            }  
            return max;  
        }  
    }  

    static void findPreSuc(Node root, int key)
    {
         
        if (root == null)
            return;
     
        if (root.data == key)
        {
             
            if (root.left != null)
            {
                Node tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;
                     
                pre = tmp;
            }
     
            if (root.right != null)
            {
                Node tmp = root.right;
                 
                while (tmp.left != null)
                    tmp = tmp.left;
                     
                suc = tmp;
            }
            return;
        }
     
        if (root.data > key)
        {
            suc = root;
            findPreSuc(root.left, key);
        }
         
        else
        {
            pre = root;
            findPreSuc(root.right, key);
        }
    }

    public void inorderTraversal(Node node) {  

        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
        }  
        else {  

            if(node.left!= null)  
                inorderTraversal(node.left);  
                System.out.print(node.data + " ");  
            if(node.right!= null)  
                inorderTraversal(node.right);  

        }  
    }  

    public static void main(String[] args) {  

        int key = 70;
        BST_operations bt = new BST_operations();  
        bt.insert(50);  
        bt.insert(30);  
        bt.insert(70);  
        bt.insert(60);  
        bt.insert(10);  
        bt.insert(90);  

        System.out.println("Binary search tree after insertion:");  
        bt.inorderTraversal(bt.root);  

        Node deletedNode = null;  
        
        deletedNode = bt.deleteNode(bt.root, 30);  
        System.out.println("\nBinary search tree after deleting node 30:");  
        bt.inorderTraversal(bt.root);  

        System.out.println("\nSmallest element in the binary tree: " + bt.smallestElement(bt.root));    
        System.out.println("Largest element in the binary tree: " + bt.largestElement(bt.root));  

        bt.findPreSuc(bt.root, key);
        if (pre != null)
            System.out.println("Predecessor is " + pre.data);
        else
            System.out.println("No Predecessor");
     
        if (suc != null)
            System.out.println("Successor is " + suc.data);
        else
            System.out.println("No Successor");
    
        

    }  
}  