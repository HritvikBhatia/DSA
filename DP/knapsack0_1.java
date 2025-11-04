package DP;

public class knapsack0_1 {
    static int[][] dp;

    //initialize dp and start recursion
    public static int knapSack(int W, int[] wt, int[] val, int n) {
        dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++)
            for (int w = 0; w <= W; w++)
                dp[i][w] = -1;

        return helper(W, wt, val, n);
    }

    // Recursive helper
    private static int helper(int W, int[] wt, int[] val, int n) {
        // Base case: no items or no capacity
        if (n == 0 || W == 0)
            return 0;

        // If already computed
        if (dp[n][W] != -1)
            return dp[n][W];

        // If item doesn't fit, skip it
        if (wt[n - 1] > W)
            dp[n][W] = helper(W, wt, val, n - 1);
        else {
            // Two choices: take it or leave it
            int take = val[n - 1] + helper(W - wt[n - 1], wt, val, n - 1);
            int notTake = helper(W, wt, val, n - 1);
            dp[n][W] = Math.max(take, notTake);
        }

        return dp[n][W];
    }

    // Example run
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt  = {10, 20, 30};
        int W = 50;
        int n = val.length;

        System.out.println("Max value = " + knapSack(W, wt, val, n)); // 220
    }
}