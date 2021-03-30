public class LC_410 {
    public int splitArray(int[] nums, int m) {
        // leetcode 1011 same
        // 二分答案
        int start = 0;
        int end = 0;
        for(int num : nums) {
            start = Math.max(num, start);
            end += num;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (helper(nums, m, mid)) {
                end = mid;
            }else {
                start = mid;
            }
        }
        return helper(nums, m, start) ? start : end;
    }
    private boolean helper(int[] nums, int m, int k) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > k) {
                sum = 0;
                count++;
            }
            sum += num;
        }
        return count <= m;
    }
}
