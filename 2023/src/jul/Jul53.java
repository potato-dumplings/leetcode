package jul;

public class Jul53 {

    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE, prev = 0;
        for (int num : nums) {
            prev = Math.max( prev + num, num );
            answer = Math.max( answer, prev );
        }

        return answer;
    }

}
