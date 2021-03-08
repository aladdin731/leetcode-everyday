import java.util.Arrays;

public class LC_252 {
    public boolean canAttendMeetings(int[][] intervals) {
        // attend all meetings = no overlap
        // sort 按照开始时间 从小到大排序
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        // iterate the intervals to check whether exist some interval.start < last interval.end
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
