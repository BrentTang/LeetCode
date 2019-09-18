package medium;

import org.junit.Test;

/**
 * @author Brent
 * @title: SearchInRotatedSortedArray
 * @projectName LeetCode
 * @date 2019/9/18 14:21
 * @description: 33. 搜索旋转排序数组
 *  假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 *  输入: nums = [4,5,6,7,0,1,2], target = 0
 *  输出: 4
 * 示例 2:
 *  输入: nums = [4,5,6,7,0,1,2], target = 3
 *  输出: -1
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) return mid;
            // 旋转后肯定会出现有一半的数据会不是单调递增
            // 在单调递增区间
            if (nums[start] < nums[mid]) {
                // 如果target介于start与mid之间则end=mid
                if (nums[start] <= target && nums[mid] >= target)
                    end = mid;
                else
                    start = mid;
            } else {
                // 非单调递增
                // target介于mid与end之间
                if (nums[mid] <= target && nums[end] >= target)
                    start = mid;
                else
                    end = mid;
            }
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 1;
        int re = search(nums, target);
        System.out.println(re);
    }
}
