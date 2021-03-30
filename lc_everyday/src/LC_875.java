public class LC_875 {
    public int minEatingSpeed(int[] piles, int H) {
        // O(n * log(max(pile)))  O(1)
        // 确定最大最小值 1 <= piles[i] <= 10^9
        // leetcode 1283. Find the Smallest Divisor Given a Threshold  一模一样
        int start = 1;
        int end = 0;
        for(int p : piles) {
            end = Math.max(p, end);
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (canEatAll(piles, mid, H)) {
                end = mid;
            }else {
                start = mid;
            }
        }
        return canEatAll(piles, start, H) ? start : end;
    }
    private boolean canEatAll(int[] piles, int K, int H) {
        int total = 0;
        for(int p : piles) {
            total += (p + K - 1) / K;
        }
        return total <= H;
    }
}
