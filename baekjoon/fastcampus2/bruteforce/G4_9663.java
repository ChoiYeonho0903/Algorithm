package baekjoon.fastcampus2.bruteforce;

import java.io.*;

public class G4_9663 {
    static int N;
    static int ans = 0;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        selected = new int[N+1];
        backTracking(1);
        System.out.println(ans);
    }

    static void backTracking(int depth) {
        if(depth == N+1) {
            ans++;
        }

        for(int i = 1; i <= N; i++) {
            if(promise(depth, i)) {
                selected[depth] = i;
                backTracking(depth+1);
                selected[depth] = 0;
            }
        }
    }

    static boolean promise (int y, int x) {
        boolean tf = true;
        for(int i = 1; i < y; i++) {
            if(selected[i] == x) {
                return false;
            }
            if(selected[i] + i == y + x) {
                return false;
            }
            if(selected[i] - i == x - y) {
                return false;
            }
        }
        return true;
    }
}
