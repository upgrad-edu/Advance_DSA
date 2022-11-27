import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class Auto_complete {
 
    public class Node {
        Map<Character, Node> children;
        char c;
        boolean isWord;
 
        public Node(char c) {
            this.c = c;
            children = new HashMap<>();
        }
 
        public Node() {
            children = new HashMap<>();
        }
 
        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            Node child = children.get(firstChar);
            if (child == null) {
                child = new Node(firstChar);
                children.put(firstChar, child);
            }
 
            if (word.length() > 1)
                child.insert(word.substring(1));
            else
                child.isWord = true;
        }
 
    }
 
    Node root;
 
    public Auto_complete(List<String> words) {
        root = new Node();
        for (String word : words)
            root.insert(word);
 
    }
 
    public boolean find(String prefix, boolean exact) {
        Node lastNode = root;
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return false;
        }
        return !exact || lastNode.isWord;
    }
 
    public boolean find(String prefix) {
        return find(prefix, false);
    }
 
    public void suggestHelper(Node root, List<String> list, StringBuffer curr) {
        if (root.isWord) {
            list.add(curr.toString());
        }
 
        if (root.children == null || root.children.isEmpty())
            return;
 
        for (Node child : root.children.values()) {
            suggestHelper(child, list, curr.append(child.c));
            curr.setLength(curr.length() - 1);
        }
    }
 
    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        Node lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }
   
 
    public static void main(String[] args) {
        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel", "test", "help", "rat", "by", "bat", "helps","helping", "abc", "bay", "bea", "bed", "bee", "bey", "boy", "boyc", "boycd", "boyd", "boye", "by-by", "bye", "bye-bye", "zad", "zed", "zef");
        Auto_complete trie = new Auto_complete(words);
     
        System.out.println(trie.suggest("b"));
    }
 
}