package june;

public class June2485 {

    public static int pivotInteger(int n) {
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = i + sum[i - 1];
        }
        int answer = -1, max = sum[n];
        for (int i = 1; i <= n; i++) {
            if (sum[i] + i == max + i - sum[i]) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println( pivotInteger( 8 ) );
    }

}
