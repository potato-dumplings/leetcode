package jul;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例1：
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 *
 *
 * 示例2：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 *
 *
 * 示例3：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 */
public class Jul445 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        new Jul445().addTwoNumbers( listNode1, listNode2 );
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode currNode = answer;

        ListNode newL1 = reverseNode( l1 ), newL2 = reverseNode( l2 );
        // 这里由于 "每个链表中的节点数在范围 [1, 100] 内"。必有值
        int l1Val = newL1.val, l2Val = newL2.val, remainder = 0;
        while (newL1 != null || newL2 != null) {
            int sum = l1Val + l2Val + remainder;
            if (sum >= 10) {
                sum = sum - 10;
                remainder = 1;
            } else {
                remainder = 0;
            }

            currNode.next = new ListNode(sum);
            currNode = currNode.next;

            if (newL1 != null && newL1.next != null) {
                newL1 = newL1.next;
                l1Val = newL1.val;
            } else {
                l1Val = 0;
                newL1 = null;
            }
            if (newL2 != null && newL2.next != null) {
                newL2 = newL2.next;
                l2Val = newL2.val;
            } else {
                l2Val = 0;
                newL2 = null;
            }
        }

        if (remainder != 0) {
            currNode.next = new ListNode(remainder);
        }

        return reverseNode( answer.next );
    }

    /**
     * 节点反转
     * @return 反转后的节点
     */
    private ListNode reverseNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newNode = new ListNode(0, head), currNode = head.next;
        newNode.next.next = null;
        while (currNode != null) {
            ListNode oldNextNode = newNode.next;
            newNode.next = currNode;
            currNode = currNode.next;
            newNode.next.next = oldNextNode;
        }
        return newNode.next;
    }

}
