package leetcode_questions.bit_manipulation;

public class _504_Base_7 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean negative = num < 0;
        if (negative) num = num * -1;

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        if (negative) sb.insert(0, '-');
        return sb.toString();
    }
}
