package sort;

import org.junit.Test;

/**
 * @author Brent
 * @title: MergeSort
 * @projectName interview
 * @description: Implement Merge sort
 * @date 2019/6/6 17:11
 */
public class MergeSort {

    @Test
    public void testSelectSort() {
        /*int[] array = new int[]{5, 75, -2, 45, 0, 13, 8};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));*/
        //String s = "";
        int a = Integer.MAX_VALUE;
        System.out.println("a = " + a);
        a += 1;
        System.out.println("++a = " + a);
        System.out.println("test: " + (int) (2147483640 + 8));
        System.out.println("test2: " + (int) (-2147483648 - 8));
    }

    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + ((right - left) >>> 1);
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int lstart = left;
        int rstart = mid + 1;
        int tempIndex = 0;

        // 1.先把左右两边的数据按照顺序填充到temp
        while (lstart <= mid && rstart <= right) {
            if (array[lstart] < array[rstart]) {
                temp[tempIndex] = array[lstart];
                lstart++;
            } else {
                temp[tempIndex] = array[rstart];
                rstart++;
            }
            tempIndex++;
        }

        // 2.把左右两边的其中一边的数据全部填充到temp--(如果其中一边copy完毕，另一边还有数据)
        while (lstart <= mid) {
            temp[tempIndex] = array[lstart];
            tempIndex++;
            lstart++;
        }
        while (rstart <= right) {
            temp[tempIndex] = array[rstart];
            tempIndex++;
            rstart++;
        }

        // 3.把temp中的有序数据拷贝到array
        // 每一次拷贝的长度是当前的left到right
        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[tempIndex];
            tempIndex++;
            tempLeft++;
        }

    }

}
