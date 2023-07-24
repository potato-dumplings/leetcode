package jul;

public class Jul42 {

    public static int trap(int[] height) {
        int answer = 0;
        int i = 0, n = height.length;
        for (;i < height.length; i++) {
            if (height[i] != 0) {
                break;
            }
        }

        int end = 0;

        while (i < n) {
            int j = i + 1, start = height[i];
            int sum = 0;
            while (j < n) {
                int curr = height[j];
                if (curr >= start) {
                    end = j;
                    answer += sum;
                    break;
                }
                sum += Math.abs( curr - start );
                ++j;
            }
            i = j;
        }

        --i;
        while ( i >= end ) {
            int j = i - 1, start = height[i];
            int sum = 0;
            while (j >= end) {
                int curr = height[j];
                if (curr >= start) {
                    answer += sum;
                    break;
                }
                sum += Math.abs( curr - start );
                --j;
            }
            i = j;
        }

        return answer;
    }

    public static void main(String[] args) {
        trap( new int[]{0,1,0,2,1,0,1,3,2,1,2,1} );
        trap( new int[]{4,2,0,3,2,5} );
    }

}
