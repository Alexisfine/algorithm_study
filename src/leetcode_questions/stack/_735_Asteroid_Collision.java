package leetcode_questions.stack;

import java.util.Stack;

public class _735_Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int N = asteroids.length;
        for (int i = 0; i < N; i++) {
            int currentAsteroids = asteroids[i];
            if (!stack.isEmpty()) {
                handleCollision(stack, currentAsteroids);
            } else {
                stack.push(currentAsteroids);
            }
        }
        int M = stack.size();
        int[] res = new int[M];
        for (int i = M - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    private void handleCollision(Stack<Integer> stack, int currentAsteroids) {
        while (!stack.isEmpty() && (stack.peek() > 0 && currentAsteroids < 0)) {
            int lastAsteroids = stack.pop();
            if (lastAsteroids + currentAsteroids == 0) {
                return;
            }
            if (Math.abs(lastAsteroids) > Math.abs(currentAsteroids)) {
                currentAsteroids = lastAsteroids;
            }
        }
        stack.push(currentAsteroids);
    }
}
