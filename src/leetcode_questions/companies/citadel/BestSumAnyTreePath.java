package leetcode_questions.companies.citadel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSumAnyTreePath {
    private class Info {
        int maxWithNode;
        int maxInPath;

        public Info(int maxWithNode, int maxInPath) {
            this.maxWithNode = maxWithNode;
            this.maxInPath = maxInPath;
        }
    }

    public int bestSumAnyTreePath(int[] parent, int[] values) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int parentNode = parent[i];
            if (!tree.containsKey(parentNode)) {
                tree.put(parentNode, new ArrayList<>());
            }
            tree.get(parentNode).add(i);
        }

        Info info = process(0, tree, values);
        return Math.max(info.maxInPath, info.maxWithNode);
    }

    private Info process(int num, Map<Integer, List<Integer>> tree, int[] values) {
        if (!tree.containsKey(num)) {
            int val = values[num];
            return new Info(Math.max(0, val), Math.max(0, val));
        }

        List<Integer> childrenList = tree.get(num);
        int curNodeVal = values[num];
        int maxWithNode = 0;
        int maxPathWithoutNode = 0;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int maxInPath = 0;

        for (int i = 0; i < childrenList.size(); i++) {
            Info info = process(childrenList.get(i), tree, values);
            maxWithNode = Math.max(maxWithNode, info.maxWithNode);
            maxPathWithoutNode = Math.max(maxPathWithoutNode, Math.max(info.maxInPath, info.maxWithNode));

            if (info.maxWithNode >= 0) {
                if (firstMax == Integer.MIN_VALUE) {
                    firstMax = info.maxWithNode;
                } else if (secondMax == Integer.MIN_VALUE) {
                    secondMax = info.maxWithNode;
                } else if (info.maxWithNode > firstMax) {
                    secondMax = firstMax;
                    firstMax = info.maxWithNode;
                } else if (info.maxWithNode > secondMax) {
                    secondMax = info.maxWithNode;
                }
            }
        }

        maxWithNode = Math.max(0, maxWithNode) + curNodeVal;
        maxInPath = Math.max(maxPathWithoutNode, firstMax + secondMax + curNodeVal);
        return new Info(maxWithNode, maxInPath);
    }
}
