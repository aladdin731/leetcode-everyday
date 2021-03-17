import java.util.Arrays;

public class LC_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int count = 0;

        int l = 0, r = 1;
        while(r < n) {
            if(intervals[l][1] >= intervals[r][1]) {
                count++;
            }else {
                l = r;
            }
            r++;
        }
        return n - count;
    }
}
