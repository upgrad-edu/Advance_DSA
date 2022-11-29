import java.util.LinkedList;
import java.util.Queue;
 
public class queue {
 
    public static void main(String[] args){
        Queue<Integer> que = new LinkedList<>();
 
        for (int i = 0; i < 10; i++)
            que.add(i);
 
        System.out.println("Elements of queue " + que);
 
        int removedele = que.remove();
        System.out.println("removed element-" + removedele);
 
        System.out.println(que);
 
        int head = que.peek();
        System.out.println("head of queue-" + head);
 
        int size = que.size();
        System.out.println("Size of queue-" + size);
    }
}