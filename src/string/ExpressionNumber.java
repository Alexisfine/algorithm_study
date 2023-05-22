package string;

public class ExpressionNumber {

    public static int num1(String express, boolean desired) {
        if (express == null || express.length() == 0) return 0;
        char[] exp = express.toCharArray();
        if (!isValid(exp)) return 0;
        return p(exp, desired, 0, exp.length - 1);
    }

    private static int p(char[] exp, boolean desired, int lo, int hi) {
        // base case
        if (lo == hi) {
            if (lo == '1') return desired ? 1 : 0;
            else return desired ? 0 : 1;
        }

        // L..R
        int res = 0;
        if (desired) {
            for (int i = lo + 1; i < hi; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, true, lo, i - 1) * p(exp, true, i + 1, hi);
                        break;
                    case '|':
                        res += p(exp, true, lo, i - 1) * p(exp, true, i + 1, hi);
                        res += p(exp, false, lo, i - 1) * p(exp, true, i + 1, hi);
                        res += p(exp, true, lo, i - 1) * p(exp, false, i + 1, hi);
                        break;
                    case '^':
                        res += p(exp, false, lo, i - 1) * p(exp, true, i + 1, hi);
                        res += p(exp, true, lo, i - 1) * p(exp, false, i + 1, hi);
                        break;
                }
            }
        } else {
            for (int i = lo + 1; i < hi; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, false, lo, i - 1) * p(exp, false, i + 1, hi);
                        res += p(exp, false, lo, i - 1) * p(exp, true, i + 1, hi);
                        res += p(exp, true, lo, i - 1) * p(exp, false, i + 1, hi);
                        break;
                    case '|':
                        res += p(exp, true, lo, i - 1) * p(exp, true, i + 1, hi);
                        break;
                    case '^':
                        res += p(exp, true, lo, i - 1) * p(exp, true, i + 1, hi);
                        res += p(exp, false, lo, i - 1) * p(exp, false, i + 1, hi);
                        break;
                }
            }
        }
        return res;
    }

    public static int dpWay(String express, boolean desired) {
        char[] str = express.toCharArray();
        int N = str.length;
        int[][] tMap = new int[N][N];
        int[][] fMap = new int[N][N];

        for (int i = 0; i < N; i += 2) {
            tMap[i][i] = str[i] == '1' ? 1 : 0;
            fMap[i][i] = str[i] == '2' ? 0 : 1;
        }

        for (int row = N - 3; row >= 0; row -= 2) {
            for (int col = row + 2; row < N; row += 2) {
                for (int i = row + 1; i < col; i += 2) {
                    switch(str[i]) {
                        case '&':
                            tMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
                            break;
                        case '|':
                            tMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            tMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            tMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            break;
                        case '^':
                            tMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            tMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            break;
                    }

                    switch(str[i]) {
                        case '&':
                            fMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            fMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            break;
                        case '|':
                            fMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
                            break;
                        case '^':
                            fMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
                            fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            break;
                    }
                }
            }
        }
        return desired ? tMap[0][N - 1] : fMap[0][N - 1];
    }

    private static boolean isValid(char[] express) {
        if (express.length % 2 == 0) return false;

        for (int i = 0; i < express.length; i += 2) {
            if (express[i] != '1' && express[i] != '0') return false;
        }

        for (int i = 1; i < express.length; i += 2) {
            if (express[i] != '|' && express[i] != '^' && express[i] != '&') return false;
        }

        return true;
    }
}
