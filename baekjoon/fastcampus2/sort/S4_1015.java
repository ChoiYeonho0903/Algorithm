package baekjoon.fastcampus2.sort;

import java.util.*;
import java.io.*;

public class S4_1015 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Sequence[] A;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new Sequence[N];
        answer = new int[N];

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            A[i] = new Sequence(i, value);
        }

        Arrays.sort(A);
        for(int i = 0; i < N; i++) {
            answer[A[i].firstIndex] = i;
        }

        for(int i = 0; i  < N ; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);

    }

    static class Sequence implements Comparable<Sequence> {
        int firstIndex;
        int value;

        public Sequence(int firstIndex, int value) {
            this.firstIndex = firstIndex;
            this.value = value;
        }

        @Override
        public int compareTo(Sequence s) {
            return this.value - s.value;
        }
    }
}
