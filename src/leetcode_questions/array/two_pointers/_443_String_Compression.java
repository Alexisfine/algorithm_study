package leetcode_questions.array.two_pointers;

public class _443_String_Compression {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;

        int runner = 1;
        int chaser = 0;
        int current = 1;
        while (runner < chars.length) {
            if (chars[runner] == chars[runner - 1]) {
                current++;
                runner++;
            } else {
                chars[chaser++] = chars[runner - 1];
                if (current > 1) {
                    char[] chs = String.valueOf(current).toCharArray();
                    for (int i = 0; i < chs.length; i++) {
                        chars[chaser++] = chs[i];
                    }
                }
                current = 1;
                runner++;
            }
        }
        chars[chaser++] = chars[runner - 1];
        if (current > 1) {
            char[] chs = String.valueOf(current).toCharArray();
            for (int i = 0; i < chs.length; i++) {
                chars[chaser++] = chs[i];
            }
        }
        return chaser;
    }


}
