package leetcode_questions.others.prefix_sum;

public class _2055_Plates_Between_Candles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int N = s.length();
        int[] preSum = new int[N];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') preSum[i]++;
            if (i > 0) preSum[i] += preSum[i - 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int beginningCandles = start > 0 ? preSum[start - 1] : 0;
            int endingCandles = preSum[end];
            if (endingCandles - beginningCandles < 2) continue;

            int lo = start;
            int hi = end;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (preSum[mid] == beginningCandles) {
                    lo = mid + 1;
                } else if (beginningCandles + 1 == preSum[mid]) {
                    hi = mid;
                } else {
                    hi = mid - 1;
                }
            }
            start = lo;

            lo = start;
            hi = end;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (preSum[mid] == endingCandles) {
                    hi = mid;
                } else if (preSum[mid] < endingCandles) {
                    lo = mid + 1;
                }
            }
            end = lo;
            res[i] = (end - start + 1) - (endingCandles - beginningCandles);
        }
        return res;
    }


}
