package leetcode_questions.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class _179_Largest_Number {
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, new StrComparator());
        if (strArr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
    private class StrComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1);
        }
    }
}
