package baekjoon.fastcampus2.test;

import java.util.*;
import java.io.*;

public class G4_20166 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int K;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static String[][] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new String[N][M];
        for(int i = 0; i < N; i++) {
            str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.substring(j, j+1);
            }
        }

        for(int k = 0; k < K; k++) {
            str = br.readLine();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j].equals(str.substring(0, 1))) {
                        dfs(i, j, arr[i][j], 1, str);
                    }
                }
            }
            sb.append(cnt).append("\n");
            cnt = 0;
        }

        System.out.print(sb);
    }

    static void dfs(int y, int x, int depth, String str) {
        if(depth == str.length()) {
            cnt++;
            return;
        }
        for(int i = 0; i < 8; i++) {
            int ty = y + dy[i];
            if (ty < 0) {
                ty += N;
            } else if (ty >= N) {
                ty -= N;
            }
            int tx = x + dx[i];
            if (tx < 0) {
                tx += M;
            } else if (tx >= M) {
                tx -= M;
            }
            if(arr[ty][tx].equals(str.substring(depth, depth+1))) {
                dfs(ty, tx, depth+1, str);
            }
        }
    }
}
