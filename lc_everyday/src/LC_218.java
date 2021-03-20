import java.util.*;

public class LC_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();
        // [left, -height] [right, height]
        for(int[] points : buildings) {
            // 左坐标和高度
            buildLines.add(new int[]{points[0], -points[2]});
            // 右坐标和高度
            buildLines.add(new int[]{points[1], points[2]});
        }
        // 先按照端点从小到大 再按照高度从小到大排列
        Collections.sort(buildLines, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }else {
                return a[1] - b[1];
            }
        });
        // 当前画笔停留的height
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // 让heap不空 比如到例子中的(12,0)的时候 此时heap中还有0 产生了高度差
        maxHeap.add(0);
        // 之前的高度
        int preHighest = 0;
        for(int [] points : buildLines) {
            // 左端点
            if(points[1] < 0) {
                maxHeap.add(-points[1]);
            }else { // 右端点
                maxHeap.remove(points[1]);
            }
            int curHeight = maxHeap.peek();
            // 有高度差 就有新的结果
            if(curHeight != preHighest) {
                res.add(Arrays.asList(points[0], curHeight));
                preHighest = curHeight;
            }
        }
        return res;
    }
}
