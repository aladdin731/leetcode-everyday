package topoSorting;

import java.util.*;
public class  LC_444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(List<Integer> list : seqs) {
            for(int num : list) {
                set.add(num);
            }
        }
        if(set.size() != org.length) return false;

        for(int num : set) {
            indegree.put(num, 0);
            map.put(num, new HashSet<>());
        }

        for(List<Integer> list : seqs) {
            for(int i = 0; i < list.size() - 1; i++) {
                if (map.get(list.get(i)).add(list.get(i + 1))) {
                    indegree.put(list.get(i + 1), indegree.get(list.get(i + 1)) + 1);
                };
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int key:indegree.keySet()) {
            if(indegree.get(key) == 0) {
                q.offer(key);
            }
        }
        int index = 0;
        while(q.size() == 1) {
            int cur = q.poll();
            if(org[index++] != cur) {
                return false;
            }
            if(map.containsKey(cur)) {
                for(int nei:map.get(cur)) {
                    indegree.put(nei, indegree.get(nei) - 1);
                    if(indegree.get(nei) == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        return index == org.length;
    }
}
