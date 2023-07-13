package jul;

import java.util.Arrays;

public class Jul931 {

    /**
     * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
     *
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
     * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
     * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int in = matrix.length, jn = matrix[0].length;

        int[] dp = new int[jn + 2];
        Arrays.fill( dp, Integer.MAX_VALUE );
        System.arraycopy( matrix[0], 0, dp, 1, jn );

        for (int i = 1; i < in; i++) {
            int prev = dp[0];
            for (int j = 1; j <= jn; j++) {
                int newMin = matrix[i][j - 1] + Math.min( Math.min( prev, dp[j] ), dp[j + 1] );
                prev = dp[j];
                dp[j] = newMin;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int num : dp) {
            answer = Math.min( num, answer );
        }

        return answer;
    }

}
