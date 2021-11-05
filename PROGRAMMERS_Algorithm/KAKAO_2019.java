package PROGRAMMERS_Algorithm;

import java.util.*;

public class KAKAO_2019 {
    static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(record)));
    }
    public static String[] solution(String[] record) {
        String[] answer;
        Map<String, String> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i <record.length; i++) {
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")) {
                if(map.containsKey(str[1])) {
                    map.replace(str[1], str[2]);
                }
                else {
                    map.put(str[1], str[2]);
                }
                count++;
            }
            else if(str[0].equals("Change")) {
                map.replace(str[1], str[2]);
            }
            else {
                count++;
                continue;
            }
        }
        answer = new String[count];
        int num = 0;
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")) {
                answer[num] = (map.get(str[1]) + "님이 들어왔습니다.");
                num++;
            }
            else if(str[0].equals("Leave")) {
                answer[num] = (map.get(str[1]) + "님이 나갔습니다.");
                num++;
            }
            else continue;
        }
        return answer;
    }
}
