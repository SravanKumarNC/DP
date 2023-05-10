package LongestCommonSubseaquence;

public class LongestPalindromicSeq {
    public int longestPalinSubseq(String S)
    {
        String S1 = S;
        String S2 = new StringBuilder(S).reverse().toString();
        int n = S.length();

        int dp[][] = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }
}
