package may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1187. 使数组严格递增
 * 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 *
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
 *
 * 如果无法让 arr1 严格递增，请返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * 输出：1
 * 解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
 * 示例 2：
 *
 * 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * 输出：2
 * 解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
 * 示例 3：
 *
 * 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * 输出：-1
 * 解释：无法使 arr1 严格递增。
 *
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 2000
 * 0 <= arr1[i], arr2[i] <= 10^9
 */
public class May1187 {
    private int[] a, b;
    /**
     * 用于存储之前计算过的结果
     */
    private Map<Integer, Integer> memo[];

    public int makeArrayIncreasing(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        // 对数组 b 进行排序，为了能够进行二分查找
        Arrays.sort(b);
        int n = a.length;
        memo = new HashMap[n];
        // 初始化 memo 数组，每个元素都是一个空的 HashMap 对象
        Arrays.setAll(memo, e -> new HashMap<>());
        // 假设 a[n-1] 右侧有个无穷大的数，计算将数组 a 转换为递增数组所需的最少替换次数
        int ans = dfs(n - 1, Integer.MAX_VALUE);
        // 返回最少替换次数，如果无法转换为递增数组，则返回 -1
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    /**
     * 计算将数组 a 中前 i 个元素转换为递增数组所需的最少替换次数，其中 pre 表示 a[i] 左侧的元素中最大的数
     */
    private int dfs(int i, int pre) {
        // 如果 i < 0，表示已经遍历完了数组 a，返回 0
        if (i < 0) return 0;
        if (memo[i].containsKey(pre)) {
            // 如果 memo[i] 中已经存储了 pre 的结果，直接返回该结果
            return memo[i].get(pre);
        }
        // 不替换 a[i] 的情况
        int res = a[i] < pre ? dfs(i - 1, a[i]) : Integer.MAX_VALUE / 2;

        // 二分查找 b 中小于 pre 的最大数的下标
        int k = lowerBound(b, pre) - 1;
        if (k >= 0) {
            // a[i] 替换成小于 pre 的最大数的情况
            res = Math.min(res, dfs(i - 1, b[k]) + 1);
        }
        // 将结果存储到 memo 数组中
        memo[i].put(pre, res);
        // 返回最少替换次数
        return res;
    }

    /**
     * 查找数组 nums 中第一个大于等于 target 的元素的下标，如果不存在这样的元素，则返回 nums.length
     * @param nums
     * @param target
     * @return
     */
    private int lowerBound(int[] nums, int target) {
        // 定义区间 (left, right)，初始值为 (-1, nums.length)
        int left = -1, right = nums.length;
        // 当区间不为空时，进行循环
        while (left + 1 < right) {
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                // 如果 nums[mid] < target，则缩小区间范围到 (mid, right)
                left = mid;
            } else {
                // 如果 nums[mid] >= target，则缩小区间范围到 (left, mid)
                right = mid;
            }
        }
        // 返回第一个大于等于 target 的元素的下标
        return right;
    }

}
