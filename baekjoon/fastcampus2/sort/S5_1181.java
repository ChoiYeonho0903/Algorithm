package baekjoon.fastcampus2.sort;

import java.util.*;
import java.io.*;

public class S5_1181 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new String[N+1];

        for(int i = 1; i <= N; i++) {
            arr[i] = br.readLine();
        }

        NewComparator newComparator = new NewComparator();
        Arrays.sort(arr, 1, N+1, newComparator);

        for(int i = 1; i <= N; i++) {
            if(arr[i].equals(arr[i-1])) continue;
            sb.append(arr[i]).append("\n");
        }

        System.out.print(sb);
    }

    static class NewComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        }
    }
}
