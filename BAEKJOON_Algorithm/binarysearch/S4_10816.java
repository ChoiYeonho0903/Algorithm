package BAEKJOON_Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_10816 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static List<Integer> list;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (map.containsKey(tmp)) {
                int count = map.get(tmp);
                map.put(tmp, count+1);
            } else {
                map.put(tmp, 1);
            }
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i = 1; i <=M ; i++) {
            if (binarySearch(B[i])) {
                sb.append(map.get(B[i])).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }

    static boolean binarySearch(int X) {
        int L = 0;
        int R = list.size()-1;
        while (L<=R) {
            int mid = (L+R)/2;
            if(list.get(mid) == X) {
                return true;
            } else if (list.get(mid) < X) {
                L = mid+1;
            } else {
                R = mid-1;
            }
        }
        return false;
    }
}
