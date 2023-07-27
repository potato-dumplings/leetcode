import java.util.Arrays;

public class Hot3 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) { return s.length(); }

        char[] charArray = s.toCharArray();

        int answer = 0;

        boolean[] exist = new boolean[128];

        int i = 0, j = i + 1, n = s.length();

        exist[charArray[i]] = true;

        while (i < j && j < n) {
            if (exist[charArray[j]]) {
                int charJ = charArray[j];
                while (i < j) {
                    exist[charArray[i]] = false;
                    if (charArray[i] == charJ) {
                        i++;
                        break;
                    }
                    i++;
                }
            }
            exist[charArray[j]] = true;
            j++;
            answer = Math.max( answer, Math.max( j - i, 1 ) );
        }

        return answer;
    }

}
