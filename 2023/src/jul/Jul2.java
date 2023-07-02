package jul;

public class Jul2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode currNode = answer;

        ListNode newL1 = l1, newL2 = l2;
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

        return answer.next;
    }

}
