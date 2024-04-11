package com.at.algorithmzuo;

public class 动态规划_003_01背包_1049_最后一块石头的重量II {

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int stone : stones) {
            sum+=stone;
        }

        int ne = ne(stones, sum >> 1);

        return sum - ne - ne;
    }

    public int ne(int[] stones,int sum){

        int[] dp = new int[sum+1];

        for (int stone : stones) {
            for (int j = sum; j >= stone ; j--) {
                dp[j] = Math.max(dp[j],dp[j-stone] + stone);
            }
        }

        return dp[sum];
    }

}
