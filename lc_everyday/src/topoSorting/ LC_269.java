package topoSorting;

import java.util.*;
public class  LC_269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        if (graph == null)
            return "";
        return topoSort(graph);
    }

    public Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        // create node
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                graph.putIfAbsent(words[i].charAt(j), new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int l1 = s1.length();
            int l2 = s2.length();
            int index = 0;
            while (index < l1 && index < l2) {
                if (s1.charAt(index) != s2.charAt(index)) {
                    graph.get(s1.charAt(index)).add(s2.charAt(index));
                    // 找到一个就break
                    break;
                }
                index++;
            }
            if (index == Math.min(l1, l2) && l1 > l2) {
                return null;
            }
        }
        return graph;
    }

    public Map<Character, Integer> getIndegree(Map<Character, Set<Character>> map) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character c : map.keySet()) {
            indegree.put(c, 0);
        }
        for (Character c : map.keySet()) {
            for (Character n : map.get(c)) {
                indegree.put(n, indegree.get(n) + 1);
            }
        }
        return indegree;
    }

    public String topoSort(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getIndegree(graph);
        Queue<Character> q = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character cur = q.poll();
            sb.append(cur);
            if (graph.containsKey(cur)) {
                for (Character nei : graph.get(cur)) {
                    indegree.put(nei, indegree.get(nei) - 1);
                    if (indegree.get(nei) == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
