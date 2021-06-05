public class LC_1300 {
    public int findBestValue(int[] arr, int target) {
        int left = 0, right = 0, min = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i > right) {
                right = i;
            }
            if (i < left) {
                left = i;
            }
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(sum(arr, mid) - target) == min && mid < res) {
                res = mid;
            }
            if (Math.abs(sum(arr, mid) - target) < min) {
                min = Math.abs(sum(arr, mid) - target);
                res = mid;
            }
            if (sum(arr, mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public int sum(int[] arr, int k) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.min(i, k);
        }
        return sum;
    }
}
