package leetcode_questions.companies.citadel;

public class CouponCodes {
    public static long getMaxCouponValue(String coupon, int k) {
        long max = 0;
        long cur = 0;
        long mod = (long) 1e9 + 7;

        long[] valMap = new long[27];
        int N = coupon.length();

        for (int i = 0; i < k && i < N; i++) {
            int index = coupon.charAt(i) - 'a' + 1;
            if (valMap[index] == 0) {
                valMap[index] = index;
            } else {
                valMap[index] *= index;
            }
        }

        for (int i = 1; i <= 26; i++) {
            cur += valMap[i];
        }
        if (N <= k) return cur % mod;
        max = cur;
        for (int i = k; i < N; i++) {
            int lastIndex = coupon.charAt(i - k) - 'a' + 1;
            cur -= valMap[lastIndex];
            valMap[lastIndex] /= lastIndex;
            if (lastIndex != 1 && valMap[lastIndex] == 1) {
                valMap[lastIndex] = 0;
            }
            cur += valMap[lastIndex];

            int curIndex = coupon.charAt(i) - 'a' + 1;
            if (valMap[curIndex] == 0) {
                valMap[curIndex] = curIndex;
            } else {
                valMap[curIndex] *= curIndex;
            }

            cur += valMap[curIndex];

            max = Math.max(max, cur);
        }
        return max % mod;
    }

    public static void main(String[] args) {
        System.out.println(getMaxCouponValue("bcaa", 3));
    }
}
