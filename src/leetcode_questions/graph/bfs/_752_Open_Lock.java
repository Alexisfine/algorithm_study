package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _752_Open_Lock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) deadendSet.add(deadends[i]);
        if (deadendSet.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(target)) return step;
                String[] nextStrArr = getNextStr(str);
                for (String nextStr : nextStrArr) {
                    if (!deadendSet.contains(nextStr) && !visited.contains(nextStr)) {
                        visited.add(nextStr);
                        queue.offer(nextStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String[] getNextStr(String s) {
        String[] strArr = new String[8];
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char prevChar = chs[i];

            int newChar1 = (int) (prevChar - 48);
            newChar1--;
            if (newChar1 < 0) newChar1 = (newChar1 + 10);
            newChar1 %= 10;
            chs[i] = (char) (newChar1 + 48);
            strArr[2 * i] = new String(chs);

            int newChar2 = (int) (prevChar - 48);
            newChar2++;
            System.out.println(newChar2);
            newChar2 %= 10;
            chs[i] = (char) (newChar2 + 48);
            strArr[2 * i + 1] = new String(chs);

            chs[i] = prevChar;
        }
        return strArr;
    }

    public static void main(String[] args) {
        _752_Open_Lock s = new _752_Open_Lock();
        for (String str : s.getNextStr("0000")) {
            System.out.println(str);
        }
    }
}
