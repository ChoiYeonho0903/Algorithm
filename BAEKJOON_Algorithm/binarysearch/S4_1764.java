package BAEKJOON_Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_1764 {
    static int N;
    static int M;
    static String[] notHeardName;
    static String[] notSeenName;
    static List<String> list = new ArrayList<>();
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        notHeardName = new String[N+1];
        for (int i = 1; i <=N; i++) {
            notHeardName[i] = br.readLine();
        }
        notSeenName = new String[M+1];
        for (int i = 1; i <=M; i++) {
            notSeenName[i] = br.readLine();
        }
        Arrays.sort(notSeenName, 1, M+1);
        for (int i = 1; i <=N; i++) {
            if(binarySearch(notHeardName[i])) {
                ans++;
                list.add(notHeardName[i]);
            }
        }
        Collections.sort(list);
        System.out.println(ans);
        for (String s : list) {
            System.out.println(s);
        }
    }

    static boolean binarySearch(String notHeardName) {
        int L = 1;
        int R = M;
        while (L<=R) {
            int mid = (L+R)/2;
            if(notSeenName[mid].equals(notHeardName)) {
                return true;
            } else if (notSeenName[mid].compareTo(notHeardName)<0){
                L = mid+1;
            } else {
                R = mid-1;
            }
        }
        return false;
    }
}
