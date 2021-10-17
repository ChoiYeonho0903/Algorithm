package PROGRAMMERS_Algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Dfs_3 {
    static String begin = "hit";
    static String target = "cog";
    static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    static String[] words_s;
    static int[][] matrix;
    static boolean[] visited;
    static int[] count;
    static int length;
    public static void main(String[] args) {
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        words_s = new String[words.length+1];
        words_s[0] = begin;
        for (int i = 1; i <words.length+1; i++) {
            words_s[i] = words[i-1];
        }
        matrix = new int[words.length+1][words.length+1];
        visited = new boolean[words.length+1];
        count = new int[words.length+1];
        length = words[0].length();
        for (int i = 0; i < words_s.length; i++) {
            for (int j = 0; j < words_s.length; j++) {
                int c = 0;
                if(i!=j) {
                    for (int k = 0; k <length; k++) {
                        if (words_s[i].charAt(k) == words_s[j].charAt(k)) {
                            c++;
                        }
                    }
                    if(c == length-1) {
                        matrix[i][j] = 1;
                        matrix[j][i] = 1;
                    }
                }
            }
        }
        answer = bfs(target);
        return answer;
    }
    static int bfs(String target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        count[0] = 0;
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            if(words_s[tmp].equals(target)) {
                return count[tmp];
            }

            for (int i = 0; i <matrix[tmp].length; i++) {
                if(matrix[tmp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    count[i] = count[tmp]+1;
                }
            }
        }
        return 0;
    }
}
