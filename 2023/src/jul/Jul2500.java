package jul;

import java.util.Arrays;
import java.util.Comparator;

public class Jul2500 {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort( ints );
        }
        int answer = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : grid) {
                max = Math.max( ints[j], max );
            }
            answer += max;
        }
        return answer;
    }

}
