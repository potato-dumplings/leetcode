package jul;

public class Jul415 {

    public static String addStrings(String num1, String num2) {
        int num1Len = num1.length(), num2Len = num2.length(), len = Math.max( num1Len, num2Len );

        char[] answer = new char[len + 1];

        char[] num1Arr = num1.toCharArray(), num2Arr = num2.toCharArray();

        int remainder = 0;
        while (num1Len > 0 || num2Len > 0) {

            int number1 = (num1Len > 0) ? (char)(num1Arr[--num1Len] - '0') : 0;
            int number2 = (num2Len > 0) ? (char)(num2Arr[--num2Len] - '0') : 0;

            int sum = number1 + number2 + remainder;
            remainder = sum / 10;
            answer[len--] = (char)((sum % 10) + '0');
        }

        if (remainder > 0) {
            answer[0] = '1';
            return new String(answer);
        } else {
            return new String(answer, 1, answer.length - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println( addStrings( "11", "123" ) );
        System.out.println( addStrings( "456", "77" ) );
        System.out.println( addStrings( "456", "777" ) );
        System.out.println( addStrings( "0", "0" ) );
    }

}
