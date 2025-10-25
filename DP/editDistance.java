package DP;
/*
 * need to convert str1 (n length) into srt2(m)
 * we have to count the minimum number of operation to do it
 * we starts from end of the str  check if str1(n) == str2(m) 
 * 1. same
 *      str1 = abcd str2 = bcd
 *      - no operation needed 
 *          str1(n-1) str2(m-1)
 *      str1 = abc str2 = bc
 * 2. different
 *    operations  
 *      str1 = abcd str2 = bcde
 *      - add
 *          str1 = abcde
 *          str1(n) str2(m-1) + 1  (plus cause we done a operation)
 *          str1 = abcd str2 = bcd    
 *      - delete
 *          str1 = abc
 *          str1(n-1) str2(m) + 1
 *          str1 = abcd str2 = bcde    
 *      - replace
 *          str1 = abce
 *          str1(n-1) str2(m-1)
 *          str1 = abc str2 = bcd    
*/ 
public class editDistance {

    public static int editDist(String str1, String str2, int n, int m, int dp[][]){
        if(n==0) return m;
        if(m==0) return n;

        if (dp[n][m] != -1) return dp[n][m];

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = editDist(str1, str2, n-1, m-1, dp);
        }else{
            //add
            int a = editDist(str1, str2, n, m-1, dp) + 1;
            //delete
            int b = editDist(str1, str2, n-1, m, dp) + 1;
            //replace
            int c = editDist(str1, str2, n-1, m-1, dp) + 1;

            dp[n][m] = Math.min(a, Math.min(b, c));
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        int result = editDist(str1, str2, n, m, dp);
        System.out.println("Minimum edit distance: " + result);
    }
}