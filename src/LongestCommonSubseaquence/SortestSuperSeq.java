package LongestCommonSubseaquence;

public class SortestSuperSeq {
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i <= n; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(X.charAt(i - 1) == Y.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[m][n];
        int x = X.length();
        int y = Y.length();
        return x + y - lcs;

    }
}
