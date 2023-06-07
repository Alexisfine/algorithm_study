package leetcode_questions.graph.topological_sort;

import java.util.*;

public class _1203_Sort_Items_By_Groups_Respecting_Dependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int totalGroups = m;
        Map<Integer, List<Integer>> indexGroupMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = totalGroups;
                indexGroupMap.put(totalGroups, new ArrayList<>());
                indexGroupMap.get(totalGroups).add(i);
                totalGroups++;
            } else {
                indexGroupMap.putIfAbsent(group[i], new ArrayList<>());
                indexGroupMap.get(group[i]).add(i);
            }
        }

        int[] externalInMap = new int[totalGroups];
        int[] internalInMap = new int[n];
        Map<Integer, List<Integer>> externalGraph = new HashMap<>();
        Map<Integer, List<Integer>> internalGraph = new HashMap<>();
        for (int i = 0; i < beforeItems.size(); i++) {
            if (beforeItems.get(i).size() > 0) {
                int groupNumber = group[i];
                for (int j = 0; j < beforeItems.get(i).size(); j++) {
                    int prevItem = beforeItems.get(i).get(j);
                    int prevGroupNumber = group[prevItem];
                    if (groupNumber == prevGroupNumber) {
                        internalGraph.putIfAbsent(prevItem, new ArrayList<>());
                        internalGraph.get(prevItem).add(i);
                        internalInMap[i]++;
                    } else {
                        externalGraph.putIfAbsent(prevGroupNumber, new ArrayList<>());
                        externalGraph.get(prevGroupNumber).add(groupNumber);
                        externalInMap[groupNumber]++;
                    }
                }
            }
        }

        Queue<Integer> externalQueue = new LinkedList<>();
        for (int i = 0; i < totalGroups; i++) {
            if (externalInMap[i] == 0) {
                externalQueue.offer(i);
            }
        }

        int[] res = new int[n];
        int resIndex = 0;

        while (!externalQueue.isEmpty()) {
            int curGroup = externalQueue.poll();
            Queue<Integer> internalQueue = new LinkedList<>();
            if (indexGroupMap.containsKey(curGroup)) {
                for (int item : indexGroupMap.get(curGroup)) {
                    if (internalInMap[item] == 0) {
                        internalQueue.offer(item);
                    }
                }
            }
            while (!internalQueue.isEmpty()) {
                int curItem = internalQueue.poll();
                res[resIndex] = curItem;
                resIndex++;
                if (internalGraph.containsKey(curItem)) {
                    for (int nextItemInGroup : internalGraph.get(curItem)) {
                        internalInMap[nextItemInGroup]--;
                        if (internalInMap[nextItemInGroup] == 0) {
                            internalQueue.offer(nextItemInGroup);
                        }
                    }
                }
            }

            if (externalGraph.containsKey(curGroup)) {
                for (int nextGroup : externalGraph.get(curGroup)) {
                    externalInMap[nextGroup]--;
                    if (externalInMap[nextGroup] == 0) {
                        externalQueue.offer(nextGroup);
                    }
                }
            }
        }
        return resIndex == n ? res : new int[]{};
    }
}
