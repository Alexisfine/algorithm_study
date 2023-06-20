package leetcode_questions.array.two_pointers;

public class _1861_Rotating_The_Box {
    public char[][] rotateTheBox(char[][] box) {
        int height = box.length;
        int length = box[0].length;

        char[][] newBox = new char[length][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                newBox[j][height - i - 1] = box[i][j];
            }
        }

        int newLength = height;
        int newHeight = length;
        for (int i = 0; i < newLength; i++) {
            int maxDrop = 0;
            for (int j = newHeight - 1; j >= 0; j--) {
                if (newBox[j][i] == '*') {
                    maxDrop = 0;
                } else if (newBox[j][i] == '#') {
                    newBox[j + maxDrop][i] = '#';
                    if (maxDrop != 0) newBox[j][i] = '.';
                } else if (newBox[j][i] == '.'){
                    maxDrop++;
                }
            }
        }
        return newBox;

    }
}
