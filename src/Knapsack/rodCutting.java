package Knapsack;

import java.util.Arrays;

public class rodCutting {

    public int helper(int index, int N, int prices[], int dp[][]) {
        if (index == 0) {
            return N * prices[0];
        }

        if (dp[index][N] != -1) {
            return dp[index][N];
        }

        int notTake = helper(index - 1, N, prices, dp);
        int take = Integer.MIN_VALUE;
        int length = index + 1;

        if (length <= N) {
            take = prices[index] + helper(index, N - length, prices, dp);
        }
        return dp[index][N] = Math.max(take, notTake);
    }

    public int cutRod(int price[], int n) {
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n - 1, n, price, dp);
    }

}
