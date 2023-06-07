package leetcode_questions.graph.topological_sort;

import java.util.*;

import static java.util.Arrays.*;

public class _269_Alien_Dictionary {
    public String alienOrder(String[] words) {
        int N = words.length;

        if (N == 1) {
            char[] chs = words[0].toCharArray();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < chs.length; i++) set.add(chs[i]);
            StringBuilder sb = new StringBuilder();
            set.stream().forEach(s -> sb.append(s));
            return new String(sb);
        }

        HashMap<Character, Set<Character>> graph = new HashMap<>();
        int[] inMap = new int[26];
        fill(inMap, -1);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String small = words[i];
                String large = words[j];
                int lenSmall = small.length();
                int lenLarge = large.length();
                int index = 0;
                while (index < lenSmall && index < lenLarge && small.charAt(index) == large.charAt(index)) {
                    int val = small.charAt(index) - 'a';
                    if (inMap[val] == -1) {
                        inMap[val] = 0;
                    }
                    index++;
                }

                if (index < Math.min(lenSmall, lenLarge)) {
                    graph.putIfAbsent(small.charAt(index), new HashSet<>());
                    boolean notAdded = graph.get(small.charAt(index)).add(large.charAt(index));
                    boolean checkInvalid = graph.containsKey(large.charAt(index)) &&
                            graph.get(large.charAt(index)).contains(small.charAt(index));
                    if (checkInvalid) return "";
                    if (notAdded) {
                        int s = small.charAt(index) - 'a';
                        if (inMap[s] == -1) inMap[s] = 0;

                        int l = large.charAt(index) - 'a';
                        if (inMap[l] == -1) inMap[l] = 1;
                        else inMap[l]++;
                    }
                }

                if (index == lenLarge && index < lenSmall) return "";
                // add remaining of small to inMap
                for (int indexSmall = index; indexSmall < lenSmall; indexSmall++) {
                    int val = small.charAt(indexSmall) - 'a';
                    if (inMap[val] == -1) {
                        inMap[val] = 0;
                    }
                }

                // add remaining of large to inMap
                for (int indexLarge = index; indexLarge < lenLarge; indexLarge++) {
                    int val = large.charAt(indexLarge) - 'a';
                    if (inMap[val] == -1) {
                        inMap[val] = 0;
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inMap.length; i++) {
            if (inMap[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            char curChar = (char) ('a' + cur);
            sb.append(curChar);
            if (graph.containsKey(curChar)) {
                for (char next : graph.get(curChar)) {
                    int nextInt = next - 'a';
                    inMap[nextInt]--;
                    if (inMap[nextInt] == 0) {
                        queue.offer(nextInt);
                    }
                }
            }
        }

        return new String(sb);
    }
}
