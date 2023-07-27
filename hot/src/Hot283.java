public class Hot283 {

    public static void moveZeroes(int[] nums) {
        int prevZeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ++prevZeroNum;
                continue;
            }
            if (prevZeroNum == 0) {
                continue;
            }
            nums[i - prevZeroNum] = nums[i];
        }

        if (prevZeroNum == nums.length) {
            return;
        }

        for (int i = nums.length - prevZeroNum; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        moveZeroes( new int[]{0,1,0,3,12} );
    }

}
