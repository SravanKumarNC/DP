package LongestCommonSubseaquence;

public class FormPalindrom {
    static int countMin(String str)
    {
        int n = str.length();
        String t = str;

        String ss=new StringBuilder(str).reverse().toString();

        int dp[][] = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(t.charAt(i - 1) == ss.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return n - dp[n][n];
    }
}
