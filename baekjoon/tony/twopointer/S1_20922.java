package baekjoon.tony.twopointer;

import java.io.*;
import java.util.*;

public class S1_20922 {
    static int N;
    static int K;
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = twoPointer();
        System.out.println(ans);

    }

    private static int twoPointer() {
        int R = 0;
        int ans = 0;
        for(int L = 1; L <= N; L++) {
            if(map.containsKey(arr[L-1])) {
                Integer value = map.get(arr[L - 1]);
                value--;
                map.put(arr[L-1], value);
            }

            while(R+1 <= N) {
                if(map.containsKey(arr[R+1])) {
                    if(map.get(arr[R+1])+1 > K) {
                        break;
                    }
                }
                R++;
                int tmp = 0;
                if(map.containsKey(arr[R])) {
                    tmp = map.get(arr[R]);
                }

                map.put(arr[R], tmp+1);
            }

            ans = Math.max(ans, R - L + 1);
        }
        return ans;
    }
}
