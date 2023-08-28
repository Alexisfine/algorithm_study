package leetcode_questions.general_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2246_Longest_Path_With_Different_Adjacent_Characters {
    private record Info(char lastChar, int curLen, int longestLen) {}
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            int curParent = parent[i];
            int curChild = i;
            if (!tree.containsKey(curParent)) {
                tree.put(curParent, new ArrayList<>());
            }

            tree.get(curParent).add(curChild);
        }

        Info info = dfs(0, tree, s);
        return Math.max(info.curLen, info.longestLen);
    }

    private Info dfs(int node, Map<Integer, List<Integer>> tree, String s) {
        if (!tree.containsKey(node)) {
            return new Info(s.charAt(node), 1, 1);
        }

        int curLen = 1;
        int longestLen = 1;
        int firstLongestLen = 0;
        int secondLongestLen = 0;
        char curChar = s.charAt(node);

        for (int curNode : tree.get(node)) {
            Info info = dfs(curNode, tree, s);
            if (info.lastChar != curChar) {
                curLen = Math.max(curLen, info.curLen + 1);
                if (firstLongestLen < info.curLen) {
                    secondLongestLen = firstLongestLen;
                    firstLongestLen = info.curLen;
                } else if (secondLongestLen < info.curLen) {
                    secondLongestLen = info.curLen;
                }
            }
            longestLen = Math.max(longestLen, info.longestLen);

        }
        longestLen = Math.max(longestLen, firstLongestLen + secondLongestLen + 1);
        return new Info(curChar, curLen, longestLen);
    }
}
