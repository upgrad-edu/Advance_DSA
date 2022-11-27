public int Guessing_game(int n) {

	int dpRows = n+2;
	int dpCols = n+2;
	int[][] dp = new int[dpRows][dpCols];

	for(int lenSubArray = 1; lenSubArray<n; lenSubArray++) {
		for(int start = 1; start+lenSubArray<=n; start++) {
			int end = start + lenSubArray;

			dp[start][end] = Integer.MAX_VALUE;
			for(int guess = start; guess<=end; guess++) {

				int costOfGuess = guess + Math.max(dp[start][guess-1], dp[guess+1][end]);
				dp[start][end] = Math.min(dp[start][end], costOfGuess);
			}
		}  
	}
	return dp[1][n];
}