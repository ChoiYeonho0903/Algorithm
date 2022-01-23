package BAEKJOON_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1015 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A;
    static int[] P;
    static Point[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        points = new Point[N];
        P = new int[N];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 0; i <N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, A[i]);
        }
        Arrays.sort(points);
        for (int i = 0; i <N; i++) {
            P[points[i].index] = i;
        }
        for (int i = 0; i <N; i++) {
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    static class Point implements Comparable{
        int index;
        int value;

        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            return this.value - p.value;
        }
    }
}
