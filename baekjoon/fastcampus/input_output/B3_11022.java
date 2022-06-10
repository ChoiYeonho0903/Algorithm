package baekjoon.fastcampus.input_output;

import java.io.*;
import java.util.StringTokenizer;

public class B3_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i <T; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write("Case #"+(i+1)+": "+A+" + "+B+" = "+(A+B)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
