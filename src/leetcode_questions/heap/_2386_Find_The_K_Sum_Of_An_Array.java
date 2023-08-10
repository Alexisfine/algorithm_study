package leetcode_questions.heap;

public class _2386_Find_The_K_Sum_Of_An_Array {
    public long kSum(int[] nums, int k) {
        return 0;
    }

    /*
    Very hard
    Amazon OA
    原问题：求任意数组第K大的序列和

    第一步：转化为正数数组第K小的序列和
    maxSum 是所有正数之和，次大sum必然是在所有正数序列上减去一个正数，或者加上一个没有进入队列的负数
    同理，第K大的sum值为maxSum序列中减去若干个的已存在的正数或（且）加上若干的为入队的负数
    因为减去正数就等于减去它的绝对值，加上负数就等于减去它的绝对值，所以第K大的sum值，等价于在maxSum的
    基础上减去若干个nums元素的绝对值
    故我们只要在nums的绝对值数组里挑出第K小的序列和即可

    第二步：构造一个正数数组从小到大的序列和
    将{nums[0],0}放在min heap中
    如果heap弹出的是{sum, i} sum是某个以nums[i]结尾的子序列之和, 那么将{sum - nums[i] + nums[i+1], i+1} 和
    {sum + nums[i+1], i+1}加入heap
    heap第k-1弹出的为第K大的序列和 （空集算第一个）
     */
}
