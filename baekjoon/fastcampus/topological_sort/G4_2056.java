package baekjoon.fastcampus.topological_sort;

import java.util.*;
import java.io.*;

public class G4_2056 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] lists;
    static int[] time;
    static int[] completedTime;
    static int[] inDeg;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N+1];
        time = new int[N+1];
        completedTime = new int[N+1];
        inDeg = new int[N+1];
        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            time[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                int y = Integer.parseInt(st.nextToken());
                lists[y].add(i);
                inDeg[i]++;
            }
        }
        for(int i = 1; i <= N; i++) {
            if(inDeg[i] == 0) {
                queue.add(i);
                completedTime[i] = time[i];
            }
        }

        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : lists[x]) {
                inDeg[y]--;
                completedTime[y] = Math.max(completedTime[y], completedTime[x]);
                if(inDeg[y] == 0) {
                    queue.add(y);
                    completedTime[y] += time[y];
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(ans < completedTime[i]) {
                ans = completedTime[i];
            }
        }
        System.out.println(ans);
    }
}
