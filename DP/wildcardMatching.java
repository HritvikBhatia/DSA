package DP;
/* 
 * convert the pattern to text
 * ? can match single character
 *  txt = "aa" ptn = "a?" then ? can be replace w/ a
 * * can match sequence of character and can be empty 
 *  txt = "aa" ptn = "*" then * can be replace w/ aa
 */
public class wildcardMatching {

    public static boolean wildMatch(String txt, String ptn, int n, int m, Boolean[][] dp){

        if (n == 0 && m == 0) return true;
        if (m == 0) return false;

        if (n == 0) {
            for (int k = 0; k < m; k++) {
                if (ptn.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[n][m] != null) return dp[n][m];

        if(ptn.charAt(m - 1) == txt.charAt(n - 1) || ptn.charAt(m - 1) == '?'){
            dp[n][m] = wildMatch(txt, ptn, n-1, m-1, dp);
        }
        else if(ptn.charAt(m - 1) == '*'){
            boolean ans1 = wildMatch(txt, ptn, n, m-1, dp);
            boolean ans2 = wildMatch(txt, ptn, n-1, m, dp);

            dp[n][m] = ans1 || ans2;
        }else{
            dp[n][m] = false;
        }
        
        return dp[n][m];
    }

    public static void main(String[] args) {
        String txt = "baaabab";
        String ptn = "***ba*****ab";
        int n = txt.length();
        int m = ptn.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];

        boolean result = wildMatch(txt, ptn, n, m, dp);
        System.out.println("Does the pattern match the text: " + result);
    }
}