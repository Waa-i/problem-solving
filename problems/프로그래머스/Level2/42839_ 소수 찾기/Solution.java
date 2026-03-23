import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(String numbers) {
        var visited = new boolean[numbers.length()];
        var numberSet = new HashSet<Integer>();
        solve(numbers, "", visited, numberSet);
        return answer;
    }

    private void solve(String numbers, String res, boolean[] visited, Set<Integer> numberSet) {
        if(res.length() > 0) {
            var number = Integer.parseInt(res);
            if(!numberSet.contains(number)) {
                numberSet.add(number);
                if(isPrime(number)) {
                    ++answer;
                }
            }
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;

            solve(numbers, res + numbers.charAt(i), visited, numberSet);

            visited[i] = false;
        }
    }

    private boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}