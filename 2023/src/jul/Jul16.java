package jul;

import java.util.Arrays;

public class Jul16 {

    /**
     * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
     *
     * 返回这三个数的和。
     *
     * 假定每组输入只存在恰好一个解。
     *
     * 示例 1：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     *
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     *
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort( nums );

        // 如果最小的三个数字都大于target。那这三个数就是最接近的
        if (nums[0] + nums[1] + nums[2] > target) {
            return nums[0] + nums[1] + nums[2];
        }

        int n = nums.length;

        // 如果最小的三个数字都小于target。那这三个数就是最接近的
        if (nums[n - 3] + nums[n - 2] + nums[n -1] < target) {
            return nums[n - 3] + nums[n - 2] + nums[n -1];
        }

        int answer = Integer.MAX_VALUE, answer1 = Math.abs( answer - target );
        for1: for (int i = 0; i < n - 2; i++) {
            // 避免重复操作
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            };

            int numI = nums[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = numI + nums[j] + nums[k];
                // 如果有相同的，就直接返回
                if (sum == target) {
                    answer = target;
                    break for1;
                }
                if (Math.abs( sum - target ) < answer1) {
                    answer = sum;
                    answer1 = Math.abs( sum - target );
                }

                // 如果一步跨过了target。那prevSum和sum就是最接近的
                if (sum > target ) {
                    int k1 = k - 1;
                    while (k1 > j && nums[k1 - 1] == nums[k]) {
                        k1--;
                    }
                    k = k1;
                } else {
                    int j1 = j + 1;
                    while (j1 < k && nums[j1 + 1] == nums[j]) {
                        j1++;
                    }
                    j = j1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        threeSumClosest(new int[]{321,413,82,812,-646,-858,729,609,-339,483,-323,-399,-82,-455,18,661,890,-328,-311,520,-865,-174,55,685,-636,462,-172,-696,-296,-832,766,-808,-763,853,482,411,703,655,-793,-121,-726,105,-966,-471,612,551,-257,836,-94,-213,511,317,-293,279,-571,242,-519,386,-670,-806,-612,-433,-481,794,712,378,-325,-564,477,169,601,971,-300,-431,-152,285,-899,978,-419,708,536,-816,-335,284,384,-922,-941,633,934,497,-351,62,392,-493,-44,-400,646,-912,-864,835,713,-12,322,-228,340,-42,-307,-580,-802,-914,-142,575,-684,-415,718,-579,759,579,732,-645,525,114,-880,-603,-699,-101,-738,-887,327,192,747,-614,393,97,-569,160,782,-69,235,-598,-116,928,-805,-76,-521,671,417,600,-442,236,831,637,-562,613,-705,-158,-237,-299,808,-734,364,919,251,-163,-343,899}, 2218);
        threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2);
    }

}
