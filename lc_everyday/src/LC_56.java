import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        List<int[]> res = new ArrayList<>();
        // 第一步 排序
        Arrays.sort(intervals,(int[]a, int[]b) -> a[0] - b[0]);
        // 初始化
        res.add(intervals[0]);

        for (int i = 1;i < intervals.length; i++) {
            int[] lastOne = res.get(res.size()-1);
            if (lastOne[1] >= intervals[i][0]) {
                lastOne[1] = Math.max(lastOne[1],intervals[i][1]);
            }else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[][]{});
    }
    //time : O(nlogn) space:O(n) -- list
}
