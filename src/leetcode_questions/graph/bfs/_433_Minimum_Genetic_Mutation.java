package leetcode_questions.graph.bfs;

import java.util.*;

public class _433_Minimum_Genetic_Mutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;

        HashSet<String> bankSet = new HashSet<>();
        for (int i = 0; i < bank.length; i++) bankSet.add(bank[i]);
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endGene)) return steps;

                char[] chs = cur.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (char letter : charSet) {
                        chs[j] = letter;
                        String next = new String(chs);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    chs[j] = old;
                }
            }
            steps++;
        }
        return -1;
    }
}
