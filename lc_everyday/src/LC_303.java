public class LC_303 {
    // prefix sum
    int[] dp;

    // 永远记住 dp中的i 对应nums中的n - 1
    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
