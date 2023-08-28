package leetcode_questions.others.count_subarray_by_element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _828_Count_Unique_Characters_Of_All_Substrings_Of_A_Given_String {
    public int uniqueLetterString(String s) {
        int N = s.length();
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);

        List<List<Integer>> nextPos = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            nextPos.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int index = s.charAt(i) - 'A';
            nextPos.get(index).add(i);
        }

        for (int i = 0; i < 26; i++) {
            if (!nextPos.get(i).isEmpty()) {
                nextPos.get(i).remove(0);
            }
        }


        int res = 0;
        for (int i = 0; i < N; i++) {
            int index = s.charAt(i) - 'A';
            int j = lastPos[index];
            if (nextPos.get(index).isEmpty()) {
                res += (i - j) * (N - i);
            } else {
                int nextIndex = nextPos.get(index).get(0);
                res += (i - j) * (nextIndex - i);
                nextPos.get(index).remove(0);
            }
            lastPos[index] = i;
        }
        return res;
    }

    /*
    X X X a X X a X X a X X
     */
}
