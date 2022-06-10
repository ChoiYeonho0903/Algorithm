package baekjoon.fastcampus.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B3_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        while (true) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A==0 && B==0) break;
            list.add(A+B);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
