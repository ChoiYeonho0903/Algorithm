package PROGRAMMERS_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class BF_1 {
    static int [] answers = {1,3,2,4,2};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[] answer;
        int[] count = new int[3];
        int[][] choice = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int index = 0;
        int max = 0;
        ArrayList<Integer> arrays = new ArrayList<>();
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <answers.length; j++) {
                int tmp = j%choice[i].length;
                if(choice[i][tmp] == answers[j])
                    count[i]++;
            }
        }
        for (int i = 0; i <count.length; i++) {
            if(max < count[i]) {
                index = i;
                max = count[i];
            }
        }
        arrays.add(index);
        for (int i = index; i <2; i++) {
            if(count[index] == count[i+1])
                arrays.add(i+1);
        }
        answer = new int[arrays.size()];
        for (int i = 0; i <arrays.size(); i++) {
            answer[i] = arrays.get(i)+1;
        }
        return answer;
    }
}
