package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _17_Letter_Combinations_Of_Phone_Number {
    String digits;
    List<String> list;
    StringBuilder stringBuilder;

    // Time: O(N * 4^N)
    // Space: O(N)
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        this.list = new ArrayList<>();
        this.stringBuilder = new StringBuilder();
        if (digits == null || digits.length() == 0) return list;

        process(0);
        return list;
    }

    private void process(int index) {
        if (index == digits.length()) {
            list.add(new String(stringBuilder));
            return;
        }

        switch (digits.charAt(index)) {
            case '2':
                stringBuilder.append('a');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('b');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('c');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
            case '3':
                stringBuilder.append('d');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('e');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('f');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
            case '4':
                stringBuilder.append('g');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('h');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('i');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
            case '5':
                stringBuilder.append('j');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('k');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('l');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
            case '6':
                stringBuilder.append('m');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('n');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('o');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
            case '7':
                stringBuilder.append('p');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('q');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('r');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('s');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
            case '8':
                stringBuilder.append('t');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('u');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('v');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
            case '9':
                stringBuilder.append('w');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('x');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('y');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                stringBuilder.append('z');
                process(index + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                break;
        }
    }
}
