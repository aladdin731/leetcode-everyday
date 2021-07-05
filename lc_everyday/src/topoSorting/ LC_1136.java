package topoSorting;
import java.util.*;
public class  LC_1136 {
    public int minimumSemesters(int n, int[][] relations) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		int[] indegree = new int[n];
        for(int[] r:relations) {
            map.putIfAbsent(r[0], new HashSet<>());
            map.putIfAbsent(r[1], new HashSet<>());
            map.get(r[0]).add(r[1]);
            indegree[r[1] - 1]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i + 1);
            }
        }

        int count = 0;
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                count++;
                if(map.containsKey(cur)) {
                    for(int nei:map.get(cur)) {
                        indegree[nei - 1]--;
                        if(indegree[nei - 1] == 0) {
                            q.offer(nei);
                        }
                    }
                }
            }
        }
        return count == n ? level : - 1;
    }
}
