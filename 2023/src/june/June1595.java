package june;

import java.util.ArrayList;
import java.util.List;

/**
 * 1595. 连通两组点的最小成本
 * 给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。
 *
 * 任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接成本。
 * 如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。
 * 换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。
 *
 * 返回连通两组点所需的最小成本。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：cost = [[15, 96], [36, 2]]
 * 输出：17
 * 解释：连通两组点的最佳方法是：
 * 1--A
 * 2--B
 * 总成本为 17 。
 * 示例 2：
 *
 *
 *
 * 输入：cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
 * 输出：4
 * 解释：连通两组点的最佳方法是：
 * 1--A
 * 2--B
 * 2--C
 * 3--A
 * 最小成本为 4 。
 * 请注意，虽然有多个点连接到第一组中的点 2 和第二组中的点 A ，但由于题目并不限制连接点的数目，所以只需要关心最低总成本。
 * 示例 3：
 *
 * 输入：cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
 * 输出：10
 *
 * 实例4：
 * cost = [[2, 5, 1], [3, 4, 7], [8, 2, 2], [6, 2, 4], [3, 8, 8]]
 * 11
 *
 * 题目要求给定两组点，每组点的个数分别为size1和size2，且size1 >= size2。每个点之间有连接成本，成本由一个大小为size1 x size2的矩阵cost给出，其中cost[i][j]表示第一组中的点i和第二组中的点j之间的连接成本。
 *
 * 要求找到连通这两组点所需的最小成本。连通的定义是第一组中的每个点至少与第二组中的一个点连接，第二组中的每个点至少与第一组中的一个点连接。
 *
 * 示例1中，给定的cost矩阵为[[15, 96], [36, 2]]，表示第一组中的点1与第二组中的点A的连接成本为15，点1与点B的连接成本为96，点2与点A的连接成本为36，点2与点B的连接成本为2。最佳的连通方法是点1与点A相连，点2与点B相连，总成本为17。
 *
 * 示例2中，给定的cost矩阵为[[1, 3, 5], [4, 1, 1], [1, 5, 3]]，表示第一组中的点1与第二组中的点A的连接成本为1，点1与点B的连接成本为3，点1与点C的连接成本为5，点2与点A的连接成本为4，点2与点B的连接成本为1，点2与点C的连接成本为1，点3与点A的连接成本为1，点3与点B的连接成本为5，点3与点C的连接成本为3。最佳的连通方法是点1与点A相连，点2与点B相连，点2与点C相连，点3与点A相连，最小成本为4。
 *
 * 示例3中，给定的cost矩阵为[[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]，表示第一组中的点1与第二组中的点A的连接成本为2，点1与点B的连接成本为5，点1与点C的连接成本为1，点2与点A的连接成本为3，点2与点B的连接成本为4，点2与点C的连接成本为7，点3与点A的连接成本为8，点3与点B的连接成本为1，点3与点C的连接成本为2，点4与点A的连接成本为6，点4与点B的连接成本为2，点4与点C的连接成本为4，点5与点A的连接成本为3，点5与点B的连接成本为8，点5与点C的连接成本为8。最佳的连通方法是点1与点A相连，点2与点B相连，点3与点C相连，点4与点A相连，点5与点B相连，最小成本为10。
 *
 * 题目要求计算连通两组点所需的最小成本。
 * 
 * size1 == cost.length
 * size2 == cost[i].length
 * 1 <= size1, size2 <= 12
 * size1 >= size2
 * 0 <= cost[i][j] <= 100
 */
public class June1595 {

    public static int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size(), size2 = cost.get( 0 ).size();
        for (int i = 0; i < size1; i++) {
            List<Integer> line = cost.get( i );
            for (int j = 0; j < size2; j++) {

            }
        }
        return 0;


//        // 去找到所需矩阵每一列最合适的。
//        int[] size2MinArr = new int[size2];
//        Arrays.fill(size2MinArr, Integer.MAX_VALUE);
//        // 记录每一行的使用情况
//        boolean[] size1UsedArr = new boolean[size1];
//
//        for (int i = 0; i < size1; i++) {
//            size1UsedArr[i] = true;
//        }
//
//        int answer = 0;
//        // 先+每列最合适的
//        for (int min : size2MinArr) {
//            answer += min;
//        }
//
//        for (int i = 0; i < size1; i++) {
//            if (size1UsedArr[i]) {
//                continue;
//            }
//            // 该行中最小的值
//            int minValueInLine = Integer.MAX_VALUE;
//            for (Integer integer : cost.get( i )) {
//                minValueInLine = Math.min( integer, minValueInLine );
//            }
//            answer += minValueInLine;
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        // [[15, 96], [36, 2]]
        // 17
        System.out.println(connectTwoGroups( new ArrayList<List<Integer>>(){{
            add( new ArrayList<Integer>(){{
                add( 15 );
                add( 96 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 36 );
                add( 2 );
            }} );
        }} ));

        // [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
        // 4
        System.out.println(connectTwoGroups( new ArrayList<List<Integer>>(){{
            add( new ArrayList<Integer>(){{
                add( 1 );
                add( 3 );
                add( 5 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 4 );
                add( 1 );
                add( 1 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 1 );
                add( 5 );
                add( 3 );
            }} );
        }} ));

        // [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
        // 10
        System.out.println(connectTwoGroups( new ArrayList<List<Integer>>(){{
            add( new ArrayList<Integer>(){{
                add( 2 );
                add( 5 );
                add( 1 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 3 );
                add( 4 );
                add( 7 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 8 );
                add( 1 );
                add( 2 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 6 );
                add( 2 );
                add( 4 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 3 );
                add( 8 );
                add( 8 );
            }} );
        }} ));

        // [[2, 5, 1], [3, 4, 7], [8, 2, 2], [6, 2, 4], [3, 8, 8]]
        // 11
        System.out.println(connectTwoGroups( new ArrayList<List<Integer>>(){{
            add( new ArrayList<Integer>(){{
                add( 2 );
                add( 5 );
                add( 1 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 3 );
                add( 4 );
                add( 7 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 8 );
                add( 2 );
                add( 2 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 6 );
                add( 2 );
                add( 4 );
            }} );
            add( new ArrayList<Integer>(){{
                add( 3 );
                add( 8 );
                add( 8 );
            }} );
        }} ));
    }

}
