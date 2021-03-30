public class LC_1283 {
    // leetcode 875. Koko Eating Bananas same
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 1000000;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(nums, threshold, mid)) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
    private boolean helper(int[] nums, int threshold, int k) {
        int total = 0;
        for(int num : nums) {
            total += (num + k - 1) / k;
        }
        return total <= threshold;
    }
}
