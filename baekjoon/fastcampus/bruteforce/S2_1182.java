package baekjoon.fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복X, 순서X
public class S2_1182 {
    static int N;
    static int S;
    static int[] num;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        rec_func(0, 0, 0);
        System.out.println(count);
    }

    static void rec_func(int depth, int start, int sum) {
        if(sum == S && depth>0) {
            count++;
        }
        for (int i = start; i <N; i++) {
            sum += num[i];
            rec_func(depth+1, i+1, sum);
            sum -= num[i];
        }
    }
}
