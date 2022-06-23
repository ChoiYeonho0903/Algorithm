package baekjoon.tony.data_structure_2;

import java.util.*;
import java.io.*;

public class S2_4358 {
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map = new HashMap<>();
    static PriorityQueue<String> queue = new PriorityQueue<>();
    static int totalCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            totalCount++;
            if(map.containsKey(str)) {
                Integer count = map.get(str);
                map.put(str, ++count);
            } else {
                queue.add(str);
                map.put(str, 1);
            }
        }

        while(!queue.isEmpty()) {
            String poll = queue.poll();
            Integer value = map.get(poll);
            double ratio = (double) value / (double) totalCount * 100;
            sb.append(poll).append(" ").append(String.format("%.4f", ratio)).append("\n");
        }

        System.out.print(sb);

    }
}
