package BAEKJOON_Algorithm.input_output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B3_10951 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        List<Integer> list = new ArrayList<>();
        while (true) {
            String line = bufferedReader.readLine();
            if(line == null || line.equals("")) {
                break;
            }
            stringTokenizer = new StringTokenizer(line, " ");
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            list.add(a+b);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        bufferedReader.close();
    }
}
