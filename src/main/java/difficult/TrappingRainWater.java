package difficult;

import org.junit.Test;

/**
 * @author Brent
 * @title: TrappingRainWater
 * @projectName LeetCode
 * @date 2019/9/20 13:22
 * @description: 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 *  示例:
 *   输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 *   输出: 6
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int vol = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                vol += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                vol += rightMax - height[right];
                right--;
            }
        }
        return vol;
    }

    @Test
    public void test() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

}
