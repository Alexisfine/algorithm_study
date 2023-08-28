package leetcode_questions.string.rolling_hash;


import java.util.HashSet;
import java.util.Set;

public class _1554_Strings_Differ_By_One_Character {
    public boolean differByOne(String[] dict) {
        long mod = (long) 1e9 + 7;
        long base = 26;
        int N = dict.length;
        int M = dict[0].length();
        long[] hash = new long[N];
        for (int i = 0; i < N; i++) {
            long curHash = 0;
            for (int j = 0; j < M; j++) {
                curHash = curHash * base + (dict[i].charAt(j) - 'a');
                curHash %= mod;
            }
            hash[i] = curHash;
        }
        long[] power = new long[M];
        power[0] = 1;
        for (int i = 1; i < M; i++) {
            power[i] = (power[i - 1] * base) % mod;
        }

        for (int pos = 0; pos < M; pos++) {
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                long newHash = (hash[i] - (((dict[i].charAt(pos) - 'a') * power[M - 1 - pos]) % mod)) % mod + mod;
                if (set.contains(newHash)) return true;
                set.add(newHash);
            }
        }
        return false;
    }
}
