package leetcode_questions.dynamic_programming.bitmask;

public class _1349_Maximum_Students_Taking_Exam {
    public int maxStudents(char[][] seats) {
        int M = seats.length;
        int n = seats[0].length;
        int N = (1 << n);
        int[] numToSeats = new int[N];
        for (int i = 0; i < N; i++) {
            int numOfSeats = 0;
            boolean prevSeatOccupied = false;
            for (int j = 0; j < n; j++) {
                if (prevSeatOccupied && (i & (1 << j)) != 0) {
                    numOfSeats = -1;
                    break;
                }
                if ((i & (1 << j)) != 0) {
                    numOfSeats++;
                    prevSeatOccupied = true;
                } else {
                    prevSeatOccupied = false;
                }
            }
            numToSeats[i] = numOfSeats;
        }


        int[][] dp = new int[M][N];
        for (int i = 0; i < N; i++) {
            // check if this status is valid in row 1
            int row = 0;
            for (int j = 0; j < n; j++) {
                if (seats[0][n - j - 1] == '#') {
                    row += (1 << j);
                }
            }
            if (!isValid(row, i)) {
                dp[0][i] = -1;
            } else {
                dp[0][i] = numToSeats[i];
            }
        }

        for (int i = 1; i < M; i++) {
            int row = 0;
            for (int j = 0; j < n; j++) {
                if (seats[i][n - j - 1] == '#') {
                    row += (1 << j);
                }
            }
            for (int j = 0; j < N; j++) {
                if (numToSeats[j] == -1 || !isValid(row, j)) {
                    dp[i][j] = -1;
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    if ((((j & (k << 1)) == 0)) && (((j & (k >> 1)) == 0))) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + numToSeats[j]);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[M - 1][i]);
        }
        return res;
    }

    private boolean isValid(int row, int status) {
        return (row & status) == 0;
    }

    /*
    1100010
    0000100
    dp[i][status] max number of student that can take the exam from 0 to i-th row with pattern status
    at row i

     */
}
