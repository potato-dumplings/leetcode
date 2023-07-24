package jul;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的环形整数数组nums，返回nums的非空 子数组 的最大可能和。
 *
 * 环形数组意味着数组的末端将会与开头相连呈环状。
 * 形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区nums中的每个元素一次。
 * 形式上，对于子数组nums[i], nums[i + 1], ..., nums[j]，不存在i <= k1, k2 <= j其中k1 % n == k2 % n。
 *
 */
public class Jul918 {

    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int[] newNums = new int[n];
        for (int i = 1; i <= n; i++) {
            newNums[i - 1] = nums[i % n];
        }

        int sum = 0, prevMax = 0, max = Integer.MIN_VALUE, prevMin = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = newNums[i];
            sum += num;
            prevMax = Math.max(prevMax + num, num);
            max = Math.max( prevMax, max );
            prevMin = Math.min( prevMin + num, num );
            min = Math.min( prevMin, min );
        }

        return sum == min ? max : Math.max(max, sum - min);
    }

    public static void main(String[] args) {
//        // -2 3 -2 1   3
//        System.out.println(maxSubarraySumCircular( new int[]{1,-2,3,-2} ));
//        // -3 5 5   10
//        System.out.println(maxSubarraySumCircular( new int[]{5,-3,5} ));
//        // -2 2 -3 3    3
//        System.out.println(maxSubarraySumCircular( new int[]{3,-2,2,-3} ));
//        // -1 2 -1 3    4
//        System.out.println(maxSubarraySumCircular( new int[]{3,-1,2,-1} ));
//        // 9 -3 6    15
//        System.out.println(maxSubarraySumCircular( new int[]{6,9,-3} ));

        // [-3,-2,-3]
        System.out.println(maxSubarraySumCircular( new int[]{-3,-2,-3} ));
        System.out.println(maxSubarraySumCircular( new int[]{-5,4,-6} ));
    }

}
