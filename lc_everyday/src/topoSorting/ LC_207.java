package topoSorting;
import java.util.*;
public class  LC_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0)
            return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[1], new HashSet<>());
            map.putIfAbsent(pre[0], new HashSet<>());
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            if (map.containsKey(cur)) {
                for (int nei : map.get(cur)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
