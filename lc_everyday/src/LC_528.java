public class LC_528 {
    // 把一段mapping到同一个数
    int[] sum;
    Random rand;
    int max;

    public Solution(int[] w) {
        rand = new Random();
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
        max = sum[w.length - 1];
    }

    public int pickIndex() {
        int target = rand.nextInt(max) + 1; // plus one because index does not have 0 weight
        int start = 0;
        int end = sum.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (sum[mid] == target) {
                return mid;
            } else if (sum[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
