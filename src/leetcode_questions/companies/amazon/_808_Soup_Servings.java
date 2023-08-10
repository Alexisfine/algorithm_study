package leetcode_questions.companies.amazon;

public class _808_Soup_Servings {
    double probability = 0.0;
    double[] power = new double[9];
    public double soupServings(int n) {
        dfs(n, n, 1);
        return probability;
    }

    private void dfs(int a, int b, int round) {
        return;
    }
}
