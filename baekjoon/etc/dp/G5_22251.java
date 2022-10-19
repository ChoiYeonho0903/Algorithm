package baekjoon.etc.dp;

import java.util.*;
import java.io.*;

public class G5_22251 {
    static Map<Integer, int[]> number = new HashMap<>();
    static Map<String, Integer> changeNumber = new HashMap<>();
    static int N;
    static int K;
    static int P;
    static int X;
    static String zeroStr;
    static String preStr;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        input();

        init();

        recursion(0, new int[K], preStr);

        System.out.println(ans);
    }

    static boolean check(String pre, String post) {
        int total = 0;
        for(int i = 0; i < K; i++) {
            String p1 = pre.substring(i, i+1);
            String p2 = post.substring(i, i+1);
            total += changeNumber.get(p1+p2);
        }
        if(total <= P) return true;
        return false;
    }

    static void recursion(int depth, int[] selected, String pre) {
        if(depth == K) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < K; i++) {
                sb.append(selected[i]);
            }

            String post = sb.toString();
            int x = Integer.parseInt(post);
            if(post.equals(zeroStr) || post.equals(pre) || x > N) {
                return;
            }

            if(check(pre, sb.toString())) {
                ans++;
            }
            return;
        }

        for(int i = 0; i <= 9; i++) {
            selected[depth] = i;
            recursion(depth+1, selected, pre);
            selected[depth] = 0;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
    }

    static void init() {
        number.put(0, new int[]{1,1,1,1,1,1,0});
        number.put(1, new int[]{0,0,1,0,0,1,0});
        number.put(2, new int[]{0,1,1,1,1,0,1});
        number.put(3, new int[]{0,1,1,0,1,1,1});
        number.put(4, new int[]{1,0,1,0,0,1,1});
        number.put(5, new int[]{1,1,0,0,1,1,1});
        number.put(6, new int[]{1,1,0,1,1,1,1});
        number.put(7, new int[]{0,1,1,0,0,1,0});
        number.put(8, new int[]{1,1,1,1,1,1,1});
        number.put(9, new int[]{1,1,1,0,1,1,1});

        changeLEDInit(0, new int[2]);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++) {
            sb.append("0");
        }
        zeroStr = sb.toString();

        preStr = Integer.toString(X);
        sb = new StringBuilder();
        for(int i = 0; i < K-preStr.length(); i++) {
            sb.append("0");
        }
        sb.append(preStr);
        preStr = sb.toString();
    }

    static void changeLEDInit(int depth, int[] selected) {
        if(depth == 2) {
            int cnt = 0;
            int[] arr1 = number.get(selected[0]);
            int[] arr2 = number.get(selected[1]);
            for(int i = 0; i < 7; i++) {
                if(arr1[i] != arr2[i]) cnt++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(selected[0]).append(selected[1]);
            changeNumber.put(sb.toString(), cnt);
            return;
        }
        for(int i = 0; i <= 9; i++) {
            selected[depth] = i;
            changeLEDInit(depth+1, selected);
            selected[depth] = 0;
        }
    }
}