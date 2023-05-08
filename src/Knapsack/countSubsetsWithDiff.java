package Knapsack;

import java.util.Arrays;

public class countSubsetsWithDiff {
    static int mod =(int)(Math.pow(10,9)+7);
    public int helper(int index, int target, int arr[], int dp[][]){

        if(index == 0){
            if(arr[0] == 0 && target == 0){
                return 2;
            }
            if(arr[0] == target || target == 0){
                return 1;
            }
            return 0;
        }

        if(dp[index][target] != -1){
            return dp[index][target];
        }
        int notTake = helper(index - 1, target, arr, dp)%mod;

        int take = 0;
        if(arr[index] <= target){
            take = helper(index - 1, target - arr[index], arr, dp)%mod;
        }
        return dp[index][target] = (take + notTake)%mod;
    }

    public int countPartitions(int n, int d, int arr[]){
        int total = 0;
        for(int it : arr){
            total += it;

        }
        if(total - d < 0){
            return 0;
        }
        if((total - d)%2 == 1){
            return 0;
        }
        int sum = (total - d)/2;

        int dp[][] = new int[n][sum + 1];

        for(int row[]: dp){
            Arrays.fill(row,-1);
        }

        return helper(n-1,sum,arr,dp);



    }
}
