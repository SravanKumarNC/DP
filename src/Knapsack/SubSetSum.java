package Knapsack;

import java.util.Arrays;

public class SubSetSum {
    static Boolean helper(int index, int arr[], int target, int dp[][]){
        if(target == 0){
            return true;
        }

        if(index == 0){
            return arr[index] == target;
        }

        if(dp[index][target] != -1){
            return dp[index][target] == 1 ? true : false;
        }

        boolean notTake = helper(index - 1, arr, target, dp);

        boolean take = false;
        if(arr[index] <= target){
            take = helper(index - 1, arr, target - arr[index], dp);
            dp[index][target] = take || notTake ? 1 : 0;
        }
        return take || notTake;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){

        int dp[][] = new int[N + 1][sum+1];

        for( int row[] : dp){
            Arrays.fill(row,-1);
        }
        return helper(N - 1, arr, sum, dp);
    }
}
