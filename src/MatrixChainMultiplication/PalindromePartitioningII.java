package MatrixChainMultiplication;

import java.util.Arrays;

public class PalindromePartitioningII {
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }

    public int slove(String s, int i, int j, int dp[][] ){
        if(i >= j){
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int k = i; k < j; k++){
            if(isPalindrome(s, i, k)){
                int temp = slove(s, k + 1, j, dp) + 1;
                ans = Math.min(ans,temp);
            }

        }
        return dp[i][j] = ans;
    }

    public int minCut(String s) {
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        return slove(s, 0, n - 1,dp);
    }
}
