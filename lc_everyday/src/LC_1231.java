public class LC_1231 {// leetcod 410/1011 similar;
    // 答案二分
    // 答案值及以下 都可以满足条件
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < sweetness.length; i++) {
            left = Math.min(left, sweetness[i]);
            right += sweetness[i];
        }
        while (left + 1< right) {
            int mid = left + (right - left) / 2;
            if (isValid(sweetness, K + 1, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // 求的是尽可能大的值 所以先右后左
        return isValid(sweetness, K + 1, right) ? right : left;
    }
    private boolean isValid(int[] nums, int K, int target) {
        // target越大 count越小
        // valid说明 当前mid可以分成至少K份 那么可以缩小count 即target变大 往右找
        int count = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total >= target) {
                total = 0;
                count++;
            }
        }
        return count >= K;
    }
}
