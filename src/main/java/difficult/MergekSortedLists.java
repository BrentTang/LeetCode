package difficult;

/**
 * @author Brent
 * @title: MergekSortedLists
 * @projectName LeetCode
 * @description: 23. 合并K个排序链表
 *  合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *      输入:
 *          [
 *            1->4->5,
 *            1->3->4,
 *            2->6
 *          ]
 *      输出: 1->1->2->3->4->4->5->6
 * @date 2019/8/12 8:10
 */

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergekSortedLists {

    /**
     * 使用分治
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;
        return split(lists, 0, lists.length - 1);
    }

    public ListNode split(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = left + ((right - left) >> 1);
        ListNode l1 = split(lists, left, mid);
        ListNode l2 = split(lists, mid + 1, right);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }

        l2.next = merge(l1, l2.next);
        return l2;
    }

    /**
     * 使用优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (l1, l2) -> l1.val - l2.val);

        for (ListNode l : lists) {
            if (l != null) queue.add(l);
        }
        ListNode dummy = new ListNode(0), cur = dummy;
        while (!queue.isEmpty()) {
            ListNode l = queue.poll();
            cur.next = l;
            cur = cur.next;
            if (l.next != null) {
                queue.add(l.next);
            }
        }

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
