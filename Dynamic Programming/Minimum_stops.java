class Minimum_stops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int ret = 10000;
        int N = stations.length;

        int dp[][] = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = startFuel;

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (dp[i][j] + (i >= 1 ? stations[i - 1][0] : 0) - target >= 0) {
                    ret = Math.min(ret, j);
                }
                if (i < N) {
                    int remain = dp[i][j] + (i >= 1 ? stations[i - 1][0] : 0) - stations[i][0];
                    if (remain >= 0) {
                        dp[i + 1][j] = Math.max(dp[i + 1][j], remain);
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], remain + stations[i][1]);
                    }
                }
            }
        }

        return ret >= 10000 ? -1 : ret;
    }


}
