package math;

public class RandomNumbers {
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int r01() {
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    public static int r17() {
        int res = 0;
        do {
            res = (r01() << 2) + (r01() << 1) + r01();
        } while (res == 7);
        return res + 1;
    }
}
