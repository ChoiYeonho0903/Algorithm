package baekjoon.fastcampus.bruteforce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//중복X, 순서O
public class S2_15663 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] num;
    static int[] selected;
    static boolean[] visited;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N+1];
        visited = new boolean[N+1];
        selected = new int[M+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        rec_func(1);
        System.out.println(sb);
    }

    static void rec_func(int depth) {
        if(depth == M+1) {
            for (int i = 1; i <=M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int lastNum = 0;
            for (int i = 1; i <=N; i++) {
                if(visited[i]) continue;

                if(lastNum == num[i]) continue;
                lastNum = num[i];

                selected[depth] = num[i];
                visited[i] = true;
                rec_func(depth+1);
                selected[depth] = 0;
                visited[i] = false;
            }
        }
    }
}
