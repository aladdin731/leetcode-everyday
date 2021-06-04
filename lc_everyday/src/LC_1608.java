public class LC_1608 {
    public int specialArray(int[] nums) {
        int left = 1, right = 0;
        for (int i : nums) {
            if (i > right) {
                right = i;
            }
        }
        // 硬要用二分的话
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (counter(nums, mid) == mid) {
                return mid;
            } else if (counter(nums, mid) < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int counter(int[] nums, int k) {
        int count = 0;
        for (int i : nums) {
            if (i >= k) {
                count++;
            }
        }
        return count;
    }
}
