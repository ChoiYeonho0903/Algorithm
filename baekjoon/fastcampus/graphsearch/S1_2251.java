package baekjoon.fastcampus.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_2251 {
    static StringBuilder sb = new StringBuilder();
    static int[] limit = new int[3];
    static boolean[][][] visited;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 0; i <3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[limit[0]+1][limit[1]+1][limit[2]+1];
        bfs(0, 0, limit[2]);
        Collections.sort(ans);
        for (Integer i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs (int A, int B, int C) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(new int[]{A, B, C}));
        visited[A][B][C] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.x[0] == 0) {
                ans.add(pair.x[2]);
            }
            for (int i = 0; i <3; i++) {
                for (int j = 0; j <3; j++) {
                    if (i==j) continue;
                    Pair nPair = pair.move(i, j);
                    if (visited[nPair.x[0]][nPair.x[1]][nPair.x[2]]) continue;
                    queue.add(nPair);
                    visited[nPair.x[0]][nPair.x[1]][nPair.x[2]] = true;
                }
            }
        }
    }

    static class Pair {
        int[] x;

        public Pair(int[] x) {
            this.x = new int[3];
            for (int i = 0; i <3; i++) {
                this.x[i] = x[i];
            }
        }

        public Pair move (int from, int to) {
            int[] nx = new int[]{x[0], x[1], x[2]};

            if (x[from]+x[to]>limit[to]) {
                nx[from] -= (limit[to]-nx[to]);
                nx[to] = limit[to];
                return new Pair(nx);
            } else {
                nx[to] += nx[from];
                nx[from] = 0;
                return new Pair(nx);
            }
        }
    }
}
