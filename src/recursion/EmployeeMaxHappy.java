package recursion;

import java.util.List;

public class EmployeeMaxHappy {
    private static class Employee {
        int happy;
        List<Employee> next;
    }

    public static int maxHappy(Employee boss) {
        Info info = process(boss);
        return Math.max(info.maxWithoutYou, info.maxWithYou);
    }

    private static class Info {
        int maxWithYou;
        int maxWithoutYou;
        public Info(int maxWithYou, int maxWithoutYou) {
            this.maxWithYou = maxWithYou;
            this.maxWithoutYou = maxWithoutYou;
        }
    }

    private static Info process(Employee x) {
        if (x.next.isEmpty()) return new Info(x.happy, 0);
        int withX = x.happy;
        int withoutX = 0;
        for (Employee e : x.next) {
            Info info = process(e);
            withX += info.maxWithoutYou;
            withoutX += Math.max(info.maxWithoutYou, info.maxWithYou);
        }

        return new Info(withX, withoutX);
    }

}
