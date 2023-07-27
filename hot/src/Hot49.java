import java.util.*;

public class Hot49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort( arr );
            map.putIfAbsent( new String(arr), new ArrayList<>() );
            map.get(new String(arr)).add( str );
        }

        List<List<String>> answer = new ArrayList<>();
        for (Map.Entry<String, List<String>> listEntry : map.entrySet()) {
            if (listEntry.getValue().isEmpty()) {
                continue;
            }
            answer.add( listEntry.getValue() );
        }

        return answer;
    }

}
