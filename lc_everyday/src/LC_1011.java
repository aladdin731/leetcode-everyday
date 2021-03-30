public class LC_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int start = 0;
        int end = 0;
        for (int w : weights) {
            start = Math.max(start, w);
            end += w;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isValid(weights, D, mid)) {
                end = mid;
            }else {
                start = mid;
            }
        }
        return isValid(weights, D, start) ? start : end;
    }
    private boolean isValid(int[] weights, int D, int K) {
        int day = 1;
        int sum = 0;
        for (int w : weights) {
            if (sum + w > K) {
                sum = 0;
                day++;
            }
            sum += w;
        }
        return day <= D;
    }
}
