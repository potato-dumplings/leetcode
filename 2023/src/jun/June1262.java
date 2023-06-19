package jun;

/**
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
public class June1262 {

    public static int maxSumDivThree(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            answer += num;
        }
        int diffAnswer = answer % 3;
        // 如果已经可以被3整除，直接返回
        if (diffAnswer == 0) {
            return answer;
        }

        // 排序一下
        // 用来找最小的那个差值
        // 需要1，就找最小的1和最小的两个2。需要2就找最小的2和最小的两个1+1。
        // 以 [2,6,2,2,7]举例。最后的结果是19。那么就需要19%3 == 2。最小的(2 == Math.min(2 + 2, 7)) = 4
        quickSort( nums );

        // one代表需要的diffAnswer（需要1或者2的最小单个值）
        // two 同理
        int minOne = Integer.MAX_VALUE, minTwo = 0;
        boolean towCompleted = false;

        for (int num : nums) {
            int curr = num % 3;
            if (curr == 0) {
                continue;
            }
            if (curr == diffAnswer) {
                minOne = Math.min( num, minOne);
            } else if (minTwo % 3 != diffAnswer) {
                if (minTwo != 0) {
                    towCompleted = true;
                }
                minTwo += num;
            } else if (num > minOne || (towCompleted && num >= minTwo)) {
                break;
            }
        }
        if (minTwo % 3 != diffAnswer) {
            minTwo = Integer.MAX_VALUE;
        }

        if (minOne == Integer.MAX_VALUE && minTwo == Integer.MAX_VALUE) {
            return 0;
        }
        return answer - Math.min( minOne, minTwo );
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(arr, left, right);
        quickSortHelper(arr, left, pivotIndex - 1);
        quickSortHelper(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public static void main(String[] args) {
//        System.out.println( maxSumDivThree(new int[]{3,6,5,1,8}) );
//        System.out.println( maxSumDivThree(new int[]{4}) );
//        System.out.println( maxSumDivThree(new int[]{1,2,3,4,4}) );
//        System.out.println( maxSumDivThree(new int[]{2,6,2,2,7}) );
//        System.out.println( maxSumDivThree(new int[]{972,944,817,475,436,623,900,268,25,263,627,799,38,943,968,17,813,139,772,333,498,593,567,556,550,40,4,862,915,935,366,253,994,893,47,211,332,854,73,694,37,63,789,785,419,129,170,404,854,424,712,784,539,697,478,978,509,76,528,65,194,352,986,713,730,223,858,366,71,18,60,8,835,70,349,905,446,593,909,592,95,280,900,887,303,245,612,708,7,58,564,577,718,410,512,637,535,432,332,770}) );
//    }

}
