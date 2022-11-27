import java.util.ArrayList;
import java.util.List;


public class Trie {
	private static final int ALPHABET_SIZE = 256;
    private Node root;
	
    private class Node {
    	boolean isEndOfWord;
    	Node[] children;
    	
        public Node() {
            isEndOfWord = true;
            children = new Node[ALPHABET_SIZE];
        }
    }
    
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
    	Node current = root;
    	for(int i=0, L=word.length(); i<L; i++) {
        	int id = word.charAt(i) - 0;
        	if(current.children[id]==null) {
        		current.children[id] = new Node();
        		current.children[id].isEndOfWord = false;
        	}
        	current = current.children[id];
        }
        current.isEndOfWord = true;
    }

    public List<String> listWords() {
    	List<String> list = new ArrayList<>();
    	list(root, 0, "", list);
    	return list;
    }
    private void list(Node current, int id, String prefix, List<String> list) {
    	if(current==null) return;
    	for(int i=0; i<ALPHABET_SIZE; i++) {
			Node child = current.children[i];
    		if(child!=null) {
    			String res = prefix + (char)i;
    			if(child.isEndOfWord) list.add(res);
    			list(child, i, res, list);
    		}
    	}
    }
    
    public void print() {
        print("", root, 0, true, true);
    }
    private void print(String prefix, Node root, int id, boolean isTail, boolean isRoot) {
    	if(!isRoot) System.out.println(prefix 
    			+ (isTail ? "└── " : "├── ") 
    			+ (char)id 
    			+ (root.isEndOfWord ? " ***" : ""));
    	
    	Node lastChild = null; 
    	int lastChildId = 0; 
    	boolean isLastChild = true;
    	for (int i=ALPHABET_SIZE-1; i>=0; i--) {
            if(root.children[i]!=null) {
            	if(isLastChild) {
            		isLastChild = false;
	            	lastChild = root.children[i];
	            	lastChildId = i;
            	}
            	else print(prefix + (isRoot ? "" : (isTail ? "    " : "│   ")), root.children[i], i, false, false);
            }
        }
        if (lastChild!=null) {
            print(prefix + (isRoot ? "" : (isTail ?"    " : "│   ")), lastChild, lastChildId, true, false);
        }
    }

    public static void main(String[] args) {
    	Trie trie = new Trie();
    	trie.insert("abc");
    	trie.insert("bay");
    	trie.insert("bey");
    	trie.insert("bea");
    	trie.insert("bed");
    	trie.insert("bee");
    	trie.insert("boy");
    	trie.insert("boyc");
    	trie.insert("boyd");
    	trie.insert("boye");
    	trie.insert("boycd");
    	trie.insert("bye-bye");
    	trie.insert("by-by");
    	trie.insert("bye");
    	trie.insert("zad");
    	trie.insert("zed");
    	trie.insert("zef");
    	
    	System.out.println("trie content (*** indicates the end of a word): ");
    	trie.print();
    	System.out.println();

    	System.out.println("list of words in trie: ");
    	System.out.println(trie.listWords());
    	System.out.println();
    	
    	// System.out.println("contains boy? " + trie.contains("boy"));
    	// System.out.println("contains bo? " + trie.contains("bo"));
    	// System.out.println("contains boye? " + trie.contains("boye"));
    	// System.out.println("contains byebye? " + trie.contains("byebye"));
    	// System.out.println("contains bye-bye? " + trie.contains("bye-bye"));
    	
    	// System.out.println();
    	
    	// System.out.println("contains prefix bo? " + trie.containsPrefix("bo"));
    	// System.out.println("contains prefix b o? " + trie.containsPrefix("b o"));
    	// System.out.println("contains prefix bye? " + trie.containsPrefix("bye"));
    	// System.out.println("contains prefix ye? " + trie.containsPrefix("ye"));
    	
    	
    }
}