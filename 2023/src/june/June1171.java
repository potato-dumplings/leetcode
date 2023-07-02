package june;

import java.util.*;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 */
public class June1171 {

    public static ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> usedIndexNode = new ArrayList<>();

        ListNode curr = head;
        int index = 0;
        // 上一个节点的所有总和与对应的node
        Map<Integer, Integer> prevSumToNode = Collections.emptyMap();
        while (curr != null) {
            if (curr.val == 0) {
                curr = curr.next;
                continue;
            }

            final ListNode finalCurr = curr;
            // 上一个相反的index
            Integer prevCounterIndex = prevSumToNode.get( -curr.val );
            if (prevCounterIndex != null) {
                usedIndexNode.add( prevCounterIndex );
                usedIndexNode.add( index );
                Map<Integer, Integer> newPrevSumToNode = new HashMap<>();
                prevSumToNode.forEach( (sum, sumIndex) -> {
                    if ( sumIndex < prevCounterIndex ) {
                        newPrevSumToNode.put( sum + finalCurr.val, sumIndex );
                    }
                } );
                prevSumToNode = newPrevSumToNode;
            } else {
                Map<Integer, Integer> currSumToNode = new HashMap<>((int)((prevSumToNode.size() + 1) / 0.75f));
                prevSumToNode.forEach( (sum, sumIndex ) -> currSumToNode.put( sum + finalCurr.val, sumIndex ) );
                currSumToNode.put( curr.val, index );
                prevSumToNode = currSumToNode;
            }

            curr = curr.next;
            ++index;
        }

        index = 0;
        ListNode n = new ListNode(0, head);
        curr = n.next;
        ListNode prev = n;
        while (curr != null) {
            if (curr.val == 0) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        if (usedIndexNode.isEmpty()) {
            return n.next;
        }

        Collections.sort( usedIndexNode );

        int c = 1;
        int a = usedIndexNode.get( 0 ), b = usedIndexNode.get( 1 );

        prev = n;
        curr = n.next;
        while (usedIndexNode.size() >= c * 2 && curr != null) {
            if (index == a - 1) {
                prev = curr;
            } else if (index == b) {
                prev.next = curr.next;
                ++c;
                if (usedIndexNode.size() < c * 2) {
                    return n.next;
                }
                a = usedIndexNode.get( c * 2 - 2 );
                b = usedIndexNode.get( c * 2 - 1 );
            }
            curr = curr.next;
            index++;
        }

        return n.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode curr = this;
            List<Integer> list = new ArrayList<>();
            while (curr != null) {
                list.add( curr.val );
                curr = curr.next;
            }
            return list.toString();
        }
    }

    public static void main(String[] args) {
//        // [1,2,-3,3,1]
//        System.out.println( removeZeroSumSublists(new ListNode(1,
//                new ListNode(2,
//                        new ListNode(-3,
//                                new ListNode(3,
//                                        new ListNode(1)))
//                )
//        )));
//
//        // [1,2,3,-3,4]
//        System.out.println( removeZeroSumSublists(new ListNode(1,
//                new ListNode(2,
//                        new ListNode(3,
//                                new ListNode(-3,
//                                        new ListNode(4)))
//                )
//        )));
//
//        // [1,2,3,-3,-2]
//        System.out.println( removeZeroSumSublists(new ListNode(1,
//                new ListNode(2,
//                        new ListNode(3,
//                                new ListNode(-3,
//                                        new ListNode(-2)))
//                )
//        )));
//
//        System.out.println(removeZeroSumSublists( new ListNode(0) ));
//        System.out.println(removeZeroSumSublists( new ListNode(0, new ListNode(0)) ));
//        System.out.println(removeZeroSumSublists( new ListNode(-1, new ListNode(1, new ListNode(0, new ListNode(1)))) ));
//        System.out.println(removeZeroSumSublists( new ListNode( 1 ) ));
        // [1,1,5,-5,-5,0,4,-1,-1,4,5,-5]
        System.out.println(removeZeroSumSublists( new ListNode(1, new ListNode(1, new ListNode(5, new ListNode(-5,
                new ListNode(-5, new ListNode(0, new ListNode(4, new ListNode(-1, new ListNode(-1,
                        new ListNode(4, new ListNode(5, new ListNode(-5)))))))))))) ));
    }

}
