import java.util.Arrays;

public class LC_1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int mod = (int)(1e9 + 7);
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = (pows[i - 1] * 2) % mod;
        }
        int i = 0, j = n - 1;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                res = (res + pows[j - i]) % mod;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

}
