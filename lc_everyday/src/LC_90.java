import java.util.ArrayList;
import java.util.List;

public class LC_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums); // 因为有重复了 所以排序先 这样遍历的时候就可以一旦出现重复就不计入的情况
        dfs(nums,0,new ArrayList<Integer>(),res);
        return res;
    }
    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(subset));
        for (int i = index; i < nums.length; i++) { // 没有逆序 所以i从index开始
            if (i > index && nums[i] == nums[i-1]) { // 发生重复的值 直接跳过 如果不跳过的话 还要用set在res添加的时候作为条件
                continue;
            }
            subset.add(nums[i]);
            dfs(nums,i+1,subset,res);
            subset.remove(subset.size() - 1);
        }
    }
}
