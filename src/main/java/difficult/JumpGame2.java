package difficult;

import org.junit.Test;

/**
 * @author Brent
 * @title: JumpGame2
 * @projectName LeetCode
 * @date 2019/9/20 15:57
 * @description: 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 *  示例:
 *   输入: [2,3,1,1,4]
 *   输出: 2
 *   解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *  说明:
 *   假设你总是可以到达数组的最后一个位置。
 *
 */
public class JumpGame2 {

    // time: O(n)  space: O(1)
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int step = 0;
        int cur = 0;
        int maxNext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(i + nums[i], maxNext);
            if (i == cur) {
                step++;
                cur = maxNext;
            }
        }
        return step;
    }

    // time: O(n)  space: O(1)
    public int BFS(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int step = 0;
        int cur = 0;
        int maxNext = 0;
        int i = 0;
        while (cur - i + 1 > 0) {
            step++;
            for (; i <= cur; i++) {
                maxNext = Math.max(maxNext, i + nums[i]);
                if (maxNext > nums.length - 1)
                    return step;
            }
            cur = maxNext;
        }
        return 0;
    }

    @Test
    public void test() {
        //int[] nums = {2,3,1,1,4};
        //System.out.println(jump(nums));
        int[] nums = {1,1,1,2,1,1,1,3,2,1,2,1};
        jumpTrace(nums);
    }

    public void jumpTrace(int[] nums) {
        if (nums == null || nums.length < 2) return ;

        int cur = 0;
        int maxNext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (maxNext < (i + nums[i])) {
                maxNext = i + nums[i];
                System.out.print((i + 1) + "->");
            }
            if (i == cur) {
                cur = maxNext;
            }
        }
        System.out.print("@");
    }

}
