import java.util.Arrays;

public class LC_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0 || n == 1) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = intervals[0][1];
        for(int i = 1; i < n; i++) {
            if(intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }
}
