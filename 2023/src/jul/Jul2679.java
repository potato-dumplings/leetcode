package jul;

import java.util.Arrays;

/**
 * 给你一个下标从 0开始的二维整数数组nums。一开始你的分数为0。你需要执行以下操作直到矩阵变为空：
 *
 * 矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
 * 在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数中。
 * 请你返回最后的 分数。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [
 * [7,2,1],
 * [6,4,2],
 * [6,5,3],
 * [3,2,1]
 * ]
 * 输出：15
 * 解释：第一步操作中，我们删除 7 ，6 ，6 和 3 ，将分数增加 7 。下一步操作中，删除 2 ，4 ，5 和 2 ，将分数增加 5 。最后删除 1 ，2 ，3 和 1 ，将分数增加 3 。所以总得分为 7 + 5 + 3 = 15 。
 * 示例 2：
 *
 * 输入：nums = [[1]]
 * 输出：1
 * 解释：我们删除 1 并将分数增加 1 ，所以返回 1 。
 *
 */
public class Jul2679 {

    public static int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort( num );
        }

        int answer = 0;
        for (int j = nums[0].length - 1; j >= 0 ; j--) {
            int max = Integer.MIN_VALUE;
            for (int[] num : nums) {
                max = Math.max( num[j], max );
            }
            answer += max;
        }
        return answer;
    }

    /**
     * 快一倍的实例代码
     * @param nums
     * @return
     */
//    public static int matrixSum(int[][] nums) {
//        int N = nums[0].length;
//        int[] maxs = new int[N];
//        int[] map = new int[1020];
//        for(int[] ar : nums) {
//            int maxv = 0;
//            for(int v : ar) {
//                maxv = Math.max(maxv,v);
//                map[v] ++;
//            }
//            int n = N;
//            int minv = maxs[0];
//            for(int v=maxv; v>minv && n>0; v--) {
//                int c = map[v];
//                if(c == 0) continue;
//                map[v] = 0;
//                for(;c!=0;c--) {
//                    if(maxs[--n] < v)
//                        maxs[n] = v;
//                }
//            }
//        }
//        int res = 0;
//        for(int v : maxs)
//            res += v;
//        return res;
//    }


}
