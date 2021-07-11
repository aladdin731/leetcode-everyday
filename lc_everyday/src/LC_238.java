public class LC_238 {
    // time O(n) space O(1)
    public int[] productExceptSelf(int[] nums) {
        // product[i] = nums[0]..nums[i-1] * nums[i+1]...nums[length-1];
        int[] res = new int[nums.length];
        int preProduct = 1;
        int postProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] *= preProduct;
            preProduct *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postProduct;
            postProduct *= nums[i];
        }
        return res;
    }
}
