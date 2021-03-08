import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_253 {
    class DataType{
        public int time;
        public int cost;
        public DataType(){}
        public DataType(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        // 先排序 按照起始时间从小到大
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        // PQ来储存最早的结束时间
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            // ｜__|  |__|
            if(intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            // 有重合 那就加一个meeting room
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}
}
