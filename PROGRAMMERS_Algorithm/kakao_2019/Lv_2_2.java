package PROGRAMMERS_Algorithm.kakao_2019;

import java.util.HashMap;
import java.util.Map;

public class Lv_2_2 {
    public String[] solution(String[] record) {String[] answer;
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