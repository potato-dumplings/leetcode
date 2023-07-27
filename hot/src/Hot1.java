import java.util.HashMap;

public class Hot1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>((int)(nums.length / 0.75f) + 1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer index = map.get( target - num );
            if ( index != null ) {
                return new int[]{ index, i};
            }
            map.put( num, i );
        }

        return new int[0];
    }

}
