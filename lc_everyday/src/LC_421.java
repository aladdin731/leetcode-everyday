
import java.util.HashSet;
import java.util.Set;

public class LC_421 {
    // | or 有1即1   & and 均1才1  ^ XOR 不同才1
    // a ^ b = c --> a ^ c = b
    // 相当于two sum中 target现在是1 要求是否存在 0 和 1
    // 所以遍历的时候 应该num1 ^ num2 = 1 查看num1^1即num2 如果已经存在在set中 说明找到了 如果没有 就存入num1
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        // 要找最大的 所以从31到0
        for(int i = 31; i >= 0; i--) {
            mask |= (1 << i);

            Set<Integer> set = new HashSet<>();
            int temp = max | (1 << i);
            for(int num : nums) {
                if(set.contains(num & mask ^ temp)) {
                    max = temp;
                    break;
                }else {
                    set.add(num & mask);
                }
            }
        }
        return max;
    }
}
