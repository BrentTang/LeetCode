package easy;

/**
 * @author Brent
 * @title: RemoveDuplicatesFromSortedArray
 * @projectName LeetCode
 * @date 2019/8/12 18:02
 * @description: 26. 删除排序数组中的重复项
 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *  示例 1:
 *      给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *      函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *      你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

}
