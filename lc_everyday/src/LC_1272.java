import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for(int[] interval : intervals) {
            if(interval[0] < toBeRemoved[0]) {
                res.add(Arrays.asList(interval[0], Math.min(toBeRemoved[0], interval[1])));
            }
            if(interval[1] > toBeRemoved[1]){
                res.add(Arrays.asList(Math.max(interval[0], toBeRemoved[1]), interval[1]));
            }
        }
        return res;
    }
}
