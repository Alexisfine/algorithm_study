package leetcode_questions.companies.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') continue;
                if (!rowMap.containsKey(row)) rowMap.put(row, new HashSet<>());
                if (!colMap.containsKey(col)) colMap.put(col, new HashSet<>());
                boolean r1 = rowMap.get(row).add(board[row][col]);
                boolean r2 = colMap.get(col).add(board[row][col]);
                int boxRow = row / 3;
                int boxCol = col / 3;
                int box = boxRow * boxCol + boxCol;
                if (!boxMap.containsKey(box)) boxMap.put(box, new HashSet<>());
                boolean r3 = boxMap.get(box).add(board[row][col]);
                if (!(r1 && r2 && r3)) return false;
            }
        }
        return true;
    }
}
