package topoSorting;

import java.util.*;
public class  LC_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];

        for (int[] e : edges) {
            map.putIfAbsent(e[0], new HashSet<>());
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }
        List<Integer> temp = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                temp.add(cur);
                if (map.containsKey(cur)) {
                    for (int nei : map.get(cur)) {
                        indegree[nei]--;
                        if (indegree[nei] == 1) {
                            q.offer(nei);
                        }
                    }
                }
            }
        }
        res = temp;
        return res;
    }
}
