package baekjoon.fastcampus2.graphsearch;

import java.util.*;
import java.io.*;

public class G5_2251 {
    static StringBuilder sb = new StringBuilder();
    static int[] limit = new int[3];
    static boolean[][][] visited;
    static boolean[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[limit[0]+1][limit[1]+1][limit[2]+1];
        ans = new boolean[limit[2]+1];
        bfs(0, 0, limit[2]);

        for(int i = 0; i <= limit[2]; i++) {
            if(ans[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(int a, int b, int c) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(new int[]{a, b, c}));
        visited[a][b][c] = true;
        ans[c] = true;

        while(!queue.isEmpty()) {
            State state = queue.poll();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(i != j) {
                        State move = state.move(i, j, limit);
                        if(visited[move.x[0]][move.x[1]][move.x[2]]) continue;
                        queue.add(move);
                        visited[move.x[0]][move.x[1]][move.x[2]] = true;
                        if(move.x[0] == 0) {
                            ans[move.x[2]] = true;
                        }
                    }
                }
            }
        }
    }

    static class State {
        int[] x;

        State(int[] X) {
            x = new int[3];
            for(int i = 0 ; i < 3; i++) {
                x[i] = X[i];
            }
        }

        State move(int from, int to, int[] limit) {
            int[] nX = new int[]{x[0], x[1], x[2]};
            if (x[from] + x[to] >= limit[to]) {
                nX[from] -= (limit[to] - x[to]);
                nX[to] = limit[to];
            } else {
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }
}
