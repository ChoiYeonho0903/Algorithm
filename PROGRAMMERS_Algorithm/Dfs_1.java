package PROGRAMMERS_Algorithm;

public class Dfs_1 {
    static int[] numbers = {1, 1, 1, 1, 1};
    static int target = 3;
    static int[] numbers_s;
    static int target_s;
    static int count;
    public static void main(String[] args) {
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        numbers_s = numbers;
        target_s = target;
        dfs(0, 0);
        answer = count;
        return answer;
    }

    public static void dfs (int level, int sum) {
        if(level == numbers_s.length) {
            if(sum == target_s) {
                count++;
            }
        }
        else {
            dfs(level+1, sum+numbers_s[level]);
            dfs(level+1, sum-numbers_s[level]);
        }
    }
}
