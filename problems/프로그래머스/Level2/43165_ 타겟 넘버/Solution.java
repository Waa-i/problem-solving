class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        char[] ops = {'+', '-'};
        var result = new char[numbers.length];
        solve(0, numbers, target, ops, result);
        return answer;
    }

    private void solve(int count, int[] numbers, int target, char[] ops, char[] res) {
        if(count == numbers.length) {
            if(isTarget(numbers, target, res)) {
                ++answer;
            }
            return;
        }

        for(int i = 0; i < ops.length; i++) {
            res[count] = ops[i];
            solve(count + 1, numbers, target, ops, res);
        }
    }

    private boolean isTarget(int[] numbers, int target, char[] ops) {
        var sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(ops[i] == '-') {
                sum -= numbers[i];
            }
            else {
                sum += numbers[i];
            }
        }
        return sum == target;
    }
}