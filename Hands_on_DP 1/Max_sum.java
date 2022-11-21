
class Max_sum {

	public static int maxSum(List<Integer> A) {
		// Write your code here
		int n = A.size();
		   int prev = A.get(0);
    int prev2 =0;
    for(int i=1; i<n; i++){
        int pick = A.get(i);
        if(i>1)
            pick += prev2;
        int nonPick = 0 + prev;
        int cur = Math.max(pick, nonPick);
        prev2 = prev;
        prev = cur;
    }
    return prev;
		
	}
}
