package PROGRAMMERS_Algorithm;

public class Greedy_2 {
    static String name = "JEROEN";
    public static void main(String[] args) {
        System.out.println(solution(name));
    }
    public static int solution(String name) {
        int answer = 0;
        boolean[] visited = new boolean[name.length()];
        int current_index = 0;
        while(true) {
            if(name.charAt(current_index) - 'A' <= 'Z' - name.charAt(current_index) +1) {
                answer += name.charAt(current_index) - 'A';
            }
            else {
                answer += ('Z' - name.charAt(current_index) +1);
            }
            visited[current_index] = true;
            int front = 0;
            int back = 0;
            for (int j = 1; j <name.length(); j++) {
                if(current_index+j>=name.length()) {
                    int index = current_index + j - name.length();
                    if (name.charAt(index) != 'A' && !visited[index]) {
                        front = j;
                        break;
                    }
                }
                else {
                    int index = current_index + j;
                    if (name.charAt(index) != 'A' && !visited[index]) {
                        front = j;
                        break;
                    }
                }
            }
            for (int j = 1; j <name.length(); j++) {
                if(current_index-j < 0) {
                    int index = current_index-j+name.length();
                    if(name.charAt(index)!='A' && !visited[index]) {
                        back = j;
                        break;
                    }
                }
                else {
                    int index = current_index-j;
                    if(name.charAt(index)!='A' && !visited[index]) {
                        back = j;
                        break;
                    }
                }
            }
            if(front==0 && back ==0) {
                break;
            }
            else {
                if(front <= back) {
                    current_index += front;
                    answer += front;
                }
                else {
                    current_index -= back;
                    if(current_index < 0) {
                        current_index += name.length();
                    }
                    answer += back;
                }
            }
        }
        return answer;
    }
}
