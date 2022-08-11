package baekjoon.fastcampus2.topological_sort;

import java.util.*;
import java.io.*;

public class G3_14676 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int K;
    static ArrayList<Integer>[] list;
    static int[] inDegree;
    static int[] satisfaction;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        inDegree = new int[N+1];
        satisfaction = new int[N+1];
        cnt = new int[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            inDegree[y]++;
        }

        boolean tf = false;
        sb.append("King-God-Emperor");
        for(int i = 0; i < K; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == 1) {
                if(satisfaction[y] < inDegree[y]) {
                    tf = true;
                }

                cnt[y]++;

                if(cnt[y] == 1) {
                    for(int z : list[y]) {
                        satisfaction[z]++;
                    }
                }
            } else {
                if(cnt[y] == 0) {
                    tf = true;
                }
                cnt[y]--;

                if(cnt[y] == 0) {
                    for(int z : list[y]) {
                        satisfaction[z]--;
                    }
                }
            }
            if(tf) {
                sb = new StringBuilder();
                sb.append("Lier!");
            }
        }
        System.out.println(sb);
    }
}
