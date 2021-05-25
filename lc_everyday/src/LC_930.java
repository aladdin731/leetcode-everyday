class Solution { // prefixSum and HashMap O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSumToCount = new HashMap<>();
        prefixSumToCount.put(0, 1);
        int lastPrefixSum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int curPrefixSum = lastPrefixSum + nums[i];
            int target = curPrefixSum - goal;
            if (prefixSumToCount.containsKey(target)) {
                res += prefixSumToCount.get(target);
            }
            prefixSumToCount.put(curPrefixSum, prefixSumToCount.getOrDefault(curPrefixSum, 0) + 1);
            lastPrefixSum = curPrefixSum;
        }

        return res;
    }
}