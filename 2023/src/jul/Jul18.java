package jul;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jul18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> answers = new ArrayList<>();

        int n = nums.length;

        for (int a = 0 ; a < n - 3; a++) {
            // 避免重复计算
            if (a != 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int numa = nums[a];
            for (int b = a + 1; b < n - 2; b++) {
                if (b != a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int numb = nums[b];
                int c = b + 1, d = n - 1;

                while (c < d) {
                    int numc = nums[c], numd = nums[d];
                    long sum = ((long) numa) + numb + numc + numd;
                    if (sum == target) {
                        answers.add( new ArrayList<Integer>(4){{
                            add( numa );
                            add( numb );
                            add( numc );
                            add( numd );
                        }} );
                        int newc = c + 1;
                        while (newc < d && nums[newc] == numc ) {
                            newc++;
                        }
                        c = newc;
                        int newd = d - 1;
                        while (newd > c && nums[newd] == numd ) {
                            newd--;
                        }
                        d = newd;
                    } else if (sum < target){
                        int newc = c + 1;
                        while (newc < d && nums[newc] == numc ) {
                            newc++;
                        }
                        c = newc;
                    } else {
                        int newd = d - 1;
                        while (newd > c && nums[newd] == numd ) {
                            newd--;
                        }
                        d = newd;
                    }
                }
            }
        }

        return answers;
    }

}
