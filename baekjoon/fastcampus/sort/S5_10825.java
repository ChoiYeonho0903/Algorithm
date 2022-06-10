package baekjoon.fastcampus.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_10825 {
    static int N;
    static Performance[] performances;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        performances = new Performance[N];
        for (int i = 0; i <N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            performances[i] = new Performance(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(performances);
        for (int i = 0; i <N; i++) {
            System.out.println(performances[i].name);
        }
    }

    static class Performance implements Comparable {
        String name;
        int korean;
        int english;
        int math;

        public Performance(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Object o) {
            Performance p = (Performance) o;
            if(this.korean != p.korean) {
                return p.korean - this.korean;
            } else {
                if(this.english != p.english) {
                    return this.english - p.english;
                } else {
                    if(this.math != p.math) {
                        return p.math - this.math;
                    } else {
                        return this.name.compareTo(p.name);
                    }
                }
            }
        }
    }
}
