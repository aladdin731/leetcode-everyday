public class LC_164 { // radix sort O(n)
    public int maximumGap(int[] nums) {
        if (nums.length <= 1)
            return 0;

        // find max element
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        int divisor = 1;
        int temp[][] = new int[10][nums.length];
        int count[] = new int[10];

        while (divisor <= max) {
            // 分类入桶 从最后一位往前排列
            for (int i = 0; i < nums.length; i++) {
                int index = (nums[i] / divisor) % 10;
                temp[index][count[index]] = nums[i];
                count[index]++;
            }
            // 二维变一维update nums
            int current = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    nums[current++] = temp[i][j];
                }
                count[i] = 0; // count还原
            }

            divisor *= 10;
        }
        // sorted => find max difference
        int res = 0;
        for (int i = 1; i < nums.length; i++)
            res = Math.max(nums[i] - nums[i - 1], res);

        return res;
    }
}
