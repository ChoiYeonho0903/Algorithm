package baekjoon.fastcampus.input_output;

import java.io.*;

public class B3_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String str = br.readLine();
            if(str == null || str.isEmpty()) break;
            bw.write(str+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
