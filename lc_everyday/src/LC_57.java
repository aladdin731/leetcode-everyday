import java.util.ArrayList;
import java.util.List;

public class LC_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<int[]>();
        int insertPos = 0;

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                results.add(interval);
                insertPos++;
            } else if (interval[0] > newInterval[1]) {
                results.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        results.add(insertPos, newInterval);

        // List<int[]> -> int[][] 写法
        return results.toArray(new int[results.size()][2]) ;
    }
}
