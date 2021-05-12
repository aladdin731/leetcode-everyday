

public class LC_275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0)
            return 0;

        int left = 0, right = n - 1, res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (citations[mid] >= n - mid) {
                res = Math.max(res, n - mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
