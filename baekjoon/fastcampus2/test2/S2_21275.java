package baekjoon.fastcampus2.test2;

import java.util.*;
import java.io.*;

public class S2_21275 {
    static StringBuilder sb = new StringBuilder();
    static long X = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        String A = st.nextToken();
        String B = st.nextToken();
        long ansVal = -1;
        long ansA = 0;
        long ansB = 0;

        for (int n = 2; n <= 36; n++) {
            long valA = possible(A, n);
            if(valA == - 1) continue;

            for(int m = 2; m <= 36; m++) {
                if(n == m) continue;
                long valB = possible(B, m);
                if(valB == -1) continue;
                if(valA != valB) continue;

                if (ansVal == -1) {
                    ansVal = valA;
                    ansA = n;
                    ansB = m;
                } else {
                    System.out.println("Multiple");
                    System.out.close();
                    return;
                }
            }
        }

        if (ansVal == -1) {
            sb.append("Impossible");
        } else {
            sb.append(ansVal).append(" ").append(ansA).append(" ").append(ansB);
        }

        System.out.println(sb);
    }

    static int convert(char x) {
        if ('0' <= x && x <= '9') {
            return x - '0';
        }
        return x - 'a' + 10;
    }

    // str 을 base 진법으로 변환이 가능하면 변환 결과를, 불가능하면 -1을 리턴하는 함수
    static long possible(String str, int base) {
        long res = 0;
        for(char c : str.toCharArray()) {
            if (convert(c) >= base) {
                return -1;
            }
            if (res > (X - convert(c)) / base) {
                return -1;
            }
            res = res * base + convert(c);
        }
        return res;
    }
}
