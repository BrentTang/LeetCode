package difficult;

/**
 * @author Brent
 * @title: ReverseNodesInKGroup
 * @projectName LeetCode
 * @date 2019/8/12 10:02
 * @description: 25. K 个一组翻转链表
 *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *  k 是一个正整数，它的值小于或等于链表的长度。
 *  如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *      示例 :
 *          给定这个链表：1->2->3->4->5
 *          当 k = 2 时，应当返回: 2->1->4->3->5
 *          当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        return helper(head, k);
    }

    public ListNode helper(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = helper(cur, k);
            while (count-- > 0) {
                ListNode l = head.next;
                head.next = cur;
                cur = head;
                head = l;
            }
            head = cur;
        }
        return head;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode startPre = dummy, end = head;
        for (int i = 1; end != null; i++) {
            if (i % k == 0) {
                end = reverse(startPre, end);
                startPre = end;
            }
            end = end.next;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode startPre, ListNode end) {
        ListNode cur = startPre.next, nextStart = cur.next, newHead = end.next;
        ListNode tail = startPre.next;
        while (cur != null && cur != end) {
            // 当前节点指向尾节点的下一个
            cur.next = newHead;
            end.next = cur;
            newHead = cur;
            // 继续取前面的节点
            cur = nextStart;
            // 前面节点更新
            nextStart = nextStart.next;
        }
        startPre.next = end;
        return tail;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
