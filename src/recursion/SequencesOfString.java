package recursion;

import java.util.List;

public class SequencesOfString {
    public static void printAllSequences(String str) {
        char[] chs = str.toCharArray();
    }

    public static void process(char[] chs, int i, List<Character> res) {
        if (i == chs.length) {
            printList(res);
            return;
        }

        List<Character> resKeep = new java.util.ArrayList<>(List.copyOf(res));
        resKeep.add(chs[i]);
        process(chs, i + 1, resKeep);
        List<Character> resNoInclude = List.copyOf(res);
        process(chs, i + 1, resNoInclude);


    }

    private static void printList(List<Character> res) {
        // ...
    }
}
