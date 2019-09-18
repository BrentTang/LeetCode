package medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Brent
 * @title: FindFirstAndLastPositionOfElementInSortedArray
 * @projectName LeetCode
 * @date 2019/9/18 21:49
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 *  给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *  你的算法时间复杂度必须是 O(log n) 级别。
 *  如果数组中不存在目标值，返回 [-1, -1]。
 *
 *  示例 1:
 *   输入: nums = [5,7,7,8,8,10], target = 8
 *   输出: [3,4]
 *
 *  示例 2:
 *   输入: nums = [5,7,7,8,8,10], target = 6
 *   输出: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange1(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length < 1) return result;

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                int lcount = 0;
                int rcount = 0;
                while ((mid - ++lcount) >= 0 && nums[mid - lcount] == target);
                result[0] = mid - lcount + 1;
                while ((mid + ++rcount) <= nums.length - 1 && nums[mid + rcount] == target);
                result[1] = mid + rcount - 1;
                return result;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {5,5,5,7,7,8,8,10,10,10};
        int target = 7;
        //int[] re = searchRange1(nums, target);
        int[] re = searchRange(nums, target);
        System.out.println(Arrays.toString(re));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) return new int[]{-1,-1};

        int first = findFirst(nums, target);
        if (first == -1) return new int[]{-1,-1};
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    public int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    public int findLast(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }



}
