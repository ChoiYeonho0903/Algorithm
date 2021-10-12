package PROGRAMMERS_Algorithm;


import java.util.Arrays;

public class Hash_1 {
    static String[] participant = {"leo", "kiki", "eden"};
    static String[] completion = {"eden", "kiki"};
    public static void main(String[] args) {
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Boolean tf = false;
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                answer = participant[i];
                tf = true;
                break;
            }
        }
        if(!tf) {
            answer = participant[participant.length-1];
        }
        return answer;
    }
}
