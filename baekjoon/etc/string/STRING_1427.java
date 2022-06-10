package baekjoon.etc.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class STRING_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <str.length(); i++) {
            arrayList.add(str.charAt(i)-'0');
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        for (int i = 0; i <arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
        }
        System.out.println("");
    }
}
