import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();
        if(slots1.length == 0 || slots2.length == 0) return res;

        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int p1 = 0;
        int p2 = 0;

        while(p1 < slots1.length && p2 < slots2.length){
            int maxStart = Math.max(slots1[p1][0], slots2[p2][0]);
            int minEnd = Math.min(slots1[p1][1], slots2[p2][1]);

            if( (minEnd - maxStart) >= duration){
                res.add(maxStart);
                res.add(maxStart + duration);
                return res;
            }

            if( slots1[p1][1] < slots2[p2][1] ){
                p1++;
            }
            else if( slots1[p1][1] > slots2[p2][1] ){
                p2++;
            } else{
                p1++;
                p2++;
            }
        }
        return res;
    }
}
