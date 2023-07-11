package jul;

import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 */
public class Jul15 {

    /**
     * 29s
     * @param nums
     * @return
     */
//    public static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//
//        List<List<Integer>> answers = new ArrayList<>();
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            int numberI = nums[i];
//            if (numberI > 1) {
//                break;
//            }
//            if (i > 0 && numberI == nums[i - 1]) {
//                continue;
//            }
//            // 双指针一下
//            int j = i + 1, k = nums.length - 1;
//
//            int numberJ = nums[j], numberK = nums[k];
//            // 开始向双方靠拢
//            whi1: while (j < k) {
//                int sum = numberI + numberJ + numberK;
//                if (sum == 0) {
//                    List<Integer> answer = new ArrayList<>(3);
//                    answer.add( numberI );
//                    answer.add( numberJ );
//                    answer.add( numberK );
//                    answers.add( answer );
//                    while (j < k) {
//                        if (nums[++j] != numberJ) {
//                            numberJ = nums[j];
//                            continue whi1;
//                        }
//                    }
//                    break;
//                } else if (sum < 0) {
//                    numberJ = nums[++j];
//                } else {
//                    numberK = nums[--k];
//                }
//            }
//        }
//
//        return answers;
//    }

    /**
     * 0s
     * @param args
     */
//    import java.util.AbstractList;
//    import java.util.ArrayList;
//    import java.util.Arrays;
//    import java.util.List;
//
//    class Solution {
//
//        private List<List<Integer>>result;
//        public List<List<Integer>> threeSum(int[] nums) {
//            return new AbstractList<List<Integer>>() {
//                @Override
//                public List<Integer> get(int index) {
//                    init();
//                    return result.get(index);
//                }
//
//                private void init() {
//                    if(result!=null) return;
//                    result= new ArrayList<>();
//                    int n=nums.length;
//                    Arrays.sort(nums);
//                    for(int i=0;i<n-2;i++){
//                        if(nums[i]>0){
//                            break;
//                        }
//                        if (i>0 && nums[i] == nums[i-1]) continue;
//                        int j=i+1;
//                        int k=n-1;
//                        while(j < k){
//                            int x=nums[i]+nums[j]+nums[k];
//                            if(x==0){
//                                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                                while(j<k&&nums[j]==nums[j+1]) j++;
//                                while(j<k&&nums[k]==nums[k-1]) k--;
//                                j++;
//                                k--;
//                            }
//                            else if(x>0){
//                                while(j<k&&nums[k]==nums[k-1]) k--;
//                                k--;
//                            }
//                            else{
//                                while(j<k&&nums[j]==nums[j+1]) j++;
//                                j++;
//                            }
//                        }
//                    }
//
//                }
//
//                @Override
//                public int size() {
//                    init();
//                    return result.size();
//                }
//            };
//        }
//    }

}
