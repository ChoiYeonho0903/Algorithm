package baekjoon.fastcampus2.twopointer;

import java.io.*;
import java.util.*;

public class G4_16472 {
    static int N;
    static String str;
    static int[] cnt = new int[26];
    static int kind = 0;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        int L = 0;
        for(int R = 0; R < str.length(); R++) {
            if(cnt[str.charAt(R) - 'a'] == 0) {
                kind++;
            }
            cnt[str.charAt(R) - 'a']++;

            while(kind > N) {
                cnt[str.charAt(L) - 'a']--;
                if(cnt[str.charAt(L) - 'a'] == 0) {
                    kind--;
                }
                L++;
            }

            ans = Math.max(ans, R-L+1);

        }
    }
}
