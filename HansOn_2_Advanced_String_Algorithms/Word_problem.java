public class Word_problem {
 
Node root = new Node();
int minWordBreak = Integer.MAX_VALUE;
 
    class Node {
        boolean endOfTree;
        Node children[] = new Node[26];
        Node(){
            endOfTree = false;
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
 
    void insert(String key){
        int length = key.length();
 
        int index;
 
        Node temp = root;
 
        for(int i = 0; i < length; i++)
        {
            index = key.charAt(i)- 'a';
 
            if(temp.children[index] == null)
                temp.children[index] = new Node();
 
            temp = temp.children[index];
        }
         
        temp.endOfTree = true;
 
    }
    void minWordBreak(String key)
    {
        minWordBreak = Integer.MAX_VALUE;
         
        minWordBreakUtil(root, key, 0, Integer.MAX_VALUE, 0);
    }
     
    void minWordBreakUtil(Node node, String key,
                int start, int min_Break, int level)
    {
        Node temp = node;
 
        if (start == key.length()) {
            min_Break = Math.min(min_Break, level - 1);
            if(min_Break<minWordBreak){
                minWordBreak = min_Break;
            }
            return;
        }
 
        for (int i = start; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.children[index]==null)
                return;
            if (temp.children[index].endOfTree) {
                minWordBreakUtil(root, key, i + 1,
                        min_Break, level + 1);
 
            }
            temp = temp.children[index];
        }
    }
 
    public static void main(String[] args)
    {
        String keys[] = {"cat", "mat", "ca", "ma",
                    "at", "c", "dog", "og", "do" };
 
        Word_problem trie = new Word_problem();
 
         
        int i;
        for (i = 0; i < keys.length ; i++)
            trie.insert(keys[i]);
         
        trie.minWordBreak("catmatat");
 
        System.out.println(trie.minWordBreak);
    }
}