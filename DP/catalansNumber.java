package DP;

public class catalansNumber {
    static int[] dp = new int[100];

    static int catalan(int n) {
        if (n <= 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - 1 - i);
        }

        dp[n] = res;
        return res;
    }

    public static void main(String[] args) {
        // initialize dp array with -1
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        int n = 5;
        System.out.println("Catalan(" + n + ") = " + catalan(n));
    }
}
