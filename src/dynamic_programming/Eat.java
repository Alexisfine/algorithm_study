package dynamic_programming;

public class Eat {
    public static String winner1(int n) {
        if (n < 5) {
            return (n == 0 || n == 2) ? "Second" : "First";
        }
        int base = 1;
        while (base <= n) {
            if (winner1(n-base).equals("Second")) return "First";
            base *= 4;
        }
        return "Second";
    }

    public static String winner2(int n) {
        return (n % 5 == 0 || n % 5 == 2) ? "Second" : "First";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " : " + winner1(i));
        }
    }
}
