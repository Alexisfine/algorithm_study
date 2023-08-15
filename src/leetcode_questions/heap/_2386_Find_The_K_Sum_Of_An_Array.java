package leetcode_questions.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2386_Find_The_K_Sum_Of_An_Array {
    public record Pair(long sum, int index) {}
    public long kSum(int[] nums, int k) {
        long maxSum = 0;
        for (int x : nums) {
            if (x > 0) maxSum += x;
        }
        if (k == 1) return maxSum;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.sum, b.sum));
        pq.offer(new Pair(nums[0], 0));
        for (int i = 0; i < k - 1; i++) {
            Pair pair = pq.poll();
            long sum = pair.sum;
            int index = pair.index;
            if (i == k - 2) {
                return maxSum - sum;
            }
            if (index + 1 < nums.length) {
                pq.offer(new Pair(sum - nums[index] + nums[index + 1], index + 1));
                pq.offer(new Pair(sum + nums[index + 1], index + 1));
            }
        }
        return -1;
    }

    /*
    Very hard
    Amazon OA
    原问题：求任意数组第K大的序列和

    第一步：转化为求一个正数数组第K小的序列和
    显然maxSum是所有正数之和，次大sum必然是在所有正数序列上减去一个正数，或者加上一个没有进入队列的负数
    同理，第K大的sum值为maxSum序列中减去若干个的已存在的正数或（且）加上若干的为入队的负数
    因为减去正数就等于减去它的绝对值，加上负数就等于减去它的绝对值，所以第K大的sum值，等价于在maxSum的
    基础上减去若干个nums元素的绝对值
    故我们只要在nums的绝对值数组里挑出第K小的序列和即可

    第二步：构造一个正数数组从小到大的序列和
    将正数数组排序
    空集必然是最小的序列和，我们单独处理，然后

    将{nums[0],0}放在min heap中
    如果从PQ弹出的是{sum, i} （sum是某个以nums[i]结尾的子序列之和，那么将{sum - nums[i] + nums[i+1], i+1} 和
    {sum + nums[i+1], i+1}加入到PQ中 （记作操作1和操作2）

    从PQ弹出的第k-1的sum为第K小的序列和（空集为第一个）

    第三步：证明这个构造方法的可靠性
    首先，证明这个构造方法覆盖了所有的子序列 通过数学归纳法
    如果我们已经生成了nums[0],nums[1],...nums[i-1]结尾的子序列，那么能否通过操作1和2生成nums[i]结尾的子序列
    假设任意一个以nums[i]结尾的子序列，它的倒数第二个元素是任意的nums[k]，那么我们必然可以通过1次操作2并反复通过
    操作1得到

    其次，我们需要证明这个方法不会产生重复的子序列
    对于任意如{X,X,X,...,nums[k],nums[i}}的序列，如果k+1=i，那么它必然通过一次操作2得到，如果k+1!=i，那么它
    必然通过{X,X,X,...,nums[k],nums[i-1]}通过一次操作1得到

    最后，我们要证明这个构造方法生成的子序列是递增的 反证法
    假设某个序列A的和小于序列B的和，但是B先从队列弹出，但是这可能吗
    这意味着B在队列时A没有在队列中，既然A不在队列里，那么A的前驱状态A'也不再队列里，因为A'会比B先弹出，
    而A也会被加入到队列中。同理，A'的前驱A''也不会再队列中。。。

    但是所有的序列都是从{nums[0],0}开始的 -> contradiction

    综上，我们证明了这个构造方法可以一个不漏、不重复且从小到大的弹出所有的子序列之和
     */
}
