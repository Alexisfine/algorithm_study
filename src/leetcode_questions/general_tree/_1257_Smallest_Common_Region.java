package leetcode_questions.general_tree;

import java.util.*;

public class _1257_Smallest_Common_Region {
    private class Info {
        boolean hasRegion1;
        boolean hasRegion2;
        String lca;
        public Info(boolean hasRegion1, boolean hasRegion2, String lca) {
            this.hasRegion1 = hasRegion1;
            this.hasRegion2 = hasRegion2;
            this.lca = lca;
        }
    }
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Set<String> rootSet = new HashSet<>();
        for (int i = 0; i < regions.size(); i++) {
            rootSet.add(regions.get(i).get(0));
        }

        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < regions.size(); i++) {
            String parent = regions.get(i).get(0);
            for (int j = 1; j < regions.get(i).size(); j++) {
                String child = regions.get(i).get(j);
                graph.putIfAbsent(parent, new ArrayList<>());
                graph.get(parent).add(child);
                if (rootSet.contains(child)) {
                    rootSet.remove(child);
                }
            }
        }
        String root = (String) rootSet.toArray()[0];
        return lca(graph, root, region1, region2).lca;
    }

    private Info lca(Map<String, List<String>> graph, String curNode, String region1, String region2) {
        boolean hasRegion1 = false;
        boolean hasRegion2 = false;
        String lca = null;
        if (graph.containsKey(curNode)) {
            for (String next : graph.get(curNode)) {
                Info nextInfo = lca(graph, next, region1, region2);
                if (nextInfo.hasRegion1 && nextInfo.hasRegion2) {
                    return nextInfo;
                }
                hasRegion1 = hasRegion1 || nextInfo.hasRegion1;
                hasRegion2 = hasRegion2 || nextInfo.hasRegion2;
            }
        }
        if (hasRegion1 && hasRegion2) {
            return new Info(true, true, curNode);
        }
        if (!hasRegion1) hasRegion1 = curNode.equals(region1);
        if (!hasRegion2) hasRegion2 = curNode.equals(region2);
        if (hasRegion1 && hasRegion2) {
            return new Info(true, true, curNode);
        }
        return new Info(hasRegion1, hasRegion2, null);
    }
}
