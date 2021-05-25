class Solution { // prefixSum and HashMap O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> preSumToCount = new HashMap<>();
        preSumToCount.put(0, 1);
        int lastPrefixSum = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int curPrefixSum = lastPrefixSum + nums[i];
            int target = curPrefixSum - goal;
            if (preSumToCount.containsKey(target)) {
                res += preSumToCount.get(target);
            }
            preSumToCount.put(curPrefixSum, preSumToCount.getOrDefault(curPrefixSum, 0) + 1);
            lastPrefixSum = curPrefixSum;
        }

        return res;
    }
}