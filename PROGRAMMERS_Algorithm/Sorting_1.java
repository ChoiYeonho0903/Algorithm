package PROGRAMMERS_Algorithm;

import java.util.Arrays;

public class Sorting_1 {
    static int [] array = {1, 5, 2, 6, 3, 7, 4};
    static int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    public static void main(String[] args) {
        int[] answer = solution(array, commands);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i <commands.length; i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int index = commands[i][2];

            int [] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);
            answer[i] = arr[index-1];
        }
        return answer;
    }
}
