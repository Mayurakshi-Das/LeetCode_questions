class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int count =1;
        for(int i=1; i<=n; i++){
            if(count*2 == i){
                count = i;
            }
            dp[i] = dp[i-count] +1;
        }
        return dp;
    }
}