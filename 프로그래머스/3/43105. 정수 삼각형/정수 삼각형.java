class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        
        for(int h = 1; h < N; h++){
            dp[h][0] = dp[h - 1][0] + triangle[h][0];
            for(int w = 1; w < h; w++)
                dp[h][w] = Math.max(dp[h - 1][w], dp[h - 1][w - 1]) + triangle[h][w];
            
            dp[h][h] = dp[h - 1][h - 1] + triangle[h][h];
        }
        
        int ans = 0;
        for(int i = 0; i < N; i++)
            ans = Math.max(ans, dp[N - 1][i]);
        
        return ans;
    }
}