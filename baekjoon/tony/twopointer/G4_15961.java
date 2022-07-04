package baekjoon.tony.twopointer;

import java.util.*;
import java.io.*;

public class G4_15961 {
    static int N;
    static int d;
    static int k;
    static int c;
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        twoPointer();
        System.out.println(max);
    }

    static void twoPointer() {
        int R = 0;
        for(int L = 1; L <= N; L++) {
            if(L != 1) {
                Integer value = map.get(arr[L - 1]);
                value--;
                if(value > 0) {
                    map.put(arr[L-1], value);
                } else {
                    map.remove(arr[L-1]);
                }
            }

            while(R+1 <= N+k-1 && R - L + 1 < k) {
                R++;
                int r = 0;
                if(R > N) {
                    r = R - N;
                } else {
                    r = R;
                }
                if(map.containsKey(arr[r])) {
                    Integer value = map.get(arr[r]);
                    map.put(arr[r], ++value);
                } else {
                    map.put(arr[r], 1);
                }
            }

            int tmp = 0;
            if(!map.containsKey(c)) {
                tmp = map.size() + 1;
            } else {
                tmp = map.size();
            }

            if (max < tmp) {
                max = tmp;
            }
        }
    }
}
