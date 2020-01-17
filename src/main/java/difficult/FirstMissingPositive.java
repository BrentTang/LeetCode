package difficult;

/**
 * @author Brent
 * @title: FirstMissingPositive
 * @projectName LeetCode
 * @date 2019/9/20 13:04
 * @description: 41. 缺失的第一个正数
 *  给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 *  示例 1:
 *   输入: [1,2,0]
 *   输出: 3
 *  示例 2:
 *   输入: [3,4,-1,1]
 *   输出: 2
 *  说明:
 *   你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    public int another(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        byte[] flag = new byte[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < nums.length)
                flag[nums[i] - 1] = 1;
        }

        for (int i = 0;i < flag.length;i++) {
            if (flag[i] == 0)
                return i + 1;
        }

        return flag.length + 1;
    }

}
