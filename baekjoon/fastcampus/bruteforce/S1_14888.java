package baekjoon.fastcampus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복X, 순서O
public class S1_14888 {
    static int N;
    static int[] A;
    static int[] op = new int[4];
    static int[] count = new int[4];
    static int[] selected;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        selected = new int[N - 1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
            count[i] = op[i];
        }
        rec_func(0, A[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void rec_func(int k, int value) {
        if (k == N-1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 0; i < 4; i++) {
                if (count[i] >= 1) {
                    selected[k] = i;
                    count[i]--;
                    int cal = calculate(value, i, k);
                    rec_func(k+1, cal);
                    count[i]++;
                }
            }
        }
    }

    static int calculate(int value, int operator, int k) {
        if(operator == 0)
            value += A[k+1];
        if(operator == 1)
            value -= A[k+1];
        if(operator == 2)
            value *= A[k+1];
        if(operator == 3)
            value /= A[k+1];

        return value;
    }
}
