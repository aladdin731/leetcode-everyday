public class LC_325 {
    public int maxSubArrayLen(int[] nums, int k) {
        public int maxSubArrayLen(int[] nums, int k) {
        // sum[j] - sum[i - 1] = sum(i...j);
        // j - (i - 1)
        // sum, index
        // although sum could be duplicate, we only add for the first time for the max len
        Map<Integer, Integer> map = new HashMap<>();
        // some nums[i] equlas to sum, so we need 0, -1
        map.put(0, -1); 
        int sum = 0, res = 0;
        for(int i = 0; i < nums.length;i++){
            sum = sum + nums[i];
            if(map.containsKey(sum - k)){
                res = Math.max(res, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)){ 
                map.put(sum, i);
            }
        }
        return res; 
    }
    }
}
