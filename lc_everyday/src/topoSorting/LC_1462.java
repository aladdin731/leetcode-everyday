package topoSorting;

import java.util.*;
public class LC_1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> childToAncestors = new HashMap<>();

        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[1], new HashSet<>());
            map.putIfAbsent(pre[0], new HashSet<>());
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 加入自己 方便后续传递给下一代 注意位置 统计所有点 所以在这里
            childToAncestors.put(i, new HashSet<>());
            childToAncestors.get(i).add(i);
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map.containsKey(cur)) {
                for (int nei : map.get(cur)) {
                    for (int p : childToAncestors.get(cur)) {
                        childToAncestors.get(nei).add(p);
                    }
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }

        for (int[] query : queries) {
            res.add(childToAncestors.get(query[0]).contains(query[1]));
        }
        return res;
    }
}
