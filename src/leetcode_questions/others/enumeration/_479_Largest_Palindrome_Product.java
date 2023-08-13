package leetcode_questions.others.enumeration;

public class _479_Largest_Palindrome_Product {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        long mod = 1337;
        long low = (long) Math.pow(10, n - 1);
        long high = (long) Math.pow(10, n) - 1;

        for (long i = high; i >= low; i--) {
            long p = createPalindrome(i);
            for (long divisor = high; divisor >= Math.sqrt(p); divisor--) {
                if (p % divisor == 0 && p / divisor >= low) {
                    return (int) (p % mod);
                }
            }
        }
        return -1;
    }

    private long createPalindrome(long i) {
        String s = String.valueOf(i);
        s = new StringBuilder(s).reverse().toString();
        return Long.parseLong(String.valueOf(i) + s);
    }

    /*
    constraints 1 <= n <= 8
     */
}
