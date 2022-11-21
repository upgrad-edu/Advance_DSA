class longest_palindromic_subsequence {
 
    static int max(int x, int y) {
        return (x > y) ? x : y;
    }
    
    static int longest_palin_sub(char seq[], int i, int j) {
        if (i == j) {
            return 1;
        }
 
        if (seq[i] == seq[j] && i + 1 == j) {
            return 2;
        }
 
        if (seq[i] == seq[j]) {
            return longest_palin_sub(seq, i + 1, j - 1) + 2;
        }
 
        return max(longest_palin_sub(seq, i, j - 1), longest_palin_sub(seq, i + 1, j));
    }
 
 
    public static void main(String[] args) {
        String seq = "bbbababbb";
        int n = seq.length();
        System.out.println(longest_palin_sub(seq.toCharArray(), 0, n - 1));
 
    }
}