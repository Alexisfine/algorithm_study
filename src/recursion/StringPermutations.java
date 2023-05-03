package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringPermutations {
    public static ArrayList<String> permutations(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    private static void process(char[] chs, int i, ArrayList<String> res) {
        if (chs.length == i) {
            res.add(String.valueOf(chs));
        }
        boolean[] visited = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            if (visited[j]) continue;
            visited[j] = true;
            swap(chs, i, j);
            process(chs, i + 1, res);
            swap(chs, j, i);
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;

    }
}
