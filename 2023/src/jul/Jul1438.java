package jul;

import java.util.*;

public class Jul1438 {

    public static int longestSubarray(int[] nums, int limit) {
        // 最小为1
        int answer = 1;

        // 排序Deque
        Deque<int[]> sortDeque = new LinkedList<>();
        // 数据，下标
        sortDeque.add( new int[]{nums[0], 0} );

        for (int i = 1; i < nums.length; i++) {
            if (sortDeque.isEmpty()) {
                sortDeque.add( new int[]{nums[i], i} );
                continue;
            }

            int num = nums[i], removeIndex = Integer.MIN_VALUE;
            Iterator<int[]> reverseIterator = sortDeque.descendingIterator();
            while (reverseIterator.hasNext()) {
                int[] element = reverseIterator.next();
                if (Math.abs( element[0] - num ) <= limit) {
                    answer = Math.max( i - element[1] + 1, answer );
                } else {
                    removeIndex = element[1];
                    break;
                }
            }

            int index = i;
            if (removeIndex != Integer.MIN_VALUE) {
                while (!sortDeque.isEmpty() && sortDeque.peekFirst()[1] <= removeIndex) {
                    sortDeque.pollFirst();
                }
                if (!sortDeque.isEmpty()) {
                    index = sortDeque.peekLast()[1] + 1;
                }
            }

            if (!sortDeque.isEmpty() && sortDeque.peekLast()[0] == num) {
                index = sortDeque.pollLast()[1];
            }
            sortDeque.offer( new int[] {num, index} );
        }

        return answer;
    }

    public static void main(String[] args) {
        longestSubarray( new int[]{8,2,4,7}, 4 );
        longestSubarray( new int[]{10,1,2,4,7,2}, 5 );
        longestSubarray( new int[]{4,2,2,2,4,4,2,2}, 0 );
        longestSubarray( new int[]{1,5,6,7,8,10,6,5,6}, 4 );
    }

}
