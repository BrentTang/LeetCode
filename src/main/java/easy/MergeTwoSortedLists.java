package easy;

/**
 * @author Brent
 * @title: MergeTwoSortedLists
 * @projectName LeetCode
 * @description: 21. 合并两个有序链表
 *  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *  输入：1->2->4, 1->3->4
 *  输出：1->1->2->3->4->4
 * @date 2019/8/11 17:59
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        ListNode newHead = null, newCur = null, temp = null;

        while (l1 != null && l2 != null) {
            // 取较小的值
            if (l1.val < l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            // 将取到的值放入新链表尾部
            if (newHead != null) {
                newCur.next = temp;
                newCur = newCur.next;
            } else {
                newHead = newCur = temp;
            }
        }
        // 处理未访问完的链表
        if (l1 != null) {
            newCur.next = l1;
        } else {
            newCur.next = l2;
        }

        return newHead;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
