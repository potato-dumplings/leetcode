import java.util.Arrays;

public class Hot128 {

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int answer = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1, sum = 1;
            while (j < n) {
                if (nums[j] == nums[j - 1]) {j++; continue;}
                if (nums[j] - 1 != nums[j - 1]) {break;}
                ++sum;
                ++j;
            }
            answer = Math.max( sum, answer );
            i = j - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
//        longestConsecutive( new int[]{0, 1, 2} );
        longestConsecutive( new int[]{0, 2, 3} );
//        longestConsecutive( new int[]{100,4,200,1,3,2} );
//        longestConsecutive( new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3} );
//        longestConsecutive( new int[]{9,1,4,7,3,-1,0,5,8,-1,6} );
    }

}
