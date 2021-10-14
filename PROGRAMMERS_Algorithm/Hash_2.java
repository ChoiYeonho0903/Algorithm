package PROGRAMMERS_Algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Hash_2 {
    static String[] phone_book = {"119", "97674223", "1195524421"};
    public static void main(String[] args) {
        System.out.println(solution(phone_book));
    }

//    public static boolean solution(String[] phone_book) {
//        boolean answer = true;
//        Arrays.sort(phone_book, Collections.reverseOrder());
//        for (int i = 0; i < phone_book.length-1; i++) {
//            if(phone_book[i].indexOf(phone_book[i+1]) == 0) {
//                answer = false;
//            }
//        }
//        return answer;
//    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0,j))) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}
