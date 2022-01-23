package BAEKJOON_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_20291 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static File[] files;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, ".");
            String fileName = st.nextToken();
            String fileExtension = st.nextToken();
            if(map.containsKey(fileExtension)) {
                Integer count = map.get(fileExtension);
                map.put(fileExtension, count+1);
            } else {
                map.put(fileExtension, 1);
            }
        }
        files = new File[map.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            files[i] = new File(entry.getKey(), entry.getValue());
            i++;
        }
        Arrays.sort(files);
        for (int j = 0; j < files.length; j++) {
            sb.append(files[j].fileExtension).append(" ").append(files[j].count).append("\n");
        }
        System.out.print(sb.toString());
    }
    static class File implements Comparable{
        String fileExtension;
        int count;

        public File(String fileExtension, int count) {
            this.fileExtension = fileExtension;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {
            File f = (File) o;
            return this.fileExtension.compareTo(f.fileExtension);
        }
    }
}
