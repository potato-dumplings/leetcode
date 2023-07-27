public class Hot11 {

    public static int maxArea(int[] height) {
        int answer = 0;
        int i = 0, n = height.length, j = n - 1;

        while (i < j) {
            if (height[i] <= height[j]) {
                answer = Math.max( answer, height[i] * (j - i));
                i++;
            } else {
                answer = Math.max( answer, height[j] * (j - i));
                j--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        maxArea(new int[]{1, 1});
        maxArea(new int[]{1, 2, 1});
    }

}
