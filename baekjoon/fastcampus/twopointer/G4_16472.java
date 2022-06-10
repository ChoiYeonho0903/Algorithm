package baekjoon.fastcampus.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_16472 {
    static int N;
    static String str;
    static int[] count = new int[26+1];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        int R = -1;
        int num = 0;
        for (int L = 0; L < str.length(); L++) {
            while (R+1<str.length() && num <= N) {
                R++;
                if (count[str.charAt(R)-'a']==0) {
                    if (num==N) {
                        R--;
                        break;
                    }
                    num++;
                }
                count[str.charAt(R)-'a']++;
            }
            ans = Math.max(ans, R-L+1);
            if (count[str.charAt(L)-'a'] == 1) {
                num--;
            }
            count[str.charAt(L)-'a']--;
        }
    }
}
