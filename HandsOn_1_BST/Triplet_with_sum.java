import java.io.*;
import java.util.*;
 
class Node{
  int data;
  Node left, right;  
  Node(int item)
  {
    data = item;
    left = right = null;
  }
}
 
public class Triplet_sum{
  static Node root;
 
  static boolean existsPair(Node root, int x)
  {
 
    Stack<Node> it1 = new Stack<Node>();
    Stack<Node> it2 = new Stack<Node>();
 
    Node c = root;
    while (c != null)
    {
      it1.push(c);
      c = c.left;
    }
 
    c = root;
    while (c != null){
      it2.push(c);
      c = c.right;
    }
 
    while (it1.size() > 0 && it2.size() > 0)    {
 
      int v1 = it1.peek().data;
      int v2 = it2.peek().data;
 
      if (v1 + v2 == x){
        return true;
      }
      if (v1 > v2){
        break;
      }
      if (v1 + v2 < x){
        c = it1.peek().right;
        it1.pop();
        while (c != null){
          it1.push(c);
          c = c.left;
        }
      }
 
      else{
        c = it2.peek().left;
        it2.pop();
        while(c != null){
          it2.push(c);
          c = c.right;
        }
      }
    }
    return false;
  }
 
  static boolean existsTriplet(Node root, Node curr, int x ){
 
    if(curr == null){
      return false;
    }
 
    return (existsPair(root, x - curr.data) || existsTriplet(root, curr.left, x) || existsTriplet(root, curr.right, x));
  }
 
  public static void main (String[] args){
    Triplet_sum  tree = new Triplet_sum();
    tree.root = new Node(5);
    tree.root.left = new Node(3);
    tree.root.right = new Node(7);
    tree.root.left.left = new Node(2);
    tree.root.left.right = new Node(4);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(8);
    int x = 24;
    if (existsTriplet(root, root, x)){
      System.out.println("Triplet exist");
    }
    else{
      System.out.println("Triple does not exist");
    }   
  }
}