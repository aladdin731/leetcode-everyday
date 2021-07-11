public class LC_560 {
    public int subarraySum(int[] nums, int k) {
        // time: O(n)
        // space: O(n) no duplicate values in nums
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // key : prefixSum
        // value: frequency of the key
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
