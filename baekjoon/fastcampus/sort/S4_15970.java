package baekjoon.fastcampus.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_15970 {
    static int N;
    static Point[] points;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for (int i = 0; i <N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points);
        sum += points[1].position-points[0].position;
        sum += points[N-1].position-points[N-2].position;
        for (int i = 1; i <N-1; i++) {
            int min = Integer.MAX_VALUE;
            if(points[i-1].color == points[i].color) {
                if(points[i].position-points[i-1].position < min) {
                    min = points[i].position-points[i-1].position;
                }
            }
            if(points[i+1].color == points[i].color) {
                if(points[i+1].position-points[i].position < min) {
                    min = points[i+1].position-points[i].position;
                }
            }
            sum += min;
        }
        System.out.println(sum);
    }

    static class Point implements Comparable {
        int position;
        int color;

        public Point(int position, int color) {
            this.position = position;
            this.color = color;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            if(this.color!=p.color) {
                return this.color - p.color;
            } else {
                return this.position - p.position;
            }
        }
    }
}
