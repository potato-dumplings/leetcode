package jul;

public class Jul771 {

    public int numJewelsInStones(String jewels, String stones) {
        boolean[] jewel = new boolean['z' - 'A' + 1];
        for (char c : jewels.toCharArray()) {
            jewel[c - 'A'] = true;
        }

        int answer = 0;
        for (char c : stones.toCharArray()) {
            answer += (jewel[c - 'A'] ? 1 : 0);
        }
        return answer;

//        // 把 jewels 转换成字符集合 mask
//        long mask = 0;
//        for (char c : jewels.toCharArray())
//            mask |= 1L << (c & 63);
//        // 统计有多少 stones[i] 在集合 mask 中
//        int ans = 0;
//        for (char c : stones.toCharArray())
//            ans += mask >> (c & 63) & 1;
//        return ans;
//        作者：灵茶山艾府
//        链接：https://leetcode.cn/problems/jewels-and-stones/solutions/2356253/ben-ti-zui-you-jie-xian-xing-shi-jian-ch-ddw3/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

}
