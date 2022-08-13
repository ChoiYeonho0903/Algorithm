package baekjoon.fastcampus2.topological_sort;

import java.io.*;
import java.util.*;

public class G5_2056 {
    static int N;
    static ArrayList<Integer>[] list;
    static int[] time;
    static int[] inDegree;
    static int[] ans;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        time = new int[N+1];
        inDegree = new int[N+1];
        ans = new int[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                int x = Integer.parseInt(st.nextToken());
                list[i].add(x);
                inDegree[x]++;
            }
        }

        bfs();

        for(int i = 1; i <= N; i++) {
            max = Math.max(ans[i], max);
        }

        System.out.println(max);

    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                ans[i] = time[i];
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : list[x]) {
                ans[y] = Math.max(ans[y], ans[x] + time[y]);
                inDegree[y]--;
                if(inDegree[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }
}
