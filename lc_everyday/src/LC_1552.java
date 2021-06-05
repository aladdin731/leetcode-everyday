public class LC_1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        // left right 指得是force
        int left = 1, right = position[position.length - 1] - position[0], res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(position, m, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public boolean isValid(int[] position, int m, int mid) {
        int count = 1; // 球的数量 至少有1个 即在head的ball
        int head = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - head >= mid) {
                count++;
                head = position[i];
            }
        }
        return count >= m;
    }
}
