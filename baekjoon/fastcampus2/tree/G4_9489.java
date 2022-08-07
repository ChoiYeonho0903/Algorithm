package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class G4_9489 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n == 0 && k ==0 ) {
                break;
            }
            int[] input = new int[n+1];
            int[] parent = new int[n+1];

            str = br.readLine();
            st = new StringTokenizer(str, " ");

            for(int i = 1; i <= n; i++) {
               input[i] = Integer.parseInt(st.nextToken());
            }


            parent[0] = -1;
            parent[1] = 0;
            int index = 1;
            for(int i = 2; i <= n; i++) {
                parent[i] = index;
                if(i+1 <= n && input[i+1] - input[i] != 1) {
                    index++;
                }
            }

            int kIdx = 0;
            for(int i = 1; i <= n; i++) {
                if(input[i] == k) {
                    kIdx = i;
                }
            }
            int ans = 0;
            for(int i = 1; i <= n; i++) {
                if(parent[parent[i]] == parent[parent[kIdx]] && parent[i] != parent[kIdx]) {
                    ans++;
                }
            }

            sb.append(ans).append("\n");

        }
        System.out.print(sb);
    }

}
