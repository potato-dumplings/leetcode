package jul;

import java.util.*;

public class Jul2208 {

    public static int halveArray(int[] nums) {
        // 计算总数
        double sum = 0;

        double[] newNums = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
            sum += nums[i];
        }

        double result = sum / 2d;

        // 进行大排序
        Arrays.sort(newNums);

        // 需要的结果
        int answer = 0, n = nums.length - 1, index = n;

        while (sum > result) {
            double max = newNums[n];
            int newIndex = index;
            for (int i = n; i >= index; i--) {
                if (newNums[i] > max) {
                    newIndex = i;
                    max = newNums[i];
                }
            }

            if (index - 1 >= 0 && max / 2d < newNums[index - 1] ) {
                index -= 1;
            }

            if (index == 0) {
                Arrays.sort( newNums );
                n = nums.length - 1;
                index = n;
            }

            newNums[newIndex] = max / 2d;
            sum -= newNums[newIndex];

            ++answer;
        }

        return answer;
    }

    public static void main(String[] args) {
//        halveArray( new int[]{5, 19, 8, 1} );
        halveArray( new int[]{3,8,20} );
    }

}
