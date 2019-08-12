package medium;

/**
 * @author Brent
 * @title: SwapNodesInPairs
 * @projectName LeetCode
 * @description: 24. 两两交换链表中的节点
 *  给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *  <string>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</string>
 *      给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @date 2019/8/12 9:20
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), nextPair = null, front = head, after = dummy;
        dummy.next = head;
        while (front != null && front.next != null) {
            // 保存下一对需要交换的节点
            nextPair = front.next.next;
            // dummy->2
            after.next = front.next;
            // 2->1
            front.next.next = front;
            // 1->3
            front.next = nextPair;
            // front after 后移
            after = front;
            front = front.next;
        }
        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
