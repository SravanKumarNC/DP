import java.util.Arrays;

public class PartitionEqualSubsetSum {
    static int helper(int ind, int arr[], int target, int dp[][]){
        if(target==0)
            return 1;

        if(ind == 0){
            if(arr[ind] == target){
                return 1;
            }else{
                return 0;
            }
        }


        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = helper(ind-1,arr,target,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = helper(ind-1,arr,target-arr[ind],dp);
        dp[ind][target]=notTaken == 1||taken == 1 ?1:0;
        return Math.max(notTaken, taken);
    }

    static int equalPartition(int N, int arr[])
    {
        int totalSum = 0;
        for(int i : arr){
            totalSum += i;
        }
        int target = totalSum/2;
        int dp[][] = new int[N][target+1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return helper(N - 1, arr, target, dp);
    }
}
