package leetcode_questions.companies.amazon;

public class _1884_Egg_Drop_With_Two_Eggs_And_N_Floor {
    public int twoEggDrop(int n) {
        return (int) Math.ceil((-1 + Math.sqrt(1 + 8 * n)) / 2);
    }
}
