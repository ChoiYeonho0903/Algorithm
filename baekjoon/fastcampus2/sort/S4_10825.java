package baekjoon.fastcampus2.sort;

import java.util.*;
import java.io.*;

public class S4_10825 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Grade[] grades;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grades = new Grade[N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            grades[i] = new Grade(name, korean, english, math);
        }

        Arrays.sort(grades);
        for(int i = 0; i < N; i++) {
            sb.append(grades[i].name).append("\n");
        }

        System.out.print(sb);

    }

    static class Grade implements Comparable<Grade> {
        String name;
        int korean;
        int english;
        int math;

        public Grade(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Grade g) {
            if(this.korean == g.korean) {
                if(this.english == g.english) {
                    if(this.math == g.math) {
                        return this.name.compareTo(g.name);
                    }
                    return g.math - this.math;
                }
                return this.english - g.english;
            }
            return g.korean - this.korean;
        }
    }
}
