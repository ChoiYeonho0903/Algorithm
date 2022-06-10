package baekjoon.fastcampus.topological_sort;

import java.util.*;
import java.io.*;

public class G3_14676 {
    static StringBuilder sb = new StringBuilder("King-God-Emperor");
    static int N;
    static int M;
    static int K;
    static ArrayList<Integer>[] lists;
    static int[] inDeg;
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
        lists = new ArrayList[N+1];
        inDeg = new int[N+1];
        satisfaction = new int[N+1];
        cnt = new int[N+1];
        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            inDeg[y]++;
        }

        boolean tf = true;
        for(int i = 0; i < K; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == 1) {
                if(satisfaction[y] < inDeg[y]) {
                    tf = false;
                    break;
                }
                cnt[y]++;
                if(cnt[y] == 1) {
                    for(int k : lists[y]) {
                        satisfaction[k]++;
                    }
                }
            } else {
                if(cnt[y]==0) {
                    tf = false;
                    break;
                }
                cnt[y]--;
                if(cnt[y] == 0) {
                    for(int k : lists[y]) {
                        satisfaction[k]--;
                    }
                }
            }
        }
        if(!tf) sb = new StringBuilder("Lier!");
        System.out.println(sb);
    }
}
