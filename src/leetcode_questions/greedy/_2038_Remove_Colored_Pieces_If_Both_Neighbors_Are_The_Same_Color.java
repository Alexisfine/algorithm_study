package leetcode_questions.greedy;

public class _2038_Remove_Colored_Pieces_If_Both_Neighbors_Are_The_Same_Color {
    public boolean winnerOfGame(String colors) {
        int N = colors.length();
        if (N < 3) return false;
        int alice = 0;
        int bob = 0;
        char first = 0;
        char second = 0;
        char third = 0;
        for (int i = 0; i < N; i++) {
            first = second;
            second = third;
            third = colors.charAt(i);
            if (first == second && second == third) {
                if (first == 'A') alice++;
                else bob++;
            }
        }
        return alice - bob > 0;
    }
}
