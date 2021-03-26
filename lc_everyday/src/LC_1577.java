import java.util.HashMap;

public class LC_1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        int res = 0;
        res += helper(nums1, nums2);
        res += helper(nums2, nums1);
        return res;
    }

    private int helper(int[] nums1, int[] nums2) {
        int res = 0;
        for(long i : nums1) {
            HashMap<Long, Integer> hash = new HashMap<>();
            for(long j : nums2) {
                if(i*i % j == 0) {
                    res += hash.getOrDefault(i*i/j, 0);
                }
                hash.put(j, hash.getOrDefault(j, 0) + 1);
            }
        }
        return res;
    }
}
