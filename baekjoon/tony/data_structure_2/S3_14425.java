package baekjoon.tony.data_structure_2;

import java.io.*;
import java.util.*;

public class S3_14425 {
    static Map<String, Integer> map = new HashMap<>();
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }
        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            if(map.containsKey(s)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
