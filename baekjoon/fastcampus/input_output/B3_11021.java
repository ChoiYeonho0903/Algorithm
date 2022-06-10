package baekjoon.fastcampus.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B3_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i <T; i++) {
            String str = bf.readLine();
            st = new StringTokenizer(str, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.add(A+B);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Case #"+(i+1)+": " + list.get(i));
        }
    }
}
