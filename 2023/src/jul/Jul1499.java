package jul;

import java.util.Arrays;
import java.util.Comparator;

public class Jul1499 {

    public static int findMaxValueOfEquation(int[][] points, int k) {

        Arrays.sort( points, (a1, a2) -> {
            if (a1[1] == a2[1]) {
                return a1[0] - a2[0];
            } else {
                return a1[1] - a2[1];
            }
        } );

        int prevIndex = points.length - 1, i = 0, j = prevIndex;
        while (i < j) {

        }

        return 1;
    }

    public static void main(String[] args) {
        findMaxValueOfEquation(new int[][]{{1,3},{2,0},{5,10},{6,-10}, {6, -9}}, 1);
    }

}
