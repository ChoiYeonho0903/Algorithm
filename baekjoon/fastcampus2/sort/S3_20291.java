package baekjoon.fastcampus2.sort;

import java.io.*;
import java.util.*;

public class S3_20291 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, ".");
            String fileName = st.nextToken();
            list.add(st.nextToken());
        }

        Collections.sort(list);
        String s = list.get(0);
        int count = 1;
        for(int i = 1; i < N; i++) {
            if(list.get(i-1).equals(list.get(i))) {
                count++;
            } else {
                sb.append(s).append(" ").append(count).append("\n");
                s = list.get(i);
                count = 1;
            }
            if(i == N-1) {
                sb.append(s).append(" ").append(count).append("\n");
            }
        }

        System.out.print(sb);
    }
}
