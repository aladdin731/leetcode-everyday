public class LC_53 {
// time o(n) space o(1)
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }
}