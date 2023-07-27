import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> answers = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int numberI = nums[i];
            if (numberI > 1) {
                break;
            }
            if (i > 0 && numberI == nums[i - 1]) {
                continue;
            }
            // 双指针一下
            int j = i + 1, k = nums.length - 1;

            int numberJ = nums[j], numberK = nums[k];
            // 开始向双方靠拢
            whi1: while (j < k) {
                int sum = numberI + numberJ + numberK;
                if (sum == 0) {
                    List<Integer> answer = new ArrayList<>(3);
                    answer.add( numberI );
                    answer.add( numberJ );
                    answer.add( numberK );
                    answers.add( answer );
                    while (j < k) {
                        if (nums[++j] != numberJ) {
                            numberJ = nums[j];
                            continue whi1;
                        }
                    }
                    break;
                } else if (sum < 0) {
                    numberJ = nums[++j];
                } else {
                    numberK = nums[--k];
                }
            }
        }

        return answers;
    }

}
