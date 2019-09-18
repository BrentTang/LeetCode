package medium;

/**
 * @author Brent
 * @title: NextPermutation
 * @projectName LeetCode
 * @date 2019/8/13 14:02
 * @description: 31. 下一个排列
 *  实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *  如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *  必须原地修改，只允许使用额外常数空间。
 *
 *  以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 *      1,2,3 → 1,3,2
 *      3,2,1 → 1,2,3
 *      1,1,5 → 1,5,1
 *
 *      1. 从后往前找，找到第一位较小的数字(记录下标到firstSmall)
 *      2. 如果找到了，又开始从后往前找第一个比nums[firstSmall]大的数(记录下标到firstLarge)
 *      3. firstSmall与firstLarge进行值交换
 *      4. 将firstSmall后的所有元素倒置，得到下一个较大的序列
 *
 *      初 始：6   2   1   5   4   3   0
 *
 *      step1：6   2   1   5   4   3   0  (firstSmall = 2)
 *                     ^
 *      step2：6   2   1   5   4   3   0  (firstSmall = 2, firstLarge = 5)
 *                     ^           ^
 *      step3：6   2   3  [5   4   1   0] (firstSmall与firstLarge进行值交换)
 *                     ^           ^
 *      step4：6   2   3  [0   1   4   5] (firstSmall后面的元素进行倒置)

 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length < 1) return;
        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }

        // 递减数列
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[firstSmall] < nums[i]) {
                firstLarge = i;
                break;
            }
        }

        if (firstLarge != -1) {
            swap(nums, firstSmall, firstLarge);
            reverse(nums, firstSmall + 1, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
