package easy;

import org.junit.Test;

/**
 * @author Brent
 * @title: SearchInsertPosition
 * @projectName LeetCode
 * @date 2019/9/19 13:26
 * @description: 35. 搜索插入位置
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *  你可以假设数组中无重复元素。
 *
 *  示例 1:
 *   输入: [1,3,5,6], 5
 *   输出: 2
 *  示例 2:
 *   输入: [1,3,5,6], 2
 *   输出: 1
 *  示例 3:
 *   输入: [1,3,5,6], 7
 *   输出: 4
 *  示例 4:
 *   输入: [1,3,5,6], 0
 *   输出: 0
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target)
                start = mid;
            else
                end = mid;
        }

        if (target <= nums[start]) return start;
        if (target > nums[end]) return end + 1;
        return end;
    }

    @Test
    public void test() {
        int[] nums = {1,3};
        int target = 1;
        int re = searchInsert(nums, 1);
        System.out.println(re);
    }

}
