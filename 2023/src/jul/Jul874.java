package jul;

import java.util.*;

public class Jul874 {

    public static int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> obstaclesMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            obstaclesMap.putIfAbsent( obstacle[0], new HashSet<>() );
            obstaclesMap.get( obstacle[0] ).add( obstacle[1] );
        }

        int[] answerArr = new int[]{0, 0};

        char currDirection = 'N';
        char[][] direction = new char[26][2];
        // 北方的左边是西，右边是东
        direction['N' - 'A'][0] = 'W';
        direction['N' - 'A'][1] = 'E';
        // 东方的左边是东，右边是南
        direction['E' - 'A'][0] = 'N';
        direction['E' - 'A'][1] = 'S';
        // 南方的左边是东，右边是西
        direction['S' - 'A'][0] = 'E';
        direction['S' - 'A'][1] = 'W';
        // 西方的左边是南，右边是北
        direction['W' - 'A'][0] = 'S';
        direction['W' - 'A'][1] = 'N';

        int answer = 0;
        for (int command : commands) {
            if (command < 0) {
                currDirection = direction[currDirection - 'A'][command + 2];
            } else {
                int[] a;
                if (currDirection == 'N') {
                    a = new int[]{0, command};
                } else if (currDirection == 'E') {
                    a = new int[]{command, 0};
                } else if (currDirection == 'S') {
                    a = new int[]{0, -command};
                } else {
                    a = new int[]{-command, 0};
                }

                boolean oneAdd = a[0] > 0;
                for (int i = 1; i <= Math.abs(a[0]); i++) {
                    answerArr[0] += (oneAdd ? 1 : -1);
                    if (obstaclesMap.getOrDefault( answerArr[0], Collections.emptySet() ).contains( answerArr[1] )) {
                        answerArr[0] -= (oneAdd ? 1 : -1);
                        break;
                    }
                }
                boolean twoAdd = a[1] > 0;
                for (int i = 1; i <= Math.abs(a[1]); i++) {
                    answerArr[1] += (twoAdd ? 1 : -1);
                    if (obstaclesMap.getOrDefault( answerArr[0], Collections.emptySet() ).contains( answerArr[1] )) {
                        answerArr[1] -= (twoAdd ? 1 : -1);
                        break;
                    }
                }
            }
            answer = Math.max( answerArr[0] * answerArr[0] + answerArr[1] * answerArr[1], answer );
        }

        return answer;
    }

    public static void main(String[] args) {
//        robotSim( new int[]{-2,-1,8,9,6}, new int[][]{
//                {-1,3},{0,1},{-1,5},{-2,-4},{5,4},{-2,-3},{5,-1},{1,-1},{5,5},{5,2}
//        } );
    }

}
